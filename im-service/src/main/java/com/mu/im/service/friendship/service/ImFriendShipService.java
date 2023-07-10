package com.mu.im.service.friendship.service;

import com.mu.im.common.ResponseVO;
import com.mu.im.common.model.RequestBase;
import com.mu.im.service.friendship.model.req.*;

/**
 * @author Mr.yuan
 * Date: 2023-07-03 11:15
 * version: 1.0
 */
public interface ImFriendShipService {

    public ResponseVO importFriendShip(ImporFriendShipReq req);

    public ResponseVO addFriend(AddFriendReq req);

    public ResponseVO updateFriend(UpdateFriendReq req);

    public ResponseVO deleteFriend(DeleteFriendReq req);

    public ResponseVO deleteAllFriend(DeleteFriendReq req);

    public ResponseVO getAllFriendShip(GetAllFriendShipReq req);

    public ResponseVO getRelation(GetRelationReq req);

    public ResponseVO checkFriendship(CheckFriendShipReq req);

    public ResponseVO addBlack(AddFriendShipBlackReq req);

    public ResponseVO deleteBlack(DeleteBlackReq req);

    public ResponseVO checkBlck(CheckFriendShipReq req);

    public ResponseVO doAddFriend(String fromId, FriendDto dto, Integer appId);

}
