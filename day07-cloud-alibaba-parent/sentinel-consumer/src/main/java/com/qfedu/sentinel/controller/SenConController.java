package com.qfedu.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qfedu.model.User;
import com.qfedu.sentinel.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *
 */
@RestController
@RequestMapping("consumer")
public class SenConController {

    @Autowired
    private UserClient userClient;

    @GetMapping("getUserById")

    public User getUserById(@RequestParam("id") int id , String name){

        User user = userClient.getUserById(id);
        return user ;
    }
    public User blockHandlerMethod(Integer id, String nam, BlockException e){
        return new User(id,"this is blockHandlerMethod of " + nam ,0);
    }

    @GetMapping("getUser")
    public User getUser(@RequestParam("id") int id){
        User user = userClient.getUserById(id);
        return user;
    }
    @RequestMapping(value="/test")
    public String test(){
        return "test";
    }
}
