package com.mu.im.service.friendship.model.callback;

import com.mu.im.service.friendship.model.req.FriendDto;
import lombok.Data;

/**
 * @author Mr.yuan
 * Date: 2023-07-19 17:55
 * version: 1.0
 */
@Data
public class AddFriendAfterCallbackDto {

    private String fromId;

    private FriendDto toItem;
}
