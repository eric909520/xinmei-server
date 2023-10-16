package com.backend.project.system.mapper;

import com.backend.project.system.domain.Doc;
import java.util.List;

/**
 * 文件Mapper接口
 *
 * @author backend
 * @date 2023-10-13
 */
public interface DocMapper {
    /**
     * 查询文件
     *
     * @param id 文件ID
     * @return 文件
     */
    public Doc selectDocById(Long id);

    /**
     * 查询文件列表
     *
     * @param doc 文件
     * @return 文件集合
     */
    public List<Doc> selectDocList(Doc doc);

    /**
     * 新增文件
     *
     * @param doc 文件
     * @return 结果
     */
    public int insertDoc(Doc doc);

    /**
     * 修改文件
     *
     * @param doc 文件
     * @return 结果
     */
    public int updateDoc(Doc doc);
}
