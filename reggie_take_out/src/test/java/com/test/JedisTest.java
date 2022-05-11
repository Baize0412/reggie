package com.test;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {

    @Test
    public void testRedis() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("name1", "xiaoming");
        jedis.del("name1");

        jedis.hset("myhush", "addr", "bj");

        String hset = jedis.hget("myhush", "addr");


        System.out.println(hset);

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);

        }

        jedis.close();

    }
}
