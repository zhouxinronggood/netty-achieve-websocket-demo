package com.example.springbootwebsocketdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.springbootwebsocketdemo.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 消息发送记录表
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("dds_model_send_message_record")
public class ModelSendMessageRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "id")
    private String id;

    
    /**
     * 层次id
     */
    @ApiModelProperty(value = "层次id")
    private String sysLevelId;

    
    /**
     * 投产日历
     */
    @ApiModelProperty(value = "投产日历")
    private String productionCalendar;

    
    /**
     * 页码表id
     */
    @ApiModelProperty(value = "页码表id")
    private String pageId;

    
    /**
     * 发送消息id
     */
    @ApiModelProperty(value = "发送消息id")
    private String messageId;

    
    /**
     * 是否删除 0-删除 1-使用
     */
    
    @ApiModelProperty(value = "是否删除 0-删除 1-使用")
    private Integer status;

    /**
     * 重试次数
     */
    
    @ApiModelProperty(value = "重试次数")
    private Integer retryCount;

    /**
     * 重发成功标识 0-重发失败或未重发 1-重发成功
     */
    
    @ApiModelProperty(value = "重发成功标识 0-重发失败或未重发 1-不需要重发")
    private Integer retrySuccessFlag;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

}