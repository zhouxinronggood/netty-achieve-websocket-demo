package com.example.springbootwebsocketdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 心跳检查消息实体类
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
public class HeartbeatMessage implements Serializable {

    private static final long serialVersionUID = -8386806692339090019L;

    /**
     * 发送心跳消息的用户Id
     */
    private String userId;

}
