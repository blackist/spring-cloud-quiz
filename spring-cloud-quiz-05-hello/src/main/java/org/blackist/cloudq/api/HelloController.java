package org.blackist.cloudq.api;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello(@RequestHeader("userInfo") String userInfo,
                        @RequestHeader Map<String, String> headers,
                        @RequestHeader HttpHeaders httpHeaders) {
        System.out.println("=== Hello Gateway");
        System.out.println(userInfo);
        headers.forEach((key, value) -> {
            System.out.println(String.format("Header %s = %s", key, value));
        });
        return "Hello Gateway";
    }
}
