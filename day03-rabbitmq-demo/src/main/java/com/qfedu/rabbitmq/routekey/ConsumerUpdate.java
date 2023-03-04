package com.qfedu.rabbitmq.routekey;

import com.qfedu.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-03-04 15:01
 */
public class ConsumerUpdate {
    /**
     * 订阅模式
     * @param args
     */
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建链接对象
        Connection connection = ConnectionUtil.getConnection();
        //创建频道
        Channel channel = connection.createChannel();
        /**
         * 声明队列
         * 参数1：队列名称
         * 参数2：是否定义持久化队列
         * 参数3：是否独占本次连接
         * 参数4：是否在不使用的时候自动删除队列
         * 参数5：队列其它参数
         */
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //路由key
                System.out.println("路由key为：" + envelope.getRoutingKey());
                //交换机
                System.out.println("交换机为：" + envelope.getExchange());
                //消息id
                System.out.println("消息id为：" + envelope.getDeliveryTag());
                //收到的消息
                System.out.println("消费者Update-接收到的消息为：" + new String(body, "utf-8"));
            }
        };
        //消息监听
        channel.basicConsume("direct_queue_update",true,defaultConsumer);

        //关闭资源
        //channel.close();
        //connection.close();
    }
}
