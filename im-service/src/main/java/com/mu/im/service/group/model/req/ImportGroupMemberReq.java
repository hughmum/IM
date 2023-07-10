package com.mu.im.service.group.model.req;

import com.mu.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Mr.yuan
 * Date: 2023-07-05 10:47
 * version: 1.0
 */
@Data
public class ImportGroupMemberReq extends RequestBase {

    @NotBlank(message = "群id不能为空")
    private String groupId;

    private List<GroupMemberDto> members;

}
