package com.mu.im.service.group.model.resp;

import lombok.Data;

/**
 * @author Mr.yuan
 * Date: 2023-07-05 11:47
 * version: 1.0
 */
@Data
public class GetRoleInGroupResp {

    private Long groupMemberId;

    private String memberId;

    private Integer role;

    private Long speakDate;

}
