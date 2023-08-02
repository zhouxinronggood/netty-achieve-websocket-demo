-- 消息内容记录表
DROP TABLE IF EXISTS dds_model_message_content_record;
CREATE TABLE `dds_model_message_content_record`
(
    `id`                  varchar(64) NOT NULL COMMENT 'id',
    `sys_level_id`        varchar(64) NOT NULL COMMENT '层次id',
    `production_calendar` varchar(64) NOT NULL COMMENT '投产日历',
    `page_id`             varchar(64) NULL DEFAULT NULL COMMENT '页码表id',
    `message_content`     text        NOT NULL COMMENT '发送消息内容',
    `message_type`        varchar(10) NULL DEFAULT 'text' COMMENT '发送的消息类型，如文本-text、图片-image、语音-voice、视频-video、文件-file等',
    `create_time`         datetime    NOT NULL COMMENT '创建时间',
    `message_order`       varchar(32) NOT NULL COMMENT '消息次序',
    PRIMARY KEY (`id`),
    INDEX                 index_message_order (`message_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '模型消息内容记录表';

-- 消息发送记录表
DROP TABLE IF EXISTS dds_model_send_message_record;
CREATE TABLE `dds_model_send_message_record`
(
    `id`                  varchar(64) NOT NULL COMMENT 'id',
    `sys_level_id`        varchar(64) NOT NULL COMMENT '层次id',
    `production_calendar` varchar(64) NOT NULL COMMENT '投产日历',
    `page_id`             varchar(64) NULL DEFAULT NULL COMMENT '页码表id',
    `message_id`          varchar(64) NOT NULL COMMENT '发送消息id',
    `create_time`         datetime    NOT NULL COMMENT '创建时间',
    `update_time`         datetime    NOT NULL COMMENT '更新时间',
    `status`              tinyint(1) NULL DEFAULT '1' COMMENT '是否删除 0-删除 1-使用',
    `retry_count`         INT (11) NULL DEFAULT '1' COMMENT '重试次数',
    `retry_success_flag`  tinyint(1) NULL DEFAULT '0' COMMENT '重发成功标识 0-重发失败或未重发 1-不需要重发',
    `user_id`             varchar(64) NOT NULL COMMENT '在线用户信息表id',
    PRIMARY KEY (`id`),
    INDEX                 index_message_id (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '模型消息发送记录表';

-- 在线用户信息表：
DROP TABLE IF EXISTS dds_model_hierarchical_online_users;
CREATE TABLE `dds_model_hierarchical_online_users`
(
    `id`                  varchar(64) NOT NULL COMMENT 'id',
    `sys_level_id`        varchar(64) NOT NULL COMMENT '层次id',
    `production_calendar` varchar(64) NOT NULL COMMENT '投产日历',
    `page_id`             varchar(64) NULL DEFAULT NULL COMMENT '页码表id',
    `create_time`         datetime    NOT NULL COMMENT '创建时间',
    `update_time`         datetime    NOT NULL COMMENT '更新时间',
    `online_status`       tinyint(1) NULL DEFAULT '1' COMMENT '是否在线 0-不在线 1-在线',
    `send_message_type`   tinyint(2) DEFAULT 1 COMMENT '发送消息类型: 0-不给所有人发、1-给所有人发【默认为1】、2-发送ping消息、3-给所有人发ping消息、4-只发给除自己之外的所有人、5-发送关闭无效ws、6-更新在线用户表在线状态';
    PRIMARY KEY (`id`),
    INDEX                 index_online_status (`online_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4   COMMENT '在线用户信息表';