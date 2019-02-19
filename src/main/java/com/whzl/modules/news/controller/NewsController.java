package com.whzl.modules.news.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.whzl.common.annotation.SysLog;
import com.whzl.common.utils.PageUtils;
import com.whzl.common.utils.R;
import com.whzl.modules.news.entity.NewsEntity;
import com.whzl.modules.news.service.NewsService;



/**
 * 新闻管理
 *
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-18 16:17:57
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("news:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = newsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("news:info")
    public R info(@PathVariable("id") Long id){
			NewsEntity news = newsService.selectById(id);
			
        return R.ok().put("news", news);
    }

    /**
     * 保存
     */
	@SysLog("保存新闻管理")
    @PostMapping("/save")
    @RequiresPermissions("news:save")
    public R save(@RequestBody NewsEntity news){
			newsService.insert(news);

        return R.ok();
    }

    /**
     * 修改
     */
	@SysLog("修改新闻管理")
    @PutMapping("/update")
    @RequiresPermissions("news:update")
    public R update(@RequestBody NewsEntity news){
			newsService.updateById(news);

        return R.ok();
    }

    /**
     * 删除
     */
	@SysLog("删除新闻管理")
	@PostMapping("/delete")
    @RequiresPermissions("news:delete")
    public R delete(@RequestBody Long[] ids){
			newsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
