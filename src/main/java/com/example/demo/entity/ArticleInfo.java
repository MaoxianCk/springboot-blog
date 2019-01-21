package com.example.demo.entity;

import java.util.Date;

/**
 * 文章信息表 article_info表 实体类
 * @author:Maoxian
 * @creat:2019-01-21 14:43
 */
public class ArticleInfo {
	//文章信息id
	private int id;
	//文章标题
	private String title;
	//文章简介
	private String summary;
	//是否置顶
	private boolean isTop;
	//创建日期
	private Date creatBy;
	//修改日期
	private Date modifiedBy;
	//该文章信息对应的文章内容表id号
	private int articleId;
	//该文章信息对应的文章评论表id号
	private int articleCommentId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public boolean isTop() {
		return isTop;
	}
	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}
	
	public Date getCreatBy() {
		return creatBy;
	}
	public void setCreatBy(Date creatBy) {
		this.creatBy = creatBy;
	}
	
	public Date getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Date modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	
	public int getArticleCommentId() {
		return articleCommentId;
	}
	public void setArticleCommentId(int articleCommentId) {
		this.articleCommentId = articleCommentId;
	}
	
	
	
}
