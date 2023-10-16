package com.backend.project.system.controller;

import com.backend.framework.web.controller.BaseController;
import com.backend.framework.web.domain.AjaxResult;
import com.backend.project.system.domain.ProjectShow;
import com.backend.project.system.service.IProjectShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectShow")
public class ProjectShowController extends BaseController {
    @Autowired
    private IProjectShowService iProjectShowService;

    @PostMapping("/list")
    public AjaxResult list(ProjectShow projectShow) {
        List<ProjectShow> list = iProjectShowService.selectProjectShowList(projectShow);
        return  AjaxResult.success(list);
    }
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ProjectShow projectShow) {
        return toAjax(iProjectShowService.insertProjectShow(projectShow));
    }

    /**
     * 修改
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody ProjectShow projectShow) {
        return toAjax(iProjectShowService.updateProjectShow(projectShow));
    }

    /**
     * 点击修改按钮后获项目展示的详细信息
     */
    @PostMapping(value = "/query/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(iProjectShowService.selectProjectShowById(id));
    }

    /**
     * 删除
     */

    @PostMapping("/delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(iProjectShowService.deleteProjectShowByIds(ids));
    }
}
