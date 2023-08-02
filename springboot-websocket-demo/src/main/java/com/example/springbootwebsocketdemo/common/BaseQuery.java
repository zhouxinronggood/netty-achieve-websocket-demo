package com.example.springbootwebsocketdemo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
@ApiModel(value="基础接口查询实体",description="对象带有page，size，2个参数，主要用于查询。")
public class BaseQuery {
    /**
     * 页码(默认1)
     */
    @ApiModelProperty(value="分页page",name="page",required=false)
    private Integer page = 1;

    /**
     * 每页数(默认：20)
     */
    @ApiModelProperty(value="按每页多少分页",name="size",required=false)
    private Integer size = 20;
}
