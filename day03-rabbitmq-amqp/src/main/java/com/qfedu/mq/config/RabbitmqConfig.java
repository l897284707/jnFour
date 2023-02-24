package com.qfedu.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-24 09:58
 */
@Configuration
public class RabbitmqConfig {
    @Bean
    public Exchange directExchange(){
        return new DirectExchange("boot_direct_exchange");// 直接new指定的交换机

//        return ExchangeBuilder.directExchange("aa").durable(true).build(); //通过交换机的构建器来创建
    }
    //队列
    @Bean
    public Queue queue(){
        return new Queue("boot_direct_queue");
//        return QueueBuilder.durable("boot_direct_queue").build();
    }

    //绑定
    @Bean
    public Binding binding(Exchange exchange, Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("boot.test").noargs();
    }

}
