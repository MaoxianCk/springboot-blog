package com.example.demo.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 文章内容表 article_content表 实体类
 * 
 * @author:Maoxian
 * @creat:2019-01-21 14:59
 */
public class ArticleContent {
	// 文章内容id
	private int id;
	// 文章文本内容
	private String content;
	// 创建日期
	private Timestamp createTime;
	// 修改日期
	private Timestamp modifiedTime;
	// 该文章内容对应的文章表id号
	private int articleInfoId;

	public ArticleContent(int id, String content, Timestamp createTime, Timestamp modifiedTime, int articleInfoId) {
		this.id = id;
		this.content = content;
		this.createTime = createTime;
		this.modifiedTime = modifiedTime;
		this.articleInfoId = articleInfoId;
	}

	public ArticleContent(int id, String content, int articleInfoId) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		this.id = id;
		this.content = content;
		this.createTime = timestamp;
		this.modifiedTime = timestamp;
		this.articleInfoId = articleInfoId;
	}
	public ArticleContent() {

		this.id = 0;
		this.content = null;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.createTime = timestamp;
		this.modifiedTime = timestamp;
		this.articleInfoId = 0;
	}

	public void printArticleContentInfo() {
		System.out.println("id:" + getId() + "\tcontent:" +getContent()+ "\tcreatTime:" + getCreateTime() + "\tmodifiedTime:"
				+ getModifiedTime() + "\tarticleInfoId:" + getArticleInfoId());
	}

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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public int getArticleInfoId() {
		return articleInfoId;
	}

	public void setArticleInfoId(int articleInfoId) {
		this.articleInfoId = articleInfoId;
	}

}
