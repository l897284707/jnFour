package com.qfedu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * 公众号：Java架构栈
 * @Author: 卓不凡
 */
@SpringBootTest
public class Demo {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void demo01(){
        //redistemplate操作数据类型时候需要先获取对应数据操作类XxxOperation
        //ValueOperations 针对string
        redisTemplate.opsForValue().set("class","jn2201");


    }
  @Test
    public void demo02(){
        //redistemplate操作数据类型时候需要先获取对应数据操作类XxxOperation
        //ValueOperations 针对string
      String aClass = (String) redisTemplate.opsForValue().get("class");
      System.out.println(aClass);
  }
  @Test
    public void demo03() {
      Boolean flag = redisTemplate.opsForValue().setIfAbsent("username", "xiaoming", 5 * 60,
              TimeUnit.SECONDS);
      System.out.println("flag = " + flag);
      String username = (String) redisTemplate.opsForValue().get("username");
      System.out.println("username = " + username);
  }

  @Test
    public void demo04() {
      stringRedisTemplate.opsForValue().set("age","18");
    }
    @Test
    public void demo05(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","dg");
        map.put("address","济南");
        redisTemplate.opsForHash().putAll("person",map);
        Map person = redisTemplate.opsForHash().entries("person");
        System.out.println(person);
    }
    @Test
    public void demo06() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        redisTemplate.opsForList().rightPushAll("strings",list);
        List string = redisTemplate.opsForList().range("string", 0, -1);
        string.stream().forEach(o-> System.out.println(o));
    }
    @Test
    public void demo07() {
        Set<String> myset = new HashSet<>();
        myset.add("java");
        myset.add("php");
        myset.add("c++");
//        redisTemplate.opsForSet().add("myset","aa","bb","cc");
        Set myset1 = redisTemplate.opsForSet().members("myset");
        System.out.println(myset1);
    }
    @Test
    public void demo08() {

        redisTemplate.opsForZSet().add("tuhaobang","liubei",100);
        redisTemplate.opsForZSet().add("tuhaobang","caocao",80);

        Set tuhaobang = redisTemplate.opsForZSet().range("tuhaobang", 0, -1);
        System.out.println(tuhaobang);
//       redisTemplate.opsForZSet().r

    }
}
