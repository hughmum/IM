package com.mu.im.common.route.algorithm.random;

import com.mu.im.common.enums.UserErrorCode;
import com.mu.im.common.exception.ApplicationException;
import com.mu.im.common.route.RouteHandle;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Mr.yuan
 * Date: 2023-07-18 11:38
 * version: 1.0
 */
public class RandomHandle implements RouteHandle {
    @Override
    public String routeServer(List<String> values, String key) {
        int size = values.size();
        if(size == 0){
            throw new ApplicationException(UserErrorCode.SERVER_NOT_AVAILABLE);
        }
        int i = ThreadLocalRandom.current().nextInt(size);
        return values.get(i);
    }
}
