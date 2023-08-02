package com.example.springbootwebsocketdemo.query;

import com.example.springbootwebsocketdemo.common.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 BaseQuery * @Description 消息发送记录表查询条件
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
@ApiModel(value="消息发送记录表查询条件",description="消息发送记录表查询对象！")
public class ModelSendMessageRecordQuery extends BaseQuery {

    /**
     * 是否删除 0-删除 1-使用
     */
    @ApiModelProperty(value="是否删除 0-删除 1-使用",name="status",required=false)
    private Integer status;

}
