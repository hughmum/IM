package com.mu.im.common.route;

import java.util.List;

/**
 * @author Mr.yuan
 * Date: 2023-07-18 11:36
 * version: 1.0
 */
public interface RouteHandle {

    /**
     * 根据key值取出一个个可用的服务器地址来
     * @param values
     * @param key
     * @return
     */
    public String routeServer(List<String> values, String key);

}
