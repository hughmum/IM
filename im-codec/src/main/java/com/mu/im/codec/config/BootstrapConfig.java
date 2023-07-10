package com.mu.im.codec.config;

import lombok.Data;

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
    }
}
