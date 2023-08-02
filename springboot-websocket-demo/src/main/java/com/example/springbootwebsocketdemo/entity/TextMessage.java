package com.example.springbootwebsocketdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 文本消息实体类
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
public class TextMessage implements Serializable {

    private static final long serialVersionUID = 5442496859046273704L;

    /**
     * 发送消息的用户Id
     */
    private String userId;

    /**
     * 消息的接收者
     */
    private String receiver;

    /**
     * 用户发送的消息
     */
    private String msg;

}
