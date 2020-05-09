package org.blackist.cloudq.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String getUser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello Hystrix");
        return "Hello Hystrix";
    }

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello Hystrix");
        return "Hello Hystrix";
    }

    @RequestMapping(value = "/request", method = {RequestMethod.GET})
    public String request() {
        System.out.println("Hello Hystrix request");
        return "Hello Hystrix request";
    }
}
