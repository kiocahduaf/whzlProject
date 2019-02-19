package com.whzl.modules.news.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻管理
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-18 16:17:57
 */
@TableName("tb_news")
public class NewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 标题
	 */
	private String newstitle;
	/**
	 * 容内
	 */
	private String newscontent;
	/**
	 * 布人发
	 */
	private String newsissuer;
	/**
	 * 发布时间
	 */
	private Date createTime;

	/**
	 * 设置：ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：标题
	 */
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	/**
	 * 获取：标题
	 */
	public String getNewstitle() {
		return newstitle;
	}
	/**
	 * 设置：容内
	 */
	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}
	/**
	 * 获取：容内
	 */
	public String getNewscontent() {
		return newscontent;
	}
	/**
	 * 设置：布人发
	 */
	public void setNewsissuer(String newsissuer) {
		this.newsissuer = newsissuer;
	}
	/**
	 * 获取：布人发
	 */
	public String getNewsissuer() {
		return newsissuer;
	}
	/**
	 * 设置：发布时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
