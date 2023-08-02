package com.example.springbootwebsocketdemo.query;

import com.example.springbootwebsocketdemo.common.BaseQuery;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Description 消息内容记录表查询条件
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Data
@ApiModel(value="消息内容记录表查询条件",description="消息内容记录表查询对象！")
public class ModelMessageContentRecordQuery extends BaseQuery {

}
