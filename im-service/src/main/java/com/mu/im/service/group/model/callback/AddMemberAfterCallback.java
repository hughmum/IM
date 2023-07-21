package com.mu.im.service.group.model.callback;

import com.mu.im.service.group.model.resp.AddMemberResp;
import lombok.Data;

import java.util.List;

/**
 * @author Mr.yuan
 * Date: 2023-07-21 10:29
 * version: 1.0
 */
@Data
public class AddMemberAfterCallback {
    private String groupId;
    private Integer groupType;
    private String operater;
    private List<AddMemberResp> memberId;
}
