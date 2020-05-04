package org.blackist.cloudq;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// 将服务注册到注册中心
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsumerApplication.class)
                .web(true)
                .run();
    }

    @Bean
    // 通过 Application Name 发现服务
    @LoadBalanced
    public RestTemplate restTemp() {
        return new RestTemplate();
    }


}
