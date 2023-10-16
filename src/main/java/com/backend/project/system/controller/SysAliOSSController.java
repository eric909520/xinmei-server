package com.backend.project.system.controller;

import com.backend.framework.web.controller.BaseController;
import com.backend.framework.web.domain.AjaxResult;
import com.backend.project.system.mapper.AppConfigMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 阿里云oss
 *
 */
@RestController
@RequestMapping("/system/alioss")
public class SysAliOSSController extends BaseController {
    @Resource
    private AppConfigMapper appConfigMapper;

    /**
     * 根据参数键名查询参数值
     */
    @PostMapping(value = "/getConfig")
    public AjaxResult getConfigKey() {
        String endpoint = appConfigMapper.selectAppConfigByKey("endpoint").getCValue();
        String accessKeyId = appConfigMapper.selectAppConfigByKey("id").getCValue();
        String accessKeySecret = appConfigMapper.selectAppConfigByKey("accessKeySecret").getCValue();
        String bucketName = appConfigMapper.selectAppConfigByKey("bucketName").getCValue();
        Map<String, String> map = new HashMap<>();
        map.put("endpoint", endpoint);
        map.put("accessKeyId", accessKeyId);
        map.put("accessKeySecret", accessKeySecret);
        map.put("bucketName", bucketName);
        return AjaxResult.success(map);
    }

}
