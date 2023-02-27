package com.qfedu.dubbo.service.impl;

import com.qfedu.dubbo.service.DeviceService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-27 14:58
 */
@Service(version = "1.0")
public class TimeoutDeviceServiceImpl implements DeviceService {
    @Override
    public String getDevice(Integer id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String device = "device:" + id;
        System.out.println("timeout服务提供者调用了：" + device);
        return device;
    }
}
