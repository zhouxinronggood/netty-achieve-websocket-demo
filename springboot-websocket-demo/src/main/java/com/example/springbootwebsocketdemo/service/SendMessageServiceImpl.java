package com.example.springbootwebsocketdemo.service;

import com.example.springbootwebsocketdemo.config.NettyConfig;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Description TODO
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Slf4j
@Service
public class SendMessageServiceImpl implements ISendMessageService{

    @Override
    public void sendMsgToUserByUserId(String userId, String receiver, String msg) {
        //根据UserId获取对应的Channel
        Channel channel = NettyConfig.getOnlineUserChannelMap().get(receiver);

        if (Objects.isNull(channel)) {
            throw new RuntimeException("UserId：" + receiver + "不存在");
        }
        TextWebSocketFrame textWebSocketFrame = new TextWebSocketFrame(userId + "：" + msg);
        //将消息发送给指定的用户
        channel.writeAndFlush(textWebSocketFrame);
        log.info(textWebSocketFrame.text());
    }

    @Override
    public void sendMsgToGroup(String msg) {
        //给所有在线的用户发送消息
        NettyConfig.getOnlineChannelGroup().writeAndFlush(new TextWebSocketFrame(msg));
    }

}
