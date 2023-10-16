package com.backend.project.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProjectShow {
    /**
     * 自增长主键ID
     */
    private Long id;

    /**
     * 项目名称
     */
    @NotNull(message = "项目名称不能为空")
    private String projectName;

    /**
     * 项目类型
     */
    @NotNull(message = "项目类型不能为空")
    private String projectType;

    /**
     * 图片路径
     */
    @NotNull(message = "图片路径不能为空")
    private String picUrl;

    /**
     * 项目详情
     */
    @NotNull(message = "项目详情不能为空")
    private String projectDetail;

    /**
     * 创建人
     */
    @NotNull(message = "创建人不能为空")
    private String createUser;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 更新日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;
}
