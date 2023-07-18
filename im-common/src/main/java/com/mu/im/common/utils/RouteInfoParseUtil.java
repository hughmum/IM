package com.mu.im.common.utils;

import com.mu.im.common.BaseErrorCode;
import com.mu.im.common.exception.ApplicationException;
import com.mu.im.common.route.RouteInfo;


/**
 * @author Mr.yuan
 * Date: 2023-07-18 15:11
 * version: 1.0
 */
public class RouteInfoParseUtil {

    public static RouteInfo parse(String info){
        try {
            String[] serverInfo = info.split(":");
            RouteInfo routeInfo =  new RouteInfo(serverInfo[0], Integer.parseInt(serverInfo[1])) ;
            return routeInfo ;
        }catch (Exception e){
            throw new ApplicationException(BaseErrorCode.PARAMETER_ERROR) ;
        }
    }
}
