package com.whzl.modules.company.service;


import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.whzl.common.loginForm.LoginForm;
import com.whzl.common.utils.PageUtils;
import com.whzl.modules.company.entity.CompanyEntity;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
public interface CompanyService extends IService<CompanyEntity> {

	CompanyEntity queryByMobile(String mobile);

	/**
	 * 企业登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	long login(LoginForm form);
	
	/**
	 * 分页查询企业信息
	 */
	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 批量删除企业信息
	 */
	void deleteBatch(Long[] companyIds);
}
