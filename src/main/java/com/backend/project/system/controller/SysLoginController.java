package com.backend.project.system.controller;

import com.backend.common.constant.Constants;
import com.backend.common.utils.ServletUtils;
import com.backend.framework.redis.RedisCache;
import com.backend.framework.security.LoginUser;
import com.backend.framework.security.service.SysLoginService;
import com.backend.framework.security.service.SysPermissionService;
import com.backend.framework.security.service.TokenService;
import com.backend.framework.web.domain.AjaxResult;
import com.backend.project.system.domain.SysMenu;
import com.backend.project.system.domain.SysUser;
import com.backend.project.system.domain.vo.LoginInfoVo;
import com.backend.project.system.mapper.SysUserMapper;
import com.backend.project.system.service.ISysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * 登录验证
 *
 * @author
 */
@RestController
public class SysLoginController {
    @Resource
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private RedisCache redisCache;

    Logger log = LoggerFactory.getLogger(SysLoginController.class);

    /**
     * 登录方法
     *
     * @param loginInfoVo
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginInfoVo loginInfoVo) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginInfoVo);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @PostMapping("getInfo")
    public AjaxResult getInfo() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @PostMapping("getRouters")
    public AjaxResult getRouters() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
