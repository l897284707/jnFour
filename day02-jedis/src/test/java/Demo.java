import com.qfedu.config.JedisPoolUtils;
import com.qfedu.model.Device;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Tuple;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-21 16:13
 */
public class Demo {
    @Test
    public void quickTest() throws Exception {
        // 参数一：redis服务器ip
        // 参数二：redis服务器的端口号
        Jedis jedis = new Jedis("8.130.41.226", 6379);
        //设置密码
        jedis.auth("123");
        String result = jedis.set("name", "xiaoming");
        System.out.println("result = " + result);
        String value = jedis.get("name");
        System.out.println("value = " + value);
    }
    @Test
    public void jedisPoolTest() throws Exception {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        String host = "8.130.41.226";
        int port = 6379;
        int timeout = 3000;
        String password = "123";
        JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout, password);
        Jedis resource = jedisPool.getResource();
        resource.hset("person_1001","id","1001");
        resource.hset("person_1001","name","李四");
        Map<String, String> map = resource.hgetAll("person_1001");
        System.out.println(map);

        resource.close();
    }

    @Test
    public void jedisPoolUtilsTest() throws Exception {
        Jedis jedis = JedisPoolUtils.getResource();
        String name = jedis.get("name");
        System.out.println("name = " + name);
        jedis.close();
    }

    /**
     * string的基本使用
     */
    @Test
    public void stringTest() throws Exception {
        Jedis jedis = JedisPoolUtils.getResource();
        String result1 = jedis.set("gender","1","NX","EX",3);
        System.out.println("reslut1 = " + result1);
        String result2 = jedis.set("gender","1","NX","EX",3);
        System.out.println("reslut2 = " + result2);

        Thread.sleep(3500);
        String result3 = jedis.set("gender","1","NX","EX",3);
        System.out.println("reslut3 = " + result3);
        String gender = jedis.get("gender");
        System.out.println("gender = " + gender);
        jedis.close();

    }
    /**
     * hash的基本使用
     */
    @Test
    public void hashTest() throws Exception {
        Jedis jedis = JedisPoolUtils.getResource();
        HashMap<String,String> map = new HashMap<>();
        map.put("id","1002");
        map.put("name","小明");
        map.put("email","xiaoming@163.com");
        jedis.hmset("person_1002",map);

        Boolean flag = jedis.hexists("person_1002", "name");
        System.out.println("flag = "+flag);

        Set<String> hkeys = jedis.hkeys("person_1002");
        System.out.println("keys = " + hkeys);
        List<String> hvals = jedis.hvals("person_1002");
        System.out.println("vals = "+hvals);
        jedis.close();
    }

    /**
     * list的基本使用
     * @throws Exception
     */
    @Test
    public void listTest() throws Exception {
        Jedis jedis = JedisPoolUtils.getResource();
        jedis.rpush("mylist1", "mark","jack","furank","lucy","tom");
        List<String> list = jedis.lrange("mylist1", 0, -1);
        System.out.println("list = "+list);
        jedis.close();
    }
    /**
     * set的基本使用
     */
    @Test
    public void setTest() throws Exception {
        Jedis jedis = JedisPoolUtils.getResource();
        jedis.sadd("myset1", "mark1", "jack1", "furank1", "lucy1", "tom1");
        jedis.sadd("myset2","mark2","jack1","furank2","lucy2","tom2");
        jedis.sinterstore("myset3","myset1","myset2");
        Set<String> myset3 = jedis.smembers("myset3");
        System.out.println("myset = "+myset3);

        Boolean flag = jedis.sismember("myset3", "jack1");
        System.out.println("flag = "+flag);
        jedis.close();
    }

    /**
     * zset的基本使用
     */
    @Test
    public void zsetTest() throws Exception {
        Jedis jedis = JedisPoolUtils.getResource();
        jedis.zadd("tuhaobang11", 10, "liubei");
        jedis.zadd("tuhaobang11", 20, "zhangfei");
        jedis.zadd("tuhaobang11", 30, "guanyu");
        jedis.zadd("tuhaobang11", 40, "zhaoyun");
        Set<Tuple> tuhaobang = jedis.zrevrangeByScoreWithScores("tuhaobang11", "+inf", "-inf");
        for (Tuple t: tuhaobang) {
            String name = t.getElement();
            Double score = t.getScore();
            System.out.println("["+name + ","+score + "]");
        }
        jedis.close();
    }

    /**
     * 字符串存储对象
     */
    @Test
    public void saveObjectUseJsonTest() throws Exception {

        Device device = new Device();
        device.setId(1111);
        device.setCompany("杭州小层有限公司");
        device.setPrice(30000D);
        device.setDeviceName("层压机");
        device.setType("压力机");

        Jedis jedis = JedisPoolUtils.getResource();
        String set = jedis.set("device" + device.getId(), device.toString());
        System.out.println(set);

    }
    /**
     * 管道
     */
    @Test
    public void  test1()throws Exception {
        Jedis jedis = JedisPoolUtils.getResource();
        Device device = new  Device();
        device.setId(2);
        device.setCompany("杭州小层有限公司");
        device.setPrice(30000D);
        device.setDeviceName("层压机");
        device.setType("压力机");
        Pipeline pileline = jedis.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            pileline.set("device"+i, device.toString());
}
        long end = System.currentTimeMillis();
        System.out.println("----->" +(end-start));
    }

    private void pipelined() {
    }
}
