package com.cebbank.springcloudcard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootTest
class SpringCloudCardApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void jedisTest(){
        Jedis jedis = null;
        try {
            //连接本地redis
            jedis = new Jedis("localhost",6379);
            //密码
            jedis.auth("ccjccj66");
            //字符串操作
            jedis.set("name","caocuijing");
            System.out.println(jedis.get("name"));
            //hash操作
            jedis.hset("testhash","name","caocuijing");
            jedis.hset("testhash","age","18");
            System.out.println("hashtest:"+jedis.hget("testhash","name"));
            System.out.println("hashtest:"+jedis.hget("testhash","age"));
            System.out.println(jedis.hgetAll("testhash"));
            //list操作
            jedis.lpush("testlist","a b c d e f g");
            System.out.println(jedis.lrange("testlist",0,-1));
            System.out.println(jedis.lpop("testlist"));
            //set操作
            jedis.sadd("testset","q e r t y u i o p");
            System.out.println(jedis.scard("testset"));
            System.out.println(jedis.smembers("testset"));
            System.out.println(jedis.sismember("testset","q"));
            System.out.println(jedis.srandmember("testset",1));
            System.out.println(jedis.spop("testset",1));
            System.out.println(jedis.srem("testset","o"));
            //zset操作
            jedis.zadd("testzset",100,"cherryball");
            jedis.zadd("testzset",90,"apple");
            jedis.zadd("testzset",80,"banana");
            System.out.println(jedis.zrange("testzset",0,-1));
            System.out.println(jedis.zscore("testzset","cherryball"));
            System.out.println(jedis.zrangeWithScores("testzset",0,1));
            System.out.println(jedis.zincrby("testzset",10,"banana"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    @Test
    void redisPoolTest(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大允许连接数
        jedisPoolConfig.setMaxTotal(10);
        //最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);
        //初始化连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.auth("ccjccj66");
            jedis.set("hello","jedis");
            System.out.println(jedis.get("hello"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            jedisPool.close();
        }
    }

}
