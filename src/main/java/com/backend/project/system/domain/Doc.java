package com.backend.project.system.domain;

import com.backend.framework.aspectj.lang.annotation.Excel;
import lombok.Data;

/**
 * 文件对象 doc
 *
 * @author backend
 * @date 2023-10-13
 */
@Data
public class Doc extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 启用状态，0:关闭，1:正常
     */
    @Excel(name = "启用状态，0:关闭，1:正常")
    private Integer enable;

    /**
     * 文件类型
     */
    @Excel(name = "文件类型")
    private String docType;

    /**
     * 下载链接
     */
    @Excel(name = "下载链接")
    private String link;

    /**
     * 文件名称
     */
    @Excel(name = "文件名称")
    private String docName;

    /**
     * 分类名称
     */
    @Excel(name = "分类名称")
    private String typeName;

    /**
     * 分类，0:光伏组件，1:技术支持
     */
    @Excel(name = "分类，0:光伏组件，1:技术支持")
    private Integer type;

    /**
     * 语言，0:中文，1:英文
     */
    @Excel(name = "语言，0:中文，1:英文")
    private Integer langue;

    /**
     * 主键ID
     */
    private Long id;
}
