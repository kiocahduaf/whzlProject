package com.whzl.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.whzl.modules.sys.entity.SysUserTokenEntity;

/**
 * 系统用户Token
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {

    SysUserTokenEntity queryByToken(String token);
	
}
