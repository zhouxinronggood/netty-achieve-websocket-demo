package com.example.springbootwebsocketdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.springbootwebsocketdemo.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 消息内容记录表
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("dds_model_message_content_record")
public class ModelMessageContentRecord extends BaseEntity {

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
     * 发送消息内容
     */
    @ApiModelProperty(value = "发送消息内容")
    private String messageContent;

    
    /**
     * 发送的消息类型，如文本-text、图片-image、语音-voice、视频-video、文件-file等
     */
    @ApiModelProperty(value = "发送的消息类型，如文本-text、图片-image、语音-voice、视频-video、文件-file等")
    private String messageType;

    
    /**
     * 消息次序
     */
    @ApiModelProperty(value = "消息次序")
    private String messageOrder;

    /**
     * 发送消息类型: 发送消息类型: 0-不给所有人发、1-给所有人发【默认为1】、2-发送ping消息、3-给所有人发ping消息、4-只发给除自己之外的所有人、5-发送关闭无效ws、6-更新在线用户表在线状态
     */

    @ApiModelProperty(value = "发送消息类型")
    private Integer sendMessageType;
}