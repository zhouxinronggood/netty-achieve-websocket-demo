package com.example.springbootwebsocketdemo.constant;

/**
 * @Description 消息类型枚举
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
public enum MessageTypeEnum {

    TEXT("文本消息","text","普通文本消息"),
    HEARTBEAT("心跳消息","heartbeat","心跳检查消息"),
    REGISTER("连接消息","register","建立连接消息");

    MessageTypeEnum(String name, String code, String desc) {
        this.name = name;
        this.code = code;
        this.desc = desc;
    }

    /**
     * 名称
     */
    private String name;

    /**
     * code
     */
    private String code;

    /**
     * 描述
     */
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
