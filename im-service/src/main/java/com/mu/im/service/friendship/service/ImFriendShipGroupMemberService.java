package com.mu.im.service.friendship.service;

import com.mu.im.common.ResponseVO;
import com.mu.im.service.friendship.model.req.AddFriendShipGroupMemberReq;
import com.mu.im.service.friendship.model.req.DeleteFriendShipGroupMemberReq;

/**
 * @author Mr.yuan
 * Date: 2023-07-04 17:19
 * version: 1.0
 */
public interface ImFriendShipGroupMemberService {

    public ResponseVO addGroupMember(AddFriendShipGroupMemberReq req);

    public ResponseVO delGroupMember(DeleteFriendShipGroupMemberReq req);

    public int doAddGroupMember(Long groupId, String toId);

    public int clearGroupMember(Long groupId);
}
