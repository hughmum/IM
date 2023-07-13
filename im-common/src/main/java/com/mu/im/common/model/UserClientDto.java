package com.mu.im.common.model;

import lombok.Data;

/**
 * @author Mr.yuan
 * Date: 2023-07-11 19:26
 * version: 1.0
 */
@Data
public class UserClientDto {

    private Integer appId;

    private Integer clientType;

    private String userId;

    private String imei;

}
