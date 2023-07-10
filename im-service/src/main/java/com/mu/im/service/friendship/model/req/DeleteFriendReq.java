package com.mu.im.service.friendship.model.req;

import com.mu.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Mr.yuan
 * Date: 2023-07-04 8:27
 * version: 1.0
 */
@Data
public class DeleteFriendReq extends RequestBase {

    @NotBlank(message = "fromId不能为空")
    private String fromId;

    @NotBlank(message = "toId不能为空")
    private String toId;

}
