package com.whzl.modules.job.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.whzl.common.utils.PageUtils;
import com.whzl.modules.job.entity.ScheduleJobEntity;

/**
 * 定时任务
 *
 * @author xuchao
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
public interface ScheduleJobService extends IService<ScheduleJobEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 保存定时任务
	 */
	void save(ScheduleJobEntity scheduleJob);
	
	/**
	 * 更新定时任务
	 */
	void update(ScheduleJobEntity scheduleJob);
	
	/**
	 * 批量删除定时任务
	 */
	void deleteBatch(Long[] jobIds);
	
	/**
	 * 批量更新定时任务状态
	 */
	int updateBatch(Long[] jobIds, int status);
	
	/**
	 * 立即执行
	 */
	void run(Long[] jobIds);
	
	/**
	 * 暂停运行
	 */
	void pause(Long[] jobIds);
	
	/**
	 * 恢复运行
	 */
	void resume(Long[] jobIds);
}
