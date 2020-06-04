package org.blackist.cloudq;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {

    private static String TOKEN = "token";

    /**
     * pre: Before routing
     * routing: routing
     * post: response
     * error:
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * order: priority, low value -> high proority
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * enable
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * concentrate logic code
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();

        HttpServletRequest request = context.getRequest();

        String token = request.getHeader("x-auth-token");
        boolean check = true;

        String uri = request.getRequestURI();
        // file no token ||
        if ("/luck-service/upload".equals(uri) || "/zuul/luck-service/upload".equals(uri)) {
            System.out.println("File upload, need no auth");
            check = false;
        }

        if (StringUtils.isBlank(token) && check) {
            System.out.println("=== No Token");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("=== no token");
            return null;
        } else {
            // get Token, -> Redis
            if (TOKEN.equals(token) || !check) {
                // decrypt-> userId_orgId_roleId, delivery to next step
                context.addZuulRequestHeader("userInfo", "001_01_01");
                context.addZuulRequestHeader("Param", "values");
            } else {
                context.setSendZuulResponse(false);
                context.setResponseStatusCode(401);
                context.setResponseBody("=== token failed");
                return null;
            }
        }
        return context;
    }
}
