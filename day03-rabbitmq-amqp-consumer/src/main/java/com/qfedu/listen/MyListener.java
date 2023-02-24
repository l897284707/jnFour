package com.qfedu.listen;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-24 09:53
 */
@Component
public class MyListener {
    @RabbitListener(queues = "boot_direct_queue")
    public void getmsg(String message){
        System.out.println("获取到的消息为："+message);
    }
}
