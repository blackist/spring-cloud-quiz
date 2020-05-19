package org.blackist.cloudq.feign.hystrix;

import org.blackist.cloudq.feign.HelloFeignClient;
import org.springframework.stereotype.Component;

@Component
public class HelloFeignFeignClientHystrixFallback implements HelloFeignClient {

    @Override
    public String hello() {
        return "=== Hello's 降级策略";
    }

    @Override
    public String hi() {
        return "=== Hi's 降级策略";
    }
}
