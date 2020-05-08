package org.blackist.cloudq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

// 将服务注册到注册中心
@EnableDiscoveryClient
// 启动 Retry 重试机制
@EnableRetry
@SpringBootApplication
public class Application {

    @Bean
    @ConfigurationProperties(prefix = "custom.rest")
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory() {
        // HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        // factory.setConnectionRequestTimeout(1000);
        // factory.setConnectTimeout(250);
        // factory.setReadTimeout(3000);
        return new HttpComponentsClientHttpRequestFactory();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(httpComponentsClientHttpRequestFactory());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
