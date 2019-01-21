package com.example.demo.entity;

import java.util.Date;

/**
 * 文章评论表 article_comment表 实体类
 * @author:Maoxian
 * @creat:2019-01-21 15:05
 */
public class ArticleComment {
	//文章评论id
	private int id;
	//评论内容
	private String content;
	//评论时期
	private Date createBy;
	//评论者昵称
	private String name;
	//该评论是否有效
	private boolean isEffective;
	//该文章评论对应的文章信息表id号
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isEffective() {
		return isEffective;
	}
	public void setEffective(boolean isEffective) {
		this.isEffective = isEffective;
	}
	
	public int getArticleInfoId() {
		return articleInfoId;
	}
	public void setArticleInfoId(int articleInfoId) {
		this.articleInfoId = articleInfoId;
	}
	
	
}
