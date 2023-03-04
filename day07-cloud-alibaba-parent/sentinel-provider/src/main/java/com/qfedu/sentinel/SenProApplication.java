package com.qfedu.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * 公众号：Java架构栈
 * @Author: 卓不凡
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SenProApplication {
    public static void main(String[] args) {
        SpringApplication.run(SenProApplication.class,args);
    }
}
