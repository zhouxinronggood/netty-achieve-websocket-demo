package com.example.springbootwebsocketdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 消息内容实体
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private static final long serialVersionUID = 8039995821419166691L;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 用户名
     */
    private String username;
}
