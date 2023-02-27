package com.qfedu.rabbitmq.two;

import com.qfedu.rabbitmq.utils.RabbitmqUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-25 10:09
 */
public class Worker01 {
    //队列的名称
    public static final String QUEUE_NAME = "hello";
    public static void main(String[] args) throws Exception{
        Channel channel = RabbitmqUtil.getChannel();

        //消息的接收
        DeliverCallback deliverCallback = (consumerTag,message) -> {
            System.out.println("接收到的消息："+new String(message.getBody()));
        };
        //消息接收被取消时 执行下面的内容
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println(consumerTag+"消息者取消消费接口回调逻辑");

        };
        /**
         * 消费者消费消息
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答
         * 3.消费者未成功消费的回掉
         * 4.消费者取录消费的回调
         */
        System.out.println("C1等待接收消息....");
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback );

    }
}
