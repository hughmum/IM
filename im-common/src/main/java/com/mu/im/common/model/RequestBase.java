package com.mu.im.common.model;

import lombok.Data;

/**
 * @author Mr.yuan
 * Date: 2023-07-03 10:01
 * version: 1.0
 */
@Data
public class RequestBase {
    private Integer appId;

    private String operater; //操作人，是谁在调用这个接口

    private Integer clientType;

    private String imei;
}
