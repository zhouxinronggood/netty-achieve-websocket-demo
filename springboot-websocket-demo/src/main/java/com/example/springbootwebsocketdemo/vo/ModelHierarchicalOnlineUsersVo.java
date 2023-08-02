package com.example.springbootwebsocketdemo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description 在线用户信息表列表Vo
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
public class ModelHierarchicalOnlineUsersVo {

    /**
    * 在线用户信息表 ID
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
     * 是否在线 0-不在线 1-在线
     */
    @ApiModelProperty(value = "是否在线 0-不在线 1-在线")
    private Integer onlineStatus;

}