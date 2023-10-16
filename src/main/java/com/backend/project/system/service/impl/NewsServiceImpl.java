package com.backend.project.system.service.impl;

import com.backend.common.utils.SecurityUtils;
import com.backend.project.system.domain.News;
import com.backend.project.system.mapper.NewsMapper;
import com.backend.project.system.service.INewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 新闻Service业务层处理
 *
 * @author
 */
@Service
public class NewsServiceImpl implements INewsService {
    @Resource
    private NewsMapper newsMapper;

    /**
     * 查询新闻
     *
     * @param id 新闻ID
     * @return 新闻
     */
    @Override
    public News selectNewsById(Long id) {
        return newsMapper.selectNewsById(id);
    }

    /**
     * 查询新闻前一条
     *
     * @return 新闻
     */
    @Override
    public News selectNewsBefore(News news) {
        return newsMapper.selectNewsBefore(news);
    }

    /**
     * 查询新闻后一条
     *
     * @return 新闻
     */
    @Override
    public News selectNewsAfter(News news) {
        return newsMapper.selectNewsAfter(news);
    }

    /**
     * 查询新闻列表
     *
     * @param News 新闻
     * @return 新闻
     */
    @Override
    public List<News> selectNewsList(News News) {
        return newsMapper.selectNewsList(News);
    }

    /**
     * 查询新闻列表
     *
     * @param News 新闻
     * @return 新闻
     */
    @Override
    public List<News> selectNewsListOpen(News News) {
        return newsMapper.selectNewsListOpen(News);
    }

    /**
     * 新增新闻
     *
     * @param news 新闻
     * @return 结果
     */
    @Override
    public int insertNews(News news) {
        news.setCreateTime(System.currentTimeMillis());
        news.setCreateUser(SecurityUtils.getUsername());
        return newsMapper.insertNews(news);
    }

    /**
     * 修改新闻
     *
     * @param news 新闻
     * @return 结果
     */
    @Override
    public int updateNews(News news) {
        news.setModifiedTime(System.currentTimeMillis());
        news.setModifiedUser(SecurityUtils.getUsername());
        return newsMapper.updateNews(news);
    }

    /**
     * 删除新闻信息
     *
     * @param id 新闻ID
     * @return 结果
     */
    @Override
    public int deleteNewsById(Long id) {
        return newsMapper.deleteNewsById(id);
    }
}
