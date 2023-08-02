package com.example.springbootwebsocketdemo.mapper;

import com.example.springbootwebsocketdemo.entity.ModelHierarchicalOnlineUsers;
import com.example.springbootwebsocketdemo.query.ModelHierarchicalOnlineUsersQuery;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.springframework.stereotype.Component;

/**
 * @Description 在线用户信息表 Mapper 接口
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Component
public interface ModelHierarchicalOnlineUsersMapper extends MppBaseMapper<ModelHierarchicalOnlineUsers> {

}
