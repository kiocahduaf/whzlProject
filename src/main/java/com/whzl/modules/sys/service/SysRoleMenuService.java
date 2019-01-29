package com.whzl.modules.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.whzl.modules.sys.entity.SysRoleMenuEntity;



/**
 * 角色与菜单对应关系
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {
	
	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
	
}
