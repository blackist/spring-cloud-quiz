package org.blackist.cloudq.api;

import org.blackist.cloudq.feign.HelloFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloFeignClient helloFeignClient;

    @RequestMapping(value ="/hello", method = {RequestMethod.GET})
    public String hello() {
        return helloFeignClient.hello();
    }

    @RequestMapping(value ="/hi", method = {RequestMethod.GET})
    public String hi() {
        return helloFeignClient.hi();
    }
}
