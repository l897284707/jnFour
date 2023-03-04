package com.qfedu.rabbitmq.util;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

import java.util.concurrent.TimeoutException;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-03-04 11:04
 */
public class ConnectionUtil {
    /**
     * 创建链接对象
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("8.130.41.226");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("jnqfedu");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123");
        //获得连接
        Connection connection = connectionFactory.newConnection();
        return connection;

    }
}
