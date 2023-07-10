package com.mu.im.service.group.model.resp;

import com.mu.im.service.group.dao.ImGroupEntity;
import lombok.Data;

import java.util.List;

/**
 * @author Mr.yuan
 * Date: 2023-07-05 15:02
 * version: 1.0
 */
@Data
public class GetJoinedGroupResp {

    private Integer totalCount;

    private List<ImGroupEntity> groupList;

}
