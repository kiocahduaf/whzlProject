package com.whzl.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.whzl.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
