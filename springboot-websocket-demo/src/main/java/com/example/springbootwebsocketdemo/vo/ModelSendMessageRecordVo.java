package com.example.springbootwebsocketdemo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description 消息发送记录表列表Vo
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
public class ModelSendMessageRecordVo {

    /**
    * 模型消息发送记录表 ID
    */
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
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

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
    @ApiModelProperty(value = "重发成功标识 0-重发失败或未重发 1-重发成功")
    private Integer retrySuccessFlag;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "消息内容")
    private ModelMessageContentRecordVo modelMessageContentRecordVo;
}