package com.mu.im.service.group.service;

import com.mu.im.common.ResponseVO;
import com.mu.im.service.group.model.req.*;
import com.mu.im.service.group.model.resp.GetRoleInGroupResp;

import java.util.Collection;
import java.util.List;

/**
 * @author Mr.yuan
 * Date: 2023-07-05 10:46
 * version: 1.0
 */
public interface ImGroupMemberService {

    public ResponseVO importGroupMember(ImportGroupMemberReq req);

    public ResponseVO addGroupMember(String groupId, Integer appId, GroupMemberDto dto);

    public ResponseVO<GetRoleInGroupResp> getRoleInGroupOne(String groupId, String memberId, Integer appId);

    public ResponseVO<List<GroupMemberDto>> getGroupMember(String groupId, Integer appId);

    public ResponseVO<Collection<String>> getMemberJoinedGroup(GetJoinedGroupReq req);

    public ResponseVO transferGroupMember(String owner, String groupId, Integer appId);

    public ResponseVO addMember(AddGroupMemberReq req);

    public ResponseVO removeMember(RemoveGroupMemberReq req);

    public ResponseVO removeGroupMember(String groupId, Integer appId, String memberId);

    public ResponseVO updateGroupMember(UpdateGroupMemberReq req);

    public ResponseVO speak(SpeaMemberReq req);


}
