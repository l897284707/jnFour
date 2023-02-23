package com.qfedu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 11:07
 */
@Configuration
public class RedisConfig {
  @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
      RedisTemplate redisTemplate = new RedisTemplate();
      redisTemplate.setConnectionFactory(redisConnectionFactory);
      redisTemplate.setKeySerializer(RedisSerializer.string());
      redisTemplate.setValueSerializer(new StringRedisSerializer());
      return redisTemplate;
  }
}
