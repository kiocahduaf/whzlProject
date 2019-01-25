package com.whzl.modules.person.controller;

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
import com.whzl.modules.person.entity.PersonEntity;
import com.whzl.modules.person.service.PersonService;

/**
 * 个人用户
 * 
 * @author xuchao
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/person/user")
public class PersonUserController{
	@Autowired
    private PersonService personService;

	/**
	 * 所有用户列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("person:user:list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = personService.queryPage(params);
		return R.ok().put("page", page);
	}
	
	/**
	 * 获取用户信息
	 */
	@GetMapping("/info/{id}")
	@RequiresPermissions("person:user:info")
	public R info(@PathVariable("id") Long id){
		PersonEntity person = personService.selectById(id);
		return R.ok().put("person", person);
	}

	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@PostMapping("/save")
	@RequiresPermissions("person:user:save")
	public R save(@RequestBody PersonEntity person){
		ValidatorUtils.validateEntity(person);
		person.setCreateTime(new Date());
		personService.insert(person);
		return R.ok();
	}
	
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@PostMapping("/update")
	@RequiresPermissions("person:user:update")
	public R update(@RequestBody PersonEntity person){
		ValidatorUtils.validateEntity(person);
		personService.updateById(person);
		return R.ok();
	}
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@PostMapping("/delete")
	@RequiresPermissions("person:user:delete")
	public R delete(@RequestBody Long[] personIds){
		personService.deleteBatch(personIds);
		return R.ok();
	}
}
