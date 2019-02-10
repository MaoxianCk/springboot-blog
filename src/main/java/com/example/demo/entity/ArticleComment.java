package com.example.demo.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 文章评论表 article_comment表 实体类
 * 
 * @author:Maoxian
 */
public class ArticleComment {
	// 文章评论id
	private int id;
	// 评论者昵称
	private String name;
	// 评论内容
	private String content;
	// 评论时期
	private Timestamp createTime;
	// 该评论是否有效
	private boolean isEffective;
	// 该文章评论对应的文章表id号
	private int articleInfoId;

	public ArticleComment(int id, String content,Timestamp createTime, String name, boolean isEffective,
			int articleInfoId) {
		super();
		this.id = id;
		this.content = content;
		this.createTime = createTime;
		this.name = name;
		this.isEffective = isEffective;
		this.articleInfoId = articleInfoId;
	}
	
	public ArticleComment(int id, String content, String name, boolean isEffective,
			int articleInfoId) {
		super();
		this.id = id;
		this.content = content;
		this.createTime = new Timestamp(System.currentTimeMillis());
		this.name = name;
		this.isEffective = isEffective;
		this.articleInfoId = articleInfoId;
	}
	
	public ArticleComment(String name,String content) {
		this.id = 0;
		this.content = content;
		this.createTime = new Timestamp(System.currentTimeMillis());
		this.name = name;
		this.isEffective = false;
		this.articleInfoId = 0;
	}
	
	public ArticleComment() {}

	public void printArticleCommentInfo() {
		System.out.println("id:" + getId() + "\tcontent:" + getContent() + "\tcreateTime:" + getCreateTime() + "\tname:"
				+ getName() + "\tisEffective:" + getIsEffective() + "\tarticleInfoId:" + getArticleInfoId());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		/* id号不提供修改 */
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Timestamp getCreateTime() {

		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(boolean isEffective) {
		this.isEffective = isEffective;
	}

	public int getArticleInfoId() {
		return articleInfoId;
	}

	public void setArticleInfoId(int articleInfoId) {
		this.articleInfoId = articleInfoId;
	}

}
