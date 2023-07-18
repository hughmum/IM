package com.mu.im.service.user.model.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Mr.yuan
 * Date: 2023-07-18 11:30
 * version: 1.0
 */
@Data
public class LoginReq {

    @NotNull(message = "用户id不能位空")
    private String userId;

    @NotNull(message = "appId不能为空")
    private Integer appId;

    private Integer clientType;

}
