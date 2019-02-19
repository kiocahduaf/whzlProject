package com.whzl.modules.news.service;

import com.baomidou.mybatisplus.service.IService;
import com.whzl.common.utils.PageUtils;
import com.whzl.modules.news.entity.NewsEntity;

import java.util.Map;

/**
 * 新闻管理
 *
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-18 16:17:57
 */
public interface NewsService extends IService<NewsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

