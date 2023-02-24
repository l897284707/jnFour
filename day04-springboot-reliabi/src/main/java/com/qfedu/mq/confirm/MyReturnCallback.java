package com.qfedu.mq.confirm;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-24 14:27
 */
public class MyReturnCallback implements RabbitTemplate.ReturnsCallback {
    @Override
    public void returnedMessage(ReturnedMessage returned) {
        String routingKey = returned.getRoutingKey();
        String exchange = returned.getExchange();
        Message message = returned.getMessage();
        byte[] body = message.getBody();
        System.out.println("交换机："+exchange+"路由key:"+routingKey+"消息："+new String(body));
    }
}
