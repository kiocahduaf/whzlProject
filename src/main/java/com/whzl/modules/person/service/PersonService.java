package com.whzl.modules.person.service;


import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.whzl.common.loginForm.LoginForm;
import com.whzl.common.utils.PageUtils;
import com.whzl.modules.person.entity.PersonEntity;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
public interface PersonService extends IService<PersonEntity> {

	PersonEntity queryByMobile(String mobile);

	/**
	 * 个人登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	long login(LoginForm form);
	
	/**
	 * 分页查询个人信息
	 */
	PageUtils queryPage(Map<String, Object> params);
	/**
	 * 批量删除个人信息
	 */
	void deleteBatch(Long[] personIds);
}
