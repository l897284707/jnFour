package com.qfedu.dubbo.controller;

import com.qfedu.dubbo.service.DevicService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-27 20:22
 */
@RestController
@RequestMapping("device")
public class DeviceController {
    @Reference
    private DevicService devicService;

    @GetMapping("/{id}")
    public String getDevice(@PathVariable("id")Integer id){
        String device = devicService.getDevice(id);
        return device;
    }
}
