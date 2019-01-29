package com.whzl.modules.job.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.whzl.modules.job.entity.ScheduleJobLogEntity;

/**
 * 定时任务日志
 *
 * @author xuchao
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {
	
}
