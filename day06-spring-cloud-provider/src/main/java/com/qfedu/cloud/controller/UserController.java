package com.qfedu.cloud.controller;

import com.qfedu.cloud.model.User;
import com.qfedu.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-28 10:09
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{id}")
    public User getUser(@PathVariable("id")Integer id){
        return userService.getUser(id);
    }

}
