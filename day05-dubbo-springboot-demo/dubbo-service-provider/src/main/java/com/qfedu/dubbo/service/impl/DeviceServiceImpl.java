package com.qfedu.dubbo.service.impl;

import com.qfedu.dubbo.service.DeviceService;
import org.apache.dubbo.config.annotation.Service;


/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-27 11:56
 */
@Service(timeout = 1500)
public class DeviceServiceImpl implements DeviceService {
    @Override
    public String getDevice(Integer id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String device ="device:"+id;
        return device;
    }
}
