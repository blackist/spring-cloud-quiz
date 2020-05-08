package org.blackist.cloudq.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "getByUrl")
    public String getByUrl() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> res = template.getForEntity("http://localhost:7001/provider/hello", String.class);
        return res.getBody();
    }


    @GetMapping(value = "getByName")
    public String getByName() {
        // http:// [服务名]provider-service/  [ContextPath]provider/  [Method]hello
        ResponseEntity<String> res = restTemplate.getForEntity("http://provider-service/provider/hello", String.class);
        return res.getBody();
    }


}





