package com.mu.im.tcp.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mu.im.codec.pack.LoginPack;
import com.mu.im.codec.proto.Message;
import com.mu.im.common.constants.Constants;
import com.mu.im.common.enums.ImConnectStatusEnum;
import com.mu.im.common.enums.command.SystemCommand;
import com.mu.im.common.model.UserSession;
import com.mu.im.tcp.redis.RedisManager;
import com.mu.im.tcp.server.ImServer;
import com.mu.im.tcp.utils.SessionSocketHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import com.alibaba.fastjson.TypeReference;
import io.netty.util.AttributeKey;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
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
            ctx.channel().attr(AttributeKey.valueOf(Constants.AppId)).set(msg.getMessageHeader().getAppId());
            ctx.channel().attr(AttributeKey.valueOf(Constants.ClientType))
                    .set(msg.getMessageHeader().getClientType());
            //将channel存起来
            //Redis map
            UserSession userSession = new UserSession();
            userSession.setAppId(msg.getMessageHeader().getAppId());
            userSession.setClientType(msg.getMessageHeader().getClientType());
            userSession.setUserId(loginPack.getUserId());
            userSession.setConnectState(ImConnectStatusEnum.ONLINE_STATUS.getCode());

            //存储到redis
            RedissonClient redissonClient = RedisManager.getRedissonClient();
            RMap<Object, Object> map = redissonClient.getMap(msg.getMessageHeader().getAppId() + Constants.RedisConstants.UserSessionConstants + loginPack.getUserId());
            map.put(msg.getMessageHeader().getClientType() + ":" + msg.getMessageHeader().getImei(),
                    JSON.toJSONString(userSession));


            SessionSocketHolder
                    .put(msg.getMessageHeader().getAppId()
                            ,loginPack.getUserId(),
                            msg.getMessageHeader().getClientType(),
                            msg.getMessageHeader().getImei(),
                            (NioSocketChannel) ctx.channel());
        } else if (command == SystemCommand.LOGIN.getCommand()) {
            // 删除session
            // redis删除
            String userId = (String) ctx.channel().attr(AttributeKey.valueOf("userId")).get();
            Integer appId = (Integer) ctx.channel().attr(AttributeKey.valueOf(Constants.AppId)).get();
            Integer clientType = (Integer) ctx.channel().attr(AttributeKey.valueOf(Constants.ClientType)).get();

            //删除session
            SessionSocketHolder.remove(appId, userId, clientType);
            RedissonClient redissonClient = RedisManager.getRedissonClient();
            RMap<Object, Object> map = redissonClient.getMap(appId +
                    Constants.RedisConstants.UserSessionConstants + userId);
            map.remove(clientType);
            ctx.channel().close();
        }
    }
}
