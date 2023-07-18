package com.mu.im.service.config;

import com.mu.im.common.config.AppConfig;
import com.mu.im.common.route.RouteHandle;
import com.mu.im.common.route.algorithm.loop.LoopHandle;
import com.mu.im.common.route.algorithm.random.RandomHandle;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.yuan
 * Date: 2023-07-18 14:35
 * version: 1.0
 */
@Configuration
public class BeanConfig {


    @Autowired
    AppConfig appConfig;

    @Bean
    public ZkClient buildZKClient() {
        return new ZkClient(appConfig.getZkAddr(),
                appConfig.getZkConnectTimeOut());
    }

    @Bean
    public RouteHandle routeHandle() {
        return new LoopHandle();
    }

}
