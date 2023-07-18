package com.mu.im.service.user.service;

import com.mu.im.common.ResponseVO;
import com.mu.im.service.user.dao.ImUserDataEntity;
import com.mu.im.service.user.model.req.*;
import com.mu.im.service.user.model.resp.GetUserInfoResp;

/**
 * @author Mr.yuan
 * Date: 2023-07-03 9:55
 * version: 1.0
 */
public interface ImUserService {

    /**
     * 用户导入接口
     * @param req
     * @return
     */
    public ResponseVO importUser(ImportUserReq req);

    public ResponseVO<GetUserInfoResp> getUserInfo(GetUserInfoReq req);

    public ResponseVO<ImUserDataEntity> getSingleUserInfo(String userId , Integer appId);

    public ResponseVO deleteUser(DeleteUserReq req);

    public ResponseVO modifyUserInfo(ModifyUserInfoReq req);

    public ResponseVO login(LoginReq req);
}
