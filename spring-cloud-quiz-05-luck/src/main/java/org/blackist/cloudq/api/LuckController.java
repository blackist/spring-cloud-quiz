package org.blackist.cloudq.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckController {

    @RequestMapping(value = "/luck", method = {RequestMethod.GET})
    public String hello() {
        System.out.println("=== Luck Gateway");
        return "Luck Gateway";
    }
}
