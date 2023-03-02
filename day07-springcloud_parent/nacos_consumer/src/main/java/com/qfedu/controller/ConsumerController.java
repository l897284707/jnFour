package com.qfedu.controller;

import com.qfedu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-03-02 17:49
 */
@RestController
public class ConsumerController {
    //从Nacos注册中心获取服务端的ip、端口、要调用的服务
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    //访问Rest服务的客户端
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "consumer/user/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer id){
        ServiceInstance si = loadBalancerClient.choose("nacos-peovider");
        String url = "http://"+si.getHost() + ":"+si.getPort() + "/getUserById/"+id;
        return restTemplate.getForObject(url, User.class);
    }
}
