package com.qfedu.controller;

import com.qfedu.mapper.DeviceMapper;
import com.qfedu.mapper.MessageMapper;
import com.qfedu.model.Device;
import com.qfedu.page.PageResult;
import com.qfedu.page.QueryPageBean;
import com.qfedu.page.Result;
import com.qfedu.service.DeviceService;
import com.qfedu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 19:38
 */
@RestController
@CrossOrigin
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private MessageService messageService;
    @Autowired
    private DeviceService deviceService;

    @PostMapping("findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult page = messageService.findPage(queryPageBean);
        return page;
    }

    @PostMapping("addDevice")
    public Result addProject(@RequestBody Device device){
        device.setCreatetime(new Date());
        device.setUpdatetime(new Date());
        int i = deviceMapper.insert(device);
        Result result = new Result();
        if (i>0){
            result.setFlag(true);
            result.setMessage("添加成功！");
        }else {
            result.setFlag(false);
            result.setMessage("添加失败！");
        }
        return result;
    }




}
