package com.qfedu.cloud.controller;


import com.qfedu.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-28 09:47
 */
@RestController
@RequestMapping("consumer/user")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping
    @ResponseBody
    public User getUser(@RequestParam("id") Integer id){
        //远程调用接口服务
        String url = "http://localhost:8081/user/"+id;
        User forObject = restTemplate.getForObject(url, User.class);
        return forObject;
    }
}
