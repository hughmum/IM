package com.mu.im.service.group.model.req;

import com.mu.im.common.model.RequestBase;
import lombok.Data;

/**
 * @author Mr.yuan
 * Date: 2023-07-05 10:49
 * version: 1.0
 */
@Data
public class GetGroupReq extends RequestBase {

    private String groupId;

}
