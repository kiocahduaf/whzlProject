package com.whzl.modules.sys.service;

import java.util.Set;

import com.whzl.modules.sys.entity.SysUserEntity;
import com.whzl.modules.sys.entity.SysUserTokenEntity;

/**
 * shiro相关接口
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    SysUserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUserEntity queryUser(Long userId);
}
