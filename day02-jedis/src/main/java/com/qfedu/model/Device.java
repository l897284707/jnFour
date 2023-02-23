package com.qfedu.model;

import lombok.Data;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-21 19:35
 */
@Data
public class Device {
    private Integer id;
    private String deviceName;
    private double price;
    private String company;
    private String type;
}
