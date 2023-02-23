package com.qfedu.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.sql.Time;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-21 16:30
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool = null;

    private static final String HOST = "8.130.41.226";
    private static final int PORT = 6379;
    private static final int TIMEOUT = 3000;
    private static final String PASSWORD = "123";

    static {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        jedisPool = new JedisPool(poolConfig, HOST, PORT, TIMEOUT, PASSWORD);
    }
    public static Jedis getResource(){
        return jedisPool.getResource();
    }


}
