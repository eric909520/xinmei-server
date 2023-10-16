package com.backend.project.system.service.impl;

import com.backend.common.utils.ServletUtils;
import com.backend.framework.security.LoginUser;
import com.backend.framework.security.service.TokenService;
import com.backend.project.system.domain.ProjectShow;
import com.backend.project.system.domain.SysUser;
import com.backend.project.system.mapper.ProjectShowMapper;
import com.backend.project.system.service.IProjectShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ProjectShowServiceImpl implements IProjectShowService {
    @Resource
    private ProjectShowMapper projectShowMapper;

    @Resource
    private TokenService tokenService;

    @Override
    public List<ProjectShow> selectProjectShowList(ProjectShow projectShow) {
        return projectShowMapper.selectProjectShowList(projectShow);
    }

    @Override
    public int insertProjectShow(ProjectShow projectShow) {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        projectShow.setCreateUser(user.getUserName());
        projectShow.setCreateTime(new Date());
        return projectShowMapper.insertProjectShow(projectShow);
    }

    @Override
    public int updateProjectShow(ProjectShow projectShow) {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        projectShow.setUpdateUser(user.getUserName());
        projectShow.setUpdateTime(new Date());
        return  projectShowMapper.updateProjectShow(projectShow);
    }

    @Override
    public ProjectShow selectProjectShowById(Long id) {
        return projectShowMapper.selectProjectShowById(id);
    }

    @Override
    public int deleteProjectShowByIds(Long[] ids) {
        return projectShowMapper.deleteProjectShowByIds(ids);
    }
}
