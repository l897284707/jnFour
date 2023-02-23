package com.qfedu.vo;

import com.qfedu.model.Device;
import com.qfedu.model.DeviceType;
import lombok.Data;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 23:03
 */
@Data
public class DeviceVo extends Device {

    private String tname;
    private DeviceType deviceType;
}
