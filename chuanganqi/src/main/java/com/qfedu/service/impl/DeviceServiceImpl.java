package com.qfedu.service.impl;

import com.qfedu.mapper.DeviceMapper;
import com.qfedu.model.Device;
import com.qfedu.model.Message;
import com.qfedu.page.PageResult;
import com.qfedu.page.QueryPageBean;
import com.qfedu.service.DeviceService;
import com.qfedu.vo.DeviceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 19:26
 */

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {

        PageResult pageResult = new PageResult();
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        long count = deviceMapper.count();
        pageResult.setTotal(count);
        List<DeviceVo> page = deviceMapper.findPage((currentPage - 1) * pageSize, pageSize);
        pageResult.setRows(page);
        return pageResult;
    }

    @Override
    public Device findById(int id) {
        return deviceMapper.findById(id);
    }

    @Override
    public int eidtDevice(Device device) {
        device.setUpdatetime(new Date());
        return deviceMapper.editDevice(device);

    }
}
