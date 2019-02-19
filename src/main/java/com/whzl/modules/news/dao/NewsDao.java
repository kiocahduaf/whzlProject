package com.whzl.modules.news.dao;

import com.whzl.modules.news.entity.NewsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 新闻管理
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-18 16:17:57
 */
@Mapper
public interface NewsDao extends BaseMapper<NewsEntity> {
	
}
