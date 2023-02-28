package com.qfedu.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-28 09:47
 */
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
        System.out.println("consumer start");
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
