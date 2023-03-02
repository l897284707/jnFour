package com.qfedu.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * TODO 类描述
 *
 * @author LiJH.
 * @date 2023/3/2 11:34
 */
@Configuration
public class MyLoadbancerConfig {
    //注入随机负载均衡器
    @Bean
    public ReactorLoadBalancer<ServiceInstance> reactorLoadBalancer(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory){
        String property = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return  new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(property, ServiceInstanceListSupplier.class),
                property);

    }
}
