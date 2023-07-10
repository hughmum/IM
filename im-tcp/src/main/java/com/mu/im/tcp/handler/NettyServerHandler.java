package com.mu.im.tcp.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mu.im.codec.pack.LoginPack;
import com.mu.im.codec.proto.Message;
import com.mu.im.common.enums.command.SystemCommand;
import com.mu.im.tcp.server.ImServer;
import com.mu.im.tcp.utils.SessionSocketHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import com.alibaba.fastjson.TypeReference;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mr.yuan
 * Date: 2023-07-07 17:19
 * version: 1.0
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<Message> {


    private final static Logger logger = LoggerFactory.getLogger(ImServer.class);


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        Integer command = msg.getMessageHeader().getCommand();
        //登录command
        if (command == SystemCommand.LOGIN.getCommand()) {
            LoginPack loginPack = JSON.parseObject(JSONObject.toJSONString(msg.getMessagePack()),
                    new TypeReference<LoginPack>() {
                    }.getType());
            ctx.channel().attr(AttributeKey.valueOf("userId")).set(loginPack.getUserId());
            //将channel存起来
            SessionSocketHolder.put(loginPack.getUserId(), (NioSocketChannel) ctx.channel());
        }
    }
}
