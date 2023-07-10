package com.mu.im.service.group.model.req;

import com.mu.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author Mr.yuan
 * Date: 2023-07-05 15:20
 * version: 1.0
 */
@Data
public class AddGroupMemberReq extends RequestBase {

    @NotBlank(message = "群id不能为空")
    private String groupId;

    @NotEmpty(message = "群成员不能为空")
    private List<GroupMemberDto> members;

}