package com.mu.im.tcp.redis;

import com.mu.im.codec.config.BootstrapConfig;
import com.mu.im.tcp.reciver.UserLoginMessageListener;
import org.redisson.api.RedissonClient;

/**
 * @author Mr.yuan
 * Date: 2023-07-10 13:42
 * version: 1.0
 */
public class RedisManager {

    private static RedissonClient redissonClient;

    private static Integer loginModel;

    public static void init(BootstrapConfig config){
        loginModel = config.getIm().getLoginModel();
        SingleClientStrategy singleClientStrategy = new SingleClientStrategy();
        redissonClient = singleClientStrategy.getRedissonClient(config.getIm().getRedis());
        UserLoginMessageListener userLoginMessageListener = new UserLoginMessageListener(loginModel);
        userLoginMessageListener.listenerUserLogin();
    }

    public static RedissonClient getRedissonClient(){
        return redissonClient;
    }
}
