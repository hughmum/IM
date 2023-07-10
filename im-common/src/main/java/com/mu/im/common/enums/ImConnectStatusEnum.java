package com.mu.im.common.enums;

/**
 * @author Mr.yuan
 * Date: 2023-07-10 10:25
 * version: 1.0
 */
public enum ImConnectStatusEnum {

    /**
     * 管道链接状态,1=在线，2=离线。。
     */
    ONLINE_STATUS(1),

    OFFLINE_STATUS(2),
    ;

    private Integer code;

    ImConnectStatusEnum(Integer code){
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }
}
