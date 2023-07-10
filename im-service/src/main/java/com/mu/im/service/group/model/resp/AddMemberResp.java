package com.mu.im.service.group.model.resp;

import lombok.Data;

/**
 * @author Mr.yuan
 * Date: 2023-07-05 10:48
 * version: 1.0
 */
@Data
public class AddMemberResp {

    private String memberId;

    // 加人结果：0 为成功；1 为失败；2 为已经是群成员
    private Integer result;

    private String resultMessage;
}
