package com.mu.im.tcp.reciver;

import com.mu.im.common.constants.Constants;
import com.mu.im.tcp.utils.MqFactory;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;

import java.io.IOException;

/**
 * @author Mr.yuan
 * Date: 2023-07-13 17:29
 * version: 1.0
 */
@Slf4j
public class MessageReciver {

    private static void startReciverMessage() {
        try {
            Channel channel = MqFactory
                    .getChannel(Constants.RabbitConstants.MessageService2Im);
            channel.queueDeclare(Constants.RabbitConstants.MessageService2Im,
                    true, false, false, null);
            channel.queueBind(Constants.RabbitConstants.MessageService2Im,
                    Constants.RabbitConstants.MessageService2Im, null);
            channel.basicConsume(Constants.RabbitConstants.MessageService2Im, false,
                    new DefaultConsumer(channel) {
                        @Override
                        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                            //这里处理我们的业务逻辑 TODO 处理消息服务发来的消息
                            String msgStr = new String(body);
                            log.info(msgStr);
                        }
                    });
        } catch (Exception e) {

        }
    }

    public static void init() {
        startReciverMessage();
    }
}
