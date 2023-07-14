package com.mu.im.tcp.publish;

import com.alibaba.fastjson.JSONObject;
import com.mu.im.tcp.utils.MqFactory;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Mr.yuan
 * Date: 2023-07-13 17:23
 * version: 1.0
 */
@Slf4j
public class MqMessageProducer {

    public static void sendMessage(Object message) {
        Channel channel = null;
        String channelName = "";
        try {
            channel = MqFactory.getChannel(channelName);
            channel.basicPublish(channelName, "",
                    null, JSONObject.toJSONString(message).getBytes());
        } catch (Exception e) {
            log.error("发送消息出现异常: {}", e.getMessage());
        }
    }
}
