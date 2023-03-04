package com.qfedu.rabbitmq.ps;

import com.qfedu.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-03-04 14:06
 */
public class PublishSubscribeConsumerOne {
    /**
     * 订阅模式消息消费者
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
        channel.queueDeclare("fanout_queue_1",true, false, false,null);
        //创建消费者；并设置消息处理
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //路由器key
                System.out.println("路由key为："+envelope.getRoutingKey());
                //交换机
                System.out.println("交换机为:："+envelope.getExchange());
                //消息id
                System.out.println("消息id:"+envelope.getDeliveryTag());
                //收到的消息
                String message = new String(body, "UTF-8");
                System.out.println("One接收到消息："+message);
            }
        };
        //消息监听
        channel.basicConsume("fanout_queue_1",true,defaultConsumer);
        //关闭资源
//        channel.close();
//        connection.close();
    }
}
