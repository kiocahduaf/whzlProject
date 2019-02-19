package com.whzl.modules.company.service.impl;


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
import com.whzl.modules.company.dao.CompanyDao;
import com.whzl.modules.company.entity.CompanyEntity;
import com.whzl.modules.company.service.CompanyService;


@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity> implements CompanyService {

	@Override
	public CompanyEntity queryByMobile(String mobile) {
		CompanyEntity companyEntity = new CompanyEntity();
		companyEntity.setMobile(mobile);
		return baseMapper.selectOne(companyEntity);
	}

	@Override
	public long login(LoginForm form) {
		CompanyEntity company = queryByMobile(form.getMobile());
		Assert.isNull(company, "手机号或密码错误");

		//密码错误
		if(!company.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		return company.getId();
	}
	
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String companyname = (String)params.get("companyname");
		Page<CompanyEntity> page = this.selectPage(
				new Query<CompanyEntity>(params).getPage(),
				new EntityWrapper<CompanyEntity>().like(StringUtils.isNotBlank(companyname),"companyname", companyname).orderBy("createTime")
		);

		return new PageUtils(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] companyIds) {
    	//删除数据
    	this.deleteBatchIds(Arrays.asList(companyIds));
	}
}
