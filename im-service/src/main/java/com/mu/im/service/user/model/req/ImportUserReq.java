package com.mu.im.service.user.model.req;

import com.mu.im.common.model.RequestBase;
import com.mu.im.service.user.dao.ImUserDataEntity;
import lombok.Data;

import java.util.List;

/**
 * @author Mr.yuan
 * Date: 2023-07-03 9:59
 * version: 1.0
 */
@Data
public class ImportUserReq extends RequestBase {

    private List<ImUserDataEntity> userData;

}
