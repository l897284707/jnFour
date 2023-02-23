package com.qfedu.service.impl;

import com.qfedu.mapper.TypeMapper;
import com.qfedu.model.DeviceType;
import com.qfedu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 22:43
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<DeviceType> findAll() {
        return typeMapper.findAll();

    }
}
