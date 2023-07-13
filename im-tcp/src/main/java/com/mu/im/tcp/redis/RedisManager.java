package com.mu.im.tcp.redis;

import com.mu.im.codec.config.BootstrapConfig;
import org.redisson.api.RedissonClient;

/**
 * @author Mr.yuan
 * Date: 2023-07-10 13:42
 * version: 1.0
 */
public class RedisManager {

    private static RedissonClient redissonClient;

    public static void init(BootstrapConfig config){
        SingleClientStrategy singleClientStrategy = new SingleClientStrategy();
        redissonClient = singleClientStrategy.getRedissonClient(config.getIm().getRedis());

    }

    public static RedissonClient getRedissonClient(){
        return redissonClient;
    }
}
