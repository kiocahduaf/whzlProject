package com.whzl.modules.sys.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.whzl.common.utils.PageUtils;
import com.whzl.modules.sys.entity.SysLogEntity;


/**
 * 系统日志
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
