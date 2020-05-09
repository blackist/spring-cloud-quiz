package org.blackist.cloudq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

// 开启断路器监控
@EnableTurbine
// 将服务注册到注册中心
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    // 要监控的断路器的服务的IP: [http://localhost:6001/hystrix]
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
