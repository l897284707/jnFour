package com.qfedu.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-24 09:51
 */
@SpringBootTest(classes = {RabbitmqApplication.class})
public class Demo {
    @Autowired
    private RabbitTemplate template;

    @Test
    public void test() {
        template.convertAndSend("boot_direct_exchange","boot.test","springboot-ampq整合发送消息");
    }
}
