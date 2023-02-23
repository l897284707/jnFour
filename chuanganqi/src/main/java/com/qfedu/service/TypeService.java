package com.qfedu.service;

import com.qfedu.model.DeviceType;

import java.util.List;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 22:43
 */
public interface TypeService {
    List<DeviceType> findAll();
}
