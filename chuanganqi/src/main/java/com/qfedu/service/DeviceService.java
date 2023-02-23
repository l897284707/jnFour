package com.qfedu.service;

import com.qfedu.model.Device;
import com.qfedu.page.PageResult;
import com.qfedu.page.QueryPageBean;
import com.qfedu.vo.DeviceVo;

import java.util.List;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 19:26
 */
public interface DeviceService {
    PageResult findPage(QueryPageBean queryPageBean);
    Device findById(int id);

    int eidtDevice(Device device);
}
