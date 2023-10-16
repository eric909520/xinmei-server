package com.backend.project.system.api;

import com.backend.framework.web.controller.BaseController;
import com.backend.framework.web.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开放接口 Controller
 *
 * @author
 * @date
 */
@RestController
@RequestMapping("/system/open/api/")
@Slf4j
public class OpenApiController extends BaseController {

    /**
     * 获取用户详细信息
     */
    @PostMapping(value = "/getinfo/{name}")
    public AjaxResult getInfo(@PathVariable("name") String name) {
        return AjaxResult.success();
    }



}
