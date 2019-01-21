package com.example.demo.entity;

import java.util.Date;

/**
 * 文章内容表 article_content表 实体类
 * @author:Maoxian
 * @creat:2019-01-21 14:59
 */
public class ArticleContent {
	//文章内容id
	private int id;
	//文章文本内容
	private String content;
	//创建日期
	private Date createBy;
	//修改日期
	private Date modifiedBy;
	//该文章内容对应的文章信息表id号
	private int articleInfoId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Date createBy) {
		this.createBy = createBy;
	}
	
	public Date getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Date modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public int getArticleInfoId() {
		return articleInfoId;
	}
	public void setArticleInfoId(int articleInfoId) {
		this.articleInfoId = articleInfoId;
	}

	
}
