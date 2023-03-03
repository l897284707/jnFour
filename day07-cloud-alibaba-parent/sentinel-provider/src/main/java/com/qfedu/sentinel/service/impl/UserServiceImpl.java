package com.qfedu.sentinel.service.impl;

import com.qfedu.model.User;
import com.qfedu.sentinel.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * 公众号：Java架构栈
 * @Author: 卓不凡
 */
@Service
public class UserServiceImpl implements UserService {
/*    @Override
    public User getUserById(int id) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User(id,"steel",18);
    }*/
    @Override
    public User getUserById(int id, String name) {
    if(id == 4){
        int a = 6/0;
    }
    return new User(id,name,18);
}
}
