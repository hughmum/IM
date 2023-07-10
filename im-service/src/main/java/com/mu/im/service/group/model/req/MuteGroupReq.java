package com.mu.im.service.group.model.req;

import com.mu.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Mr.yuan
 * Date: 2023-07-05 15:35
 * version: 1.0
 */
@Data
public class MuteGroupReq extends RequestBase {

    @NotBlank(message = "groupId不能为空")
    private String groupId;

    @NotNull(message = "mute不能为空")
    private Integer mute;

}
