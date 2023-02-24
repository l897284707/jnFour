package com.qfedu.mq.confirm;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-24 11:11
 */

@Component
public class MyConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if(b){
            System.out.println("消息发送成功原因："+ s);
        }else {
            System.out.println("消息发送失败原因："+ s);
        }
    }
}
