package com.qfedu.component;

import com.qfedu.utils.MakeDataUtil;
import com.qfedu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 19:22
 */
@Component
public class MyJob {
    @Value("${data.basic}")
    public int basic;
    @Autowired
    private MessageService messageService;
    @Scheduled(cron = "0/1 * * * * ?") //每隔5秒采集
    //每⑤分钟采集一次  0 5 * * * ？
    public void makeData(){
        if (basic>99){
            basic=10;
        }
        String data = MakeDataUtil.makeData(basic);
        System.out.println(data);
        basic++;
        //  messageService.analysisData(data); //调用业务层解析数据
    }
}
