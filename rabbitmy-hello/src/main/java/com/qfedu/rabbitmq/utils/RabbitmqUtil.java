package com.qfedu.rabbitmq.utils;
import com.rabbitmq.client.*;
/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-25 09:34
 */
public class RabbitmqUtil {
    //得到一个连接的 channel
    public static Channel getChannel() throws Exception{
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("8.130.41.226");
        factory.setUsername("admin");
        factory.setPassword("123");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
    }

}
