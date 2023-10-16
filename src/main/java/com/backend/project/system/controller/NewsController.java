package com.backend.project.system.controller;

import com.backend.framework.aspectj.lang.annotation.Log;
import com.backend.framework.aspectj.lang.enums.BusinessType;
import com.backend.framework.web.controller.BaseController;
import com.backend.framework.web.domain.AjaxResult;
import com.backend.framework.web.page.TableDataInfo;
import com.backend.project.system.domain.News;
import com.backend.project.system.service.INewsService;
import com.github.pagehelper.PageInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新闻Controller
 *
 * @author
 * @date 2020-06-24
 */
@RestController
@RequestMapping("/system/news")
public class NewsController extends BaseController {
    @Resource
    private INewsService newsService;

    /**
     * 查询新闻列表
     */
    @PostMapping("/newsList")
    public AjaxResult newsList(@RequestBody News news) {
        List<News> list = newsService.selectNewsListOpen(news);
        Map map = new HashMap(2);
        map.put("newsList", list);
        map.put("total", new PageInfo(list).getTotal());
        return AjaxResult.success(map);
    }

    /**
     * 查询新闻列表
     */
    @PostMapping("/detail")
    public AjaxResult detail(@RequestBody News news) {
        Map map = new HashMap(3);
        News detail = newsService.selectNewsById(news.getId());
        map.put("detail", detail);

        News before = newsService.selectNewsBefore(news);
        if (before == null) {
            map.put("before", null);
        } else {
            Map mapBefore = new HashMap(2);
            mapBefore.put("id", before.getId());
            mapBefore.put("title", before.getTitle());
            map.put("before", mapBefore);
        }

        News after = newsService.selectNewsAfter(news);
        if (after == null) {
            map.put("after", null);
        } else {
            Map mapAfter = new HashMap(2);
            mapAfter.put("id", after.getId());
            mapAfter.put("title", after.getTitle());
            map.put("after", mapAfter);
        }
        return AjaxResult.success(map);
    }

    /**
     * 查询新闻列表
     */
    @PreAuthorize("@ss.hasPermi('system:news:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody News news) {
        List<News> list = newsService.selectNewsList(news);
        return getDataTable(list);
    }

    /**
     * 获取新闻详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:news:query')")
    @PostMapping(value = "/query/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(newsService.selectNewsById(id));
    }

    /**
     * 新增新闻
     */
    @PreAuthorize("@ss.hasPermi('system:news:add')")
    @Log(title = "新闻", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody News news) {
        return toAjax(newsService.insertNews(news));
    }

    /**
     * 修改新闻
     */
    @PreAuthorize("@ss.hasPermi('system:news:edit')")
    @Log(title = "新闻", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody News news) {
        return toAjax(newsService.updateNews(news));
    }

    /**
     * 删除新闻
     */
    @PreAuthorize("@ss.hasPermi('system:News:remove')")
    @Log(title = "新闻", businessType = BusinessType.UPDATE)
    @PostMapping("/remove/{id}")
    public AjaxResult remove(@PathVariable Long id) {
        return toAjax(newsService.deleteNewsById(id));
    }
}
