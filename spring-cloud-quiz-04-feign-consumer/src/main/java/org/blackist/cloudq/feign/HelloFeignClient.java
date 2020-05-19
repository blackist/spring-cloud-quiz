package org.blackist.cloudq.feign;

import org.blackist.cloudq.feign.hystrix.HelloFeignFeignClientHystrixFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "feign-provider", fallback = HelloFeignFeignClientHystrixFallback.class)
public interface HelloFeignClient {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    String hello();

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    String hi();
}
