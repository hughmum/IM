package com.mu.im.codec.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mr.yuan
 * Date: 2023-07-06 17:56
 * version: 1.0
 */
@Data
public class BootstrapConfig {

    private TcpConfig im;

    @Data
    public static class TcpConfig {
        private Integer tcpPort;// tcp 绑定的端口号

        private Integer webSocketPort; // webSocket 绑定的端口号

        private boolean enableWebSocket; //是否启用webSocket

        private Integer bossThreadSize; // boss线程 默认=1

        private Integer workThreadSize; //work线程

        private Long heartBeatTime; //心跳超时时间 单位毫秒

        /**
         * redis配置
         */
        private RedisConfig redis;
    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RedisConfig {

        /**
         * 单机模式：single 哨兵模式：sentinel 集群模式：cluster
         */
        private String mode;
        /**
         * 数据库
         */
        private Integer database;
        /**
         * 密码
         */
        private String password;
        /**
         * 超时时间
         */
        private Integer timeout;
        /**
         * 最小空闲数
         */
        private Integer poolMinIdle;
        /**
         * 连接超时时间(毫秒)
         */
        private Integer poolConnTimeout;
        /**
         * 连接池大小
         */
        private Integer poolSize;

        /**
         * redis单机配置
         */
        private RedisSingle single;

    }

    /**
     * redis单机配置
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RedisSingle {
        /**
         * 地址
         */
        private String address;
    }

}
