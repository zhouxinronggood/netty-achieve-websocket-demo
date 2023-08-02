package com.example.springbootwebsocketdemo.mapper;

import com.example.springbootwebsocketdemo.entity.ModelSendMessageRecord;
import com.example.springbootwebsocketdemo.vo.ModelSendMessageRecordVo;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 模型消息发送记录表 Mapper 接口
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Component
public interface ModelSendMessageRecordMapper extends MppBaseMapper<ModelSendMessageRecord> {
}
