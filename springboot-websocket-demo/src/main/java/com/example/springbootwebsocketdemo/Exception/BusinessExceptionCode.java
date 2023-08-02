package com.example.springbootwebsocketdemo.Exception;

public enum BusinessExceptionCode {

    // 登录校验类
    USER_LOGIN_NAME_EXIST("登录名已存在"),
    LOGIN_USER_ERROR("用户名不存在或密码错误"),

    // 参数异常类
    PARAM_ERROR("参数异常"),
    PARAM_NULL("参数为空"),
    PARAM_FORMAT_ERROR("参数格式不正确"),
    PARAM_VALUE_ERROR("参数值不正确"),

    // 系统异常
    SYSTEM_ERROR("服务异常"),
    UNKNOWN_ERROR("未知异常"),

    // 业务异常
    BUSINESS_FAILURE("业务异常"),
    INSERT_FAILURE("新增失败"),
    UPDATE_FAILURE("更新失败"),
    DELETE_FAILURE("删除失败"),
    RATE_LIMIT_ERROR("限流异常"),
    FILE_UPLOAD_FAILURE("文件上传失败")
    ;

    private String desc;

    BusinessExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
