package com.qfedu;

import com.qfedu.config.MyLoadbancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * TODO 类描述
 *
 * @author LiJH.
 * @date 2023/3/2 10:16
 */
@SpringBootApplication
@EnableDiscoveryClient
@LoadBalancerClient(value = "nacos-provider",configuration = MyLoadbancerConfig.class)
public class NacosConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);

    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
