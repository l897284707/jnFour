package com.qfedu.nacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

/**
 * @version 1.0
 * 公众号：Java架构栈
 * @Author: 卓不凡
 */
@SpringBootTest
public class Demo {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Test
    public void demo(){
        for (int i = 0; i < 20; i++) {
            ServiceInstance choose = loadBalancerClient.choose("nacos-provider");
            System.out.println(choose.getPort());

        }
    }
}
