package com.mu.im.service.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mu.im.common.ResponseVO;
import com.mu.im.common.enums.DelFlagEnum;
import com.mu.im.common.enums.UserErrorCode;
import com.mu.im.service.user.dao.ImUserDataEntity;
import com.mu.im.service.user.dao.mapper.ImUserDataMapper;
import com.mu.im.service.user.model.req.DeleteUserReq;
import com.mu.im.service.user.model.req.GetUserInfoReq;
import com.mu.im.service.user.model.req.ImportUserReq;
import com.mu.im.service.user.model.req.ModifyUserInfoReq;
import com.mu.im.service.user.model.resp.GetUserInfoResp;
import com.mu.im.service.user.model.resp.ImportUserResp;
import com.mu.im.service.user.service.ImUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Mr.yuan
 * Date: 2023-07-03 9:55
 * version: 1.0
 */
@Service
public class ImUserServiceImpl implements ImUserService {

    @Autowired
    ImUserDataMapper imUserDataMapper;


    @Override
    public ResponseVO importUser(ImportUserReq req) {

        //校验
        if (req.getUserData().size() > 100) {
            //TODO 返回数量过多
        }

        List<String> successId = new ArrayList<>();
        List<String> errorId = new ArrayList<>();
        // TODO 优化为多线程批量插入
        req.getUserData().forEach(e -> {
            try {
                e.setAppId(req.getAppId());
                int insert = imUserDataMapper.insert(e);
                if (insert == 1) {
                    successId.add(e.getUserId());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                errorId.add(e.getUserId());
            }
        });

        ImportUserResp resp = new ImportUserResp();
        resp.setErrorId(errorId);
        resp.setSuccessId(successId);
        return ResponseVO.successResponse(resp);
    }

    @Override
    public ResponseVO<GetUserInfoResp> getUserInfo(GetUserInfoReq req) {
        QueryWrapper<ImUserDataEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("app_id",req.getAppId());
        queryWrapper.in("user_id",req.getUserIds());
        queryWrapper.eq("del_flag", DelFlagEnum.NORMAL.getCode());

        List<ImUserDataEntity> userDataEntities = imUserDataMapper.selectList(queryWrapper);
        HashMap<String, ImUserDataEntity> map = new HashMap<>();

        for (ImUserDataEntity data:
                userDataEntities) {
            map.put(data.getUserId(),data);
        }

        List<String> failUser = new ArrayList<>();
        for (String uid:
                req.getUserIds()) {
            if(!map.containsKey(uid)){
                failUser.add(uid);
            }
        }

        GetUserInfoResp resp = new GetUserInfoResp();
        resp.setUserDataItem(userDataEntities);
        resp.setFailUser(failUser);
        return ResponseVO.successResponse(resp);
    }

    @Override
    public ResponseVO<ImUserDataEntity> getSingleUserInfo(String userId, Integer appId) {
        QueryWrapper objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("app_id",appId);
        objectQueryWrapper.eq("user_id",userId);
        objectQueryWrapper.eq("del_flag", DelFlagEnum.NORMAL.getCode());

        ImUserDataEntity ImUserDataEntity = imUserDataMapper.selectOne(objectQueryWrapper);
        if(ImUserDataEntity == null){
            return ResponseVO.errorResponse(UserErrorCode.USER_IS_NOT_EXIST);
        }

        return ResponseVO.successResponse(ImUserDataEntity);
    }


    @Override
    public ResponseVO deleteUser(DeleteUserReq req) {
        ImUserDataEntity entity = new ImUserDataEntity();
        entity.setDelFlag(DelFlagEnum.DELETE.getCode());

        List<String> errorId = new ArrayList();
        List<String> successId = new ArrayList();

        for (String userId:
                req.getUserId()) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("app_id",req.getAppId());
            wrapper.eq("user_id",userId);
            wrapper.eq("del_flag",DelFlagEnum.NORMAL.getCode());
            int update = 0;

            try {
                update =  imUserDataMapper.update(entity, wrapper);
                if(update > 0){
                    successId.add(userId);
                }else{
                    errorId.add(userId);
                }
            }catch (Exception e){
                errorId.add(userId);
            }
        }

        ImportUserResp resp = new ImportUserResp();
        resp.setSuccessId(successId);
        resp.setErrorId(errorId);
        return ResponseVO.successResponse(resp);
    }


    @Override
    public ResponseVO modifyUserInfo(ModifyUserInfoReq req) {
        return null;
    }
}
