package com.backend.project.system.service;

import com.backend.project.system.domain.ProjectShow;

import java.util.List;

public interface IProjectShowService {
    public List<ProjectShow> selectProjectShowList(ProjectShow projectShow);



    public int insertProjectShow(ProjectShow projectShow);

    public int updateProjectShow(ProjectShow projectShow);

    public ProjectShow  selectProjectShowById(Long id);

    public int deleteProjectShowByIds(Long[] ids);
}
