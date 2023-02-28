package com.qfedu.cloud.service.impl;

import com.qfedu.cloud.mapper.UserMapper;
import com.qfedu.cloud.model.User;
import com.qfedu.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-28 09:39
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }
}
