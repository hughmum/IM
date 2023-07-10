package com.mu.im.tcp.utils;

import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mr.yuan
 * Date: 2023-07-10 9:47
 * version: 1.0
 */
public class SessionSocketHolder {
    private static final Map<String, NioSocketChannel> CHANNELS = new ConcurrentHashMap<>();

    public static void put(String userId, NioSocketChannel channel) {
        CHANNELS.put(userId, channel);
    }

    public static NioSocketChannel get(String userId) {
        return CHANNELS.get(userId);
    }
}
