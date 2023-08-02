package com.example.springbootwebsocketdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.springbootwebsocketdemo.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 在线用户信息表
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("dds_model_hierarchical_online_users")
public class ModelHierarchicalOnlineUsers extends BaseEntity {

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
     * 是否在线 0-不在线 1-在线
     */
    
    @ApiModelProperty(value = "是否在线 0-不在线 1-在线")
    private Integer onlineStatus;

}