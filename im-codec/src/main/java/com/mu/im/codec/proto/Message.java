package com.mu.im.codec.proto;

import lombok.Data;

/**
 * @author Mr.yuan
 * Date: 2023-07-07 17:08
 * version: 1.0
 */
@Data
public class Message {

    private MessageHeader messageHeader;

    private Object messagePack;

    @Override
    public String toString() {
        return "Message{" +
                "messageHeader=" + messageHeader +
                ", messagePack=" + messagePack +
                '}';
    }
}
