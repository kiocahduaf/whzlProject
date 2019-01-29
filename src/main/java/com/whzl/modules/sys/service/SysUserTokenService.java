package com.whzl.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.whzl.common.utils.R;
import com.whzl.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
