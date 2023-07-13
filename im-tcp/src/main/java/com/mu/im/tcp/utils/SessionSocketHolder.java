package com.mu.im.tcp.utils;

import com.mu.im.common.model.UserClientDto;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mr.yuan
 * Date: 2023-07-10 9:47
 * version: 1.0
 */
public class SessionSocketHolder {
    private static final Map<UserClientDto, NioSocketChannel> CHANNELS = new ConcurrentHashMap<>();

    public static void put(Integer appId,String userId,Integer clientType,
                           String imei
            ,NioSocketChannel channel){
        UserClientDto dto = new UserClientDto();
        dto.setImei(imei);
        dto.setAppId(appId);
        dto.setClientType(clientType);
        dto.setUserId(userId);
        CHANNELS.put(dto,channel);
    }

    public static NioSocketChannel get(Integer appId,String userId,
                                       Integer clientType){
        UserClientDto dto = new UserClientDto();
        dto.setAppId(appId);
        dto.setClientType(clientType);
        dto.setUserId(userId);
        return CHANNELS.get(dto);
    }

    public static void remove(Integer appId,String userId,Integer clientType){
        UserClientDto dto = new UserClientDto();
        dto.setAppId(appId);
        dto.setClientType(clientType);
        dto.setUserId(userId);
        CHANNELS.remove(dto);
    }

    //根据values删除
    public static void remove(NioSocketChannel channel) {
        CHANNELS.entrySet().stream().filter(entity -> entity.getValue() == channel)
                .forEach(entry -> CHANNELS.remove(entry.getKey()));
    }
}
