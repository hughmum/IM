package com.mu.im.service.friendship.service;

import com.mu.im.common.ResponseVO;
import com.mu.im.service.friendship.dao.ImFriendShipGroupEntity;
import com.mu.im.service.friendship.model.req.AddFriendShipGroupReq;
import com.mu.im.service.friendship.model.req.DeleteFriendShipGroupReq;

/**
 * @author Mr.yuan
 * Date: 2023-07-04 17:17
 * version: 1.0
 */
public interface ImFriendShipGroupService {

    public ResponseVO addGroup(AddFriendShipGroupReq req);

    public ResponseVO deleteGroup(DeleteFriendShipGroupReq req);

    public ResponseVO<ImFriendShipGroupEntity> getGroup(String fromId, String groupName, Integer appId);

    public Long updateSeq(String fromId, String groupName, Integer appId);
}
