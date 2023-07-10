package com.mu.im.service.group.service;

import com.mu.im.common.ResponseVO;
import com.mu.im.service.group.dao.ImGroupEntity;
import com.mu.im.service.group.model.req.*;

/**
 * @author Mr.yuan
 * Date: 2023-07-05 9:58
 * version: 1.0
 */
public interface ImGroupService {

    public ResponseVO importGroup(ImportGroupReq req);

    public ResponseVO<ImGroupEntity> getGroup(String groupId, Integer appId);

    public ResponseVO createGroup(CreateGroupReq req);

    public ResponseVO addGroupMember(String groupId, Integer appId, GroupMemberDto dto);

    public ResponseVO getGroup(GetGroupReq req);

    public ResponseVO updateBaseGroupInfo(UpdateGroupReq req);

    public ResponseVO getJoinedGroup(GetJoinedGroupReq req);

    public ResponseVO destroyGroup(DestroyGroupReq req);

    public ResponseVO transferGroup(TransferGroupReq req);

    public ResponseVO muteGroup(MuteGroupReq req);

}
