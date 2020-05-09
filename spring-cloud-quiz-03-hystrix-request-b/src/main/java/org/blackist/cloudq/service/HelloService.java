package org.blackist.cloudq.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.undertow.util.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callHelloFallback")
    public String callHello() {
        return restTemplate.getForObject("http://client-service/hello", String.class);
    }

    public String callHelloFallback() {
        System.out.println("=== Run Demotion... ");
        return "=== Run Demotion... ";
    }

    @HystrixCommand(fallbackMethod = "handlerFallback", ignoreExceptions = {BadRequestException.class})
    public String handler() {
        throw new RuntimeException("=== Runtime Error");
    }

    public String handlerFallback(Throwable e) {
        System.out.println("=== Error: " + e.getMessage());
        return "=== Get Exception, Run Demotion...";
    }

    @HystrixCommand(
            commandKey = "hiKey",
            fallbackMethod = "callHiFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "8000"),
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"), // Default: -1
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "30") // Demotion Threshold
            }
    )
    public String callHi() {
        return restTemplate.getForObject("http://client-service/hi", String.class);
    }

    public String callHiFallback() {
        System.out.println("=== Hi failed, Run Demotion");
        return "=== Hi failed, Run Demotion";
    }

    @HystrixCommand(fallbackMethod = "callRequestFallback")
    public String request() {
        return restTemplate.getForObject("http://client-service/request", String.class);
    }

    public String callRequestFallback() {
        System.out.println("=== Run Demotion... ");
        return "=== Run Demotion... ";
    }
}
