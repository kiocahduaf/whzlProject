package com.whzl.modules.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whzl.modules.sys.entity.SysUserEntity;

/**
 * Controller公共组件
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
}
