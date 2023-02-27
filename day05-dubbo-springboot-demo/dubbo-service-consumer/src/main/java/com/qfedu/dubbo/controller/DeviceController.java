package com.qfedu.dubbo.controller;

import com.qfedu.dubbo.service.DeviceService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-27 11:48
 */
@RestController
@RequestMapping("device")
public class DeviceController {
    @Reference(version = "1.0",check = false,timeout = 500,loadbalance = "roundrobin",mock = "com.qfedu.dubbo.service.impl.DeviceServiceMock")
    private DeviceService deviceService;

    @GetMapping("/{id}")
    public String getDevice(@PathVariable("id")Integer id){

        String device = deviceService.getDevice(id);
        return device;
    }

}
