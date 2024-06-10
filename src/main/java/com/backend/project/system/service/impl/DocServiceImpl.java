package com.backend.project.system.service.impl;

import com.backend.project.system.domain.Doc;
import com.backend.project.system.mapper.DocMapper;
import com.backend.project.system.service.IDocService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件Service业务层处理
 *
 * @author backend
 * @date 2023-10-13
 */
@Service
public class DocServiceImpl implements IDocService {
    @Resource
    private DocMapper docMapper;

    /**
     * 查询文件
     *
     * @param id 文件ID
     * @return 文件
     */
    @Override
    public Doc selectDocById(Long id) {
        return docMapper.selectDocById(id);
    }

    /**
     * 查询文件列表
     *
     * @param doc 文件
     * @return 文件
     */
    @Override
    public List<Doc> selectDocList(Doc doc) {
        return docMapper.selectDocList(doc);
    }

    /**
     * 新增文件
     *
     * @param doc 文件
     * @return 结果
     */
    @Override
    public int insertDoc(Doc doc) {
        return docMapper.insertDoc(doc);
    }

    /**
     * 修改文件
     *
     * @param doc 文件
     * @return 结果
     */
    @Override
    public int updateDoc(Doc doc) {
        return docMapper.updateDoc(doc);
    }

    @Override
    public int deleteDoc(Long id) {
        return docMapper.deleteDoc(id);
    }

}
