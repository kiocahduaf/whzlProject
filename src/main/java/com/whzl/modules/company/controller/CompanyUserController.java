package com.whzl.modules.company.controller;

import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.whzl.common.annotation.SysLog;
import com.whzl.common.utils.PageUtils;
import com.whzl.common.utils.R;
import com.whzl.common.validator.ValidatorUtils;
import com.whzl.modules.company.entity.CompanyEntity;
import com.whzl.modules.company.service.CompanyService;

/**
 * 个人用户
 * 
 * @author xuchao
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/company/user")
public class CompanyUserController{
	@Autowired
    private CompanyService companyService;

	/**
	 * 所有用户列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("company:user:list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = companyService.queryPage(params);
		return R.ok().put("page", page);
	}
	
	/**
	 * 获取用户信息
	 */
	@GetMapping("/info/{id}")
	@RequiresPermissions("company:user:info")
	public R info(@PathVariable("id") Long id){
		CompanyEntity company = companyService.selectById(id);
		return R.ok().put("company", company);
	}

	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@PostMapping("/save")
	@RequiresPermissions("company:user:save")
	public R save(@RequestBody CompanyEntity company){
		ValidatorUtils.validateEntity(company);
		company.setCreateTime(new Date());
		companyService.insert(company);
		return R.ok();
	}
	
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@PostMapping("/update")
	@RequiresPermissions("company:user:update")
	public R update(@RequestBody CompanyEntity company){
		ValidatorUtils.validateEntity(company);
		companyService.updateById(company);
		return R.ok();
	}
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@PostMapping("/delete")
	@RequiresPermissions("company:user:delete")
	public R delete(@RequestBody Long[] companyIds){
		companyService.deleteBatch(companyIds);
		return R.ok();
	}
}
