package com.backend.project.system.domain;

import lombok.Data;

@Data
public class News extends BaseEntity {

    private Long id;

    // 标题
    private String title;

    // 主图
    private String icon;

    // 简介内容
    private String simpleContent;

    // 内容
    private String content;

    // 启用状态，0:关闭，1:正常
    private Integer enable;

    // 创建用户
    private String createUser;

    // 创建时间
    private Long createTime;

    // 更新用户
    private String modifiedUser;

    // 更新时间
    private Long modifiedTime;

    // 语言，0:中文，1:英文
    private Integer langue;

}
