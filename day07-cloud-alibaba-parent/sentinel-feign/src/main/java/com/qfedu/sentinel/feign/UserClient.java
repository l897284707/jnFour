package com.qfedu.sentinel.feign;

import com.qfedu.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 1.0
 * 公众号：Java架构栈
 * @Author: 卓不凡
 */
@FeignClient(value = "sentinel-provider")
public interface UserClient {
    @GetMapping("/provider/getUserById")
    public User getUserById(@RequestParam("id") int id);
}
