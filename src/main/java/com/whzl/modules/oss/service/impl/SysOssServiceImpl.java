package com.whzl.modules.oss.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.whzl.common.utils.PageUtils;
import com.whzl.common.utils.Query;
import com.whzl.modules.oss.dao.SysOssDao;
import com.whzl.modules.oss.entity.SysOssEntity;
import com.whzl.modules.oss.service.SysOssService;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<SysOssEntity> page = this.selectPage(
				new Query<SysOssEntity>(params).getPage()
		);

		return new PageUtils(page);
	}
	
}
