package com.qfedu.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-23 21:21
 */
public class Producer {
    //队列名称
    public static final String QUEUE_NAME = "hello";
    //发消息
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //工厂IP链接RebbitMQ的队列
        factory.setHost("8.130.41.226");
        //用户名
        factory.setUsername("admin");
        //密码
        factory.setPassword("123");
        //创建连接
        Connection connection = factory.newConnection();
        //获取信道
        Channel channel = connection.createChannel();
        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化（磁盘） 默认消息存储在内存中
         * 3.该队列是否只提供一个消费者进行消费 是否进行消费共享，true可以多个消费者消费，false：只能一个消费者消费
         * 4.是否自动删除 最后一个消费者断开连接后 该队列最后一句是否自动删除 true自动删除 false不自动删除
         * 5.其他参数
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //发消息
        String message = "Hello RabbitMQ";
        /**
         * 发送一个消费
         * 1.发送到哪个交换机
         * 2.路由的Key值是哪个  本次是队列的名称
         * 3.其他参数信息
         * 4.发送消息的消息体
         */
        for (int i = 0; i < 10;i++) {

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        }
        System.out.println("消息发送完毕！");
        channel.close();
        connection.close();







    }



}
