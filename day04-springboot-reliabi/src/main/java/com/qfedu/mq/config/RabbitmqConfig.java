package com.qfedu.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-24 11:10
 */
@Configuration
public class RabbitmqConfig {
    //交换机
    @Bean
    public Exchange directExchange(){
        return new DirectExchange("reliabi_direct_exchange");// 直接new指定的交换机

//        return ExchangeBuilder.directExchange("aa").durable(true).build(); //通过交换机的构建器来创建
    }
    //队列
    @Bean("queue")
    public Queue queue(){
        return new Queue("queue_demo01");
//        return QueueBuilder.durable("boot_direct_queue").build();
    }

    //绑定
    @Bean
    public Binding binding(Exchange exchange, @Qualifier("queue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("reliabi.insert").noargs();
    }

}
