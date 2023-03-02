package com.qfedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-03-02 17:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApp.class, args);
        System.out.println("Nacos Consumer Application Started");
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
