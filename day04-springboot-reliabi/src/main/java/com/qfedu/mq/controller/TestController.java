package com.qfedu.mq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-24 11:11
 */
@RestController
@RequestMapping("devi")
public class TestController {
    @Autowired
    private RabbitTemplate rab;
    @Autowired
    private RabbitTemplate.ConfirmCallback confirmCallback;
    @Autowired
    private RabbitTemplate.ReturnsCallback returnsCallback;

    @GetMapping("send1")
    public String send1(){
        rab.setConfirmCallback(confirmCallback);
        rab.convertAndSend("reliabi_direct_exchange","reliabi.insert","测试消息到交换机是否成功");
        return "ok";
    }
    @GetMapping("send2")
    public String send2(){
        //设置confirm对象
        rab.setConfirmCallback(confirmCallback);
        //设置return对象 监测交换机到队列的过程
        rab.setReturnsCallback(returnsCallback);
        //发送消息
        rab.convertAndSend("reliabi_direct_exchange1","reliabi.update","测试消息交换机到队列是否成功");
        return "ok";
    }
}
