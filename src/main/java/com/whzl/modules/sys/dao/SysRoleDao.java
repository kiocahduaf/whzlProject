package com.whzl.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.whzl.modules.sys.entity.SysRoleEntity;

/**
 * 角色管理
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
