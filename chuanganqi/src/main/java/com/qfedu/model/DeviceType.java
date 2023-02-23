package com.qfedu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 18:00
 */
@TableName("device_type")
@Data
public class DeviceType {
    @TableId(type = IdType.AUTO)
    private  int tid;
    private String tname;
    private Date createtime;
}
