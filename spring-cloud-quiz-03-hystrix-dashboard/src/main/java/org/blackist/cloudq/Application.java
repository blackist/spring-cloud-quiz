package org.blackist.cloudq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

// 开启断路器监控
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    // 要监控的断路器的服务的IP: [http://localhost:6001/hystrix]
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
