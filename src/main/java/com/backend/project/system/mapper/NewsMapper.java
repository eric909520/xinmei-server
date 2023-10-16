package com.backend.project.system.mapper;

import com.backend.project.system.domain.News;

import java.util.List;

/**
 * 新闻Mapper接口
 *
 * @author
 */
public interface NewsMapper {
    /**
     * 查询新闻
     *
     * @param id 新闻ID
     * @return 新闻
     */
    public News selectNewsById(Long id);

    /**
     * 查询新闻前一条
     *
     * @return 新闻
     */
    public News selectNewsBefore(News news);

    /**
     * 查询新闻后一条
     *
     * @return 新闻
     */
    public News selectNewsAfter(News news);

    /**
     * 查询新闻列表
     *
     * @param news 新闻
     * @return 新闻集合
     */
    public List<News> selectNewsList(News news);

    /**
     * 查询新闻列表
     *
     * @param news 新闻
     * @return 新闻集合
     */
    public List<News> selectNewsListOpen(News news);

    /**
     * 新增新闻
     *
     * @param news 新闻
     * @return 结果
     */
    public int insertNews(News news);

    /**
     * 修改新闻
     *
     * @param news 新闻
     * @return 结果
     */
    public int updateNews(News news);

    /**
     * 删除新闻
     *
     * @param id 新闻ID
     * @return 结果
     */
    public int deleteNewsById(Long id);

}
