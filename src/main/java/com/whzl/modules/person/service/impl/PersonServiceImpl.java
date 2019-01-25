package com.whzl.modules.person.service.impl;


import java.util.Arrays;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.whzl.common.exception.RRException;
import com.whzl.common.loginForm.LoginForm;
import com.whzl.common.utils.PageUtils;
import com.whzl.common.utils.Query;
import com.whzl.common.validator.Assert;
import com.whzl.modules.person.dao.PersonDao;
import com.whzl.modules.person.entity.PersonEntity;
import com.whzl.modules.person.service.PersonService;


@Service("personService")
public class PersonServiceImpl extends ServiceImpl<PersonDao, PersonEntity> implements PersonService {

	@Override	
	public PersonEntity queryByMobile(String mobile) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setMobile(mobile);
		return baseMapper.selectOne(personEntity);
	}

	@Override
	public long login(LoginForm form) {
		PersonEntity person = queryByMobile(form.getMobile());
		Assert.isNull(person, "手机号或密码错误");

		//密码错误
		if(!person.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		return person.getId();
	}
	
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String personname = (String)params.get("personname");
		Page<PersonEntity> page = this.selectPage(
				new Query<PersonEntity>(params).getPage(),
				new EntityWrapper<PersonEntity>().like(StringUtils.isNotBlank(personname),"personname", personname)
		);

		return new PageUtils(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] personIds) {
    	//删除数据
    	this.deleteBatchIds(Arrays.asList(personIds));
	}
}
