package com.qfedu.controller;

import com.qfedu.mapper.DeviceMapper;
import com.qfedu.mapper.MessageMapper;
import com.qfedu.model.Device;
import com.qfedu.page.PageResult;
import com.qfedu.page.QueryPageBean;
import com.qfedu.page.Result;
import com.qfedu.service.DeviceService;
import com.qfedu.service.MessageService;
import com.qfedu.vo.DeviceVo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 21:34
 */
@RestController
@CrossOrigin
@RequestMapping("device")
public class DeviceController {
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
        PageResult page = deviceService.findPage(queryPageBean);
        return page;
    }

    @PostMapping("addDevice")
    public Result addDevice(@RequestBody Device device){
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

    @GetMapping("findById")
    public Result findById( int id){
        Device byId = deviceService.findById(id);
        //查询成功
        if (ObjectUtils.notEqual(byId, null)) {
            return Result.successResult("查询成功",byId);
        } else {
            return Result.failResult("查询失败");
        }
    }
    @GetMapping("findAll")
    public List<Device> findAll(){
        List<Device> all = deviceMapper.selectList(null);
        return all;
    }

    @PostMapping("editDevice")
    public Result editDevice(@RequestBody DeviceVo device){
        Result result = new Result();

        int i = deviceService.eidtDevice(device);
        if (i>0){
            result.setFlag(true);
            result.setMessage("更新成功！");
        }else {
            result.setFlag(false);
            result.setMessage("更新失败！");
        }
        return result;
    }

    @GetMapping("deleteById")
    public Result deleteById(int id ){
        int i = deviceMapper.deleteById(id);
        Result result = new Result();
        if (i>0){
            result.setFlag(true);
            result.setMessage("删除成功！");
        }else {
            result.setFlag(false);
            result.setMessage("删除失败！");
        }
        return result;
    }
}
