package com.qfedu.service.impl;

import com.qfedu.model.User;
import com.qfedu.service.UserService;
import org.springframework.stereotype.Service;

/**
 * TODO 类描述
 *
 * @author LiJH.
 * @date 2023/3/2 10:11
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(Integer id) {
        return new User(id,"光泉sb",18);
    }
}
