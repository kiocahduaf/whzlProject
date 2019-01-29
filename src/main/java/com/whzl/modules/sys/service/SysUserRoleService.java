package com.whzl.modules.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.whzl.modules.sys.entity.SysUserRoleEntity;



/**
 * 用户与角色对应关系
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {
	
	void saveOrUpdate(Long userId, List<Long> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
