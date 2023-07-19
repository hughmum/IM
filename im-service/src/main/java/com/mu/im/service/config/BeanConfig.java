package com.mu.im.service.config;

import com.mu.im.common.config.AppConfig;
import com.mu.im.common.enums.ImUrlRouteWayEnum;
import com.mu.im.common.enums.RouteHashMethodEnum;
import com.mu.im.common.route.RouteHandle;
import com.mu.im.common.route.algorithm.consistenthash.AbstractConsistentHash;
import com.mu.im.common.route.algorithm.consistenthash.ConsistentHashHandle;
import com.mu.im.common.route.algorithm.consistenthash.TreeMapConsistentHash;
import com.mu.im.common.route.algorithm.loop.LoopHandle;
import com.mu.im.common.route.algorithm.random.RandomHandle;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    public RouteHandle routeHandle() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Integer imRouteWay = appConfig.getImRouteWay();
        String routWay = "";
        ImUrlRouteWayEnum handler = ImUrlRouteWayEnum.getHandler(imRouteWay);
        routWay = handler.getClazz();

        RouteHandle routeHandle = (RouteHandle) Class.forName(routWay).newInstance();
        if (handler == ImUrlRouteWayEnum.HASH) {
            Method setHash = Class.forName(routWay).getMethod("setHash", AbstractConsistentHash.class);
            Integer consistentHashWay = appConfig.getConsistentHashWay();
            String hashWay = "";

            RouteHashMethodEnum hashHandler = RouteHashMethodEnum.getHandler(consistentHashWay);
            hashWay = hashHandler.getClazz();
            AbstractConsistentHash consistentHash
                    = (AbstractConsistentHash) Class.forName(hashWay).newInstance();
            setHash.invoke(routeHandle, consistentHash);
        }
        return routeHandle;
    }

}
