package com.qfedu.controller;

import com.qfedu.mapper.TypeMapper;
import com.qfedu.model.Device;
import com.qfedu.model.DeviceType;
import com.qfedu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 22:21
 */
@RestController
@CrossOrigin
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TypeService typeService;

    @GetMapping("findAll")
    @CrossOrigin
    public List<DeviceType> findAll(){
        List<DeviceType> all = typeService.findAll();
        return all;
    }
}
