package com.whzl.modules.news.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.whzl.common.utils.PageUtils;
import com.whzl.common.utils.Query;

import com.whzl.modules.news.dao.NewsDao;
import com.whzl.modules.news.entity.NewsEntity;
import com.whzl.modules.news.service.NewsService;


@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	String newsName = (String)params.get("newsName");
        Page<NewsEntity> page = this.selectPage(
                new Query<NewsEntity>(params).getPage(),
                new EntityWrapper<NewsEntity>().like(StringUtils.isNotBlank(newsName),"newsName", newsName).orderBy("createTime")
        );

        return new PageUtils(page);
    }

}
