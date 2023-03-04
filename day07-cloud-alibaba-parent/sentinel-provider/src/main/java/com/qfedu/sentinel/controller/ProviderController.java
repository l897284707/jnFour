package com.qfedu.sentinel.controller;

import com.qfedu.model.User;
import com.qfedu.sentinel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * 公众号：Java架构栈
 * @Author: 卓不凡
 */
@RestController
@RequestMapping("provider")
public class ProviderController {
    @Autowired
    private UserService userService;
    @GetMapping("getUserById")
    public User getUserById(@RequestParam("id") int id){
        User userById = userService.getUserById(id);
        return userById;

    }
}
