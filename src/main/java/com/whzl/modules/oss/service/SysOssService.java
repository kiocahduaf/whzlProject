package com.whzl.modules.oss.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.whzl.common.utils.PageUtils;
import com.whzl.modules.oss.entity.SysOssEntity;

/**
 * 文件上传
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
