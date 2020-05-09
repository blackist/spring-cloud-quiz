package org.blackist.cloudq.api;

import org.blackist.cloudq.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHystrixController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello() {
        return helloService.callHello();
    }

    @RequestMapping(value = "/handler", method = {RequestMethod.GET})
    public String handler() {
        return helloService.handler();
    }

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi() {
        return helloService.callHi();
    }

    @RequestMapping(value = "/request", method = {RequestMethod.GET})
    public String request() {
        return helloService.request();
    }
}
