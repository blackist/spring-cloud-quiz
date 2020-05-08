package org.blackist.cloudq.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/retry")
    public String retry() {
        ResponseEntity<String> res = restTemplate.getForEntity("http://client-service/retry", String.class);
        System.out.println("=== Retry res: " + res.getBody());
        return res.getBody();
    }
}
