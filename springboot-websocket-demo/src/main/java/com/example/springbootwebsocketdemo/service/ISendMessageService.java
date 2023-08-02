package com.example.springbootwebsocketdemo.service;

/**
 * @Description 实现了对某个用户推送消息以及群发消息的功能
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
public interface ISendMessageService {

    /**
     * 根据 UserId 将信息发送给指定的用户
     *
     * @param userId   发送消息的用户Id
     * @param receiver 接收消息的用户Id
     * @param msg      要发送的消息
     */
    void sendMsgToUserByUserId(String userId, String receiver, String msg);

    /**
     * 给所有的在线用户发送消息
     *
     * @param msg 要发送的消息
     */
    void sendMsgToGroup(String msg);
}
