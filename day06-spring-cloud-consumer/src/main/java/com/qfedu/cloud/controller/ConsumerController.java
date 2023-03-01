package com.qfedu.cloud.controller;


import com.qfedu.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-28 09:47
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    //服务客户端
    @Autowired
    private DiscoveryClient discoveryClientl;
    @GetMapping
    public User getUser(@RequestParam("id") Integer id){
        //根据注册的实例名称来获取实例
        List<ServiceInstance> instances = discoveryClientl.getInstances("service-provider");
        ServiceInstance serviceInstance = instances.get(2);
        String baseUrl = "http://" + serviceInstance.getHost() + ":"+serviceInstance.getPort()+"/user/"+id;


        //远程调用接口服务
        User forObject = restTemplate.getForObject(baseUrl, User.class);
        return forObject;
    }
}
