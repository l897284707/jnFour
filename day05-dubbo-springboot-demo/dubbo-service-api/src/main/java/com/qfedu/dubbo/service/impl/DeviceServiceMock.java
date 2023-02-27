package com.qfedu.dubbo.service.impl;

import com.qfedu.dubbo.service.DeviceService;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-27 16:16
 */
public class DeviceServiceMock implements DeviceService {
    @Override
    public String getDevice(Integer id) {
        System.out.println("我是托底函数，当服务调用失败时，返回");
        return "mock method";
    }
}
