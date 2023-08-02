package com.example.springbootwebsocketdemo.query;

import com.example.springbootwebsocketdemo.common.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 在线用户信息表查询条件
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
@ApiModel(value="在线用户信息表查询条件",description="在线用户信息表查询对象！")
public class ModelHierarchicalOnlineUsersQuery extends BaseQuery {
    /**
     * id
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
     * 统计类型：1=统计当前版本下的在线用户数、2=统计当前版本的当前层次下的在线用户数、3=统计当前版本的当前层次的当前page页下的在线用户数
     */

    @ApiModelProperty(value = "统计类型 1-版本下 2-层次下 3-page页下")
    private Integer statisticType;
}
