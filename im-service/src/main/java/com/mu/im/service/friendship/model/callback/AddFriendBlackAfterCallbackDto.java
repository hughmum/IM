package com.mu.im.service.friendship.model.callback;

import lombok.Data;

/**
 * @author Mr.yuan
 * Date: 2023-07-20 11:22
 * version: 1.0
 */
@Data
public class AddFriendBlackAfterCallbackDto {

    private String fromId;

    private String toId;
}
