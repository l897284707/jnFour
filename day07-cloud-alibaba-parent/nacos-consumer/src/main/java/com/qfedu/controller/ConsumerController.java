package com.qfedu.controller;

import com.qfedu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO 类描述
 *
 * @author LiJH.
 * @date 2023/3/2 10:18
 */
@RestController
@RequestMapping
public class ConsumerController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("consumer/getUserById")
    public User getUserById(@RequestParam("id") int id){
        ServiceInstance choose = loadBalancerClient.choose("service-provider");
        String url = "http://"+choose.getHost()+":"+choose.getPort()+"/provider/getUserById/"+id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
