package com.backend.project.system.mapper;

import com.backend.project.system.domain.ProjectShow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统配置Mapper接口
 *
 * @author
 * @date 2020-06-24
 */
@Repository
public interface ProjectShowMapper {
    public List<ProjectShow> selectProjectShowList(ProjectShow projectShow);
    public List<ProjectShow> selectProjectShowList();

    public int insertProjectShow(ProjectShow projectShow);

    //修改
    public int updateProjectShow(ProjectShow projectShow);
    public ProjectShow selectProjectShowById(Long id);

    public int deleteProjectShowByIds(Long[] ids);
}
