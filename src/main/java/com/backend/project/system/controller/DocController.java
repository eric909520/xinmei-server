package com.backend.project.system.controller;

import com.backend.framework.aspectj.lang.annotation.Log;
import com.backend.framework.aspectj.lang.enums.BusinessType;
import com.backend.framework.web.controller.BaseController;
import com.backend.framework.web.domain.AjaxResult;
import com.backend.framework.web.page.TableDataInfo;
import com.backend.project.system.domain.AppConfig;
import com.backend.project.system.domain.Doc;
import com.backend.project.system.enums.EnableEnum;
import com.backend.project.system.service.IDocService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件Controller
 *
 * @author backend
 * @date 2023-10-13
 */
@RestController
@RequestMapping("/system/doc")
public class DocController extends BaseController {
    @Resource
    private IDocService docService;

    /**
     * 查询文件列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody Doc doc) {
        doc.setEnable(EnableEnum.open.getValue());
        List<Doc> list = docService.selectDocList(doc);
        return AjaxResult.success(list);
    }

    /**
     * 查询系统配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:appconfig:list')")
    @PostMapping("/admin/list")
    public TableDataInfo adminList(@RequestBody Doc doc) {
        doc.setOrderByColumn("id");
        doc.setIsAsc("desc");
        List<Doc> list = docService.selectDocList(doc);
        return getDataTable(list);
    }

    /**
     * 获取文件详细信息
     */
    @PostMapping(value = "/query/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(docService.selectDocById(id));
    }

    /**
     * 新增文件
     */
    @Log(title = "文件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Doc doc) {
        return toAjax(docService.insertDoc(doc));
    }

    /**
     * 修改文件
     */
    @Log(title = "文件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Doc doc) {
        return toAjax(docService.updateDoc(doc));
    }

    /**
     * 删除文件
     */
    @Log(title = "文件", businessType = BusinessType.DELETE)
    @PostMapping("/remove/{id}")
    public AjaxResult remove(@PathVariable("id") Long id) {
        return toAjax(docService.deleteDoc(id));
    }

}
