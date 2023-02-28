package com.qfedu.dubbo.service.impl;

import com.qfedu.dubbo.service.DevicService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-27 20:11
 */
@Service
public class DeviceServiceImpl implements DevicService {
    @Override
    public String getDevice(Integer id) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("服务调用者调用了："+id);
        return "device:"+id;
    }
}
