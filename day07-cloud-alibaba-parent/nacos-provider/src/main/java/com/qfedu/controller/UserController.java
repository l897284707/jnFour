package com.qfedu.controller;

import com.qfedu.model.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO 类描述
 *
 * @author LiJH.
 * @date 2023/3/2 10:12
 */
@RestController
@RequestMapping("provider")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("getUserById/{id}")
    public User getUserById(@PathVariable("id") int id){
        User userById = userService.getUserById(id);
        return userById;
    }
}
