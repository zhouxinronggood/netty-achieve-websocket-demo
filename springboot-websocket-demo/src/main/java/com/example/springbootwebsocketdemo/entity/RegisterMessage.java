package com.example.springbootwebsocketdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
public class RegisterMessage implements Serializable {

    private static final long serialVersionUID = 2770942184846218973L;
    /**
     * 注册到服务端的用户Id
     */
    private String userId;
}
