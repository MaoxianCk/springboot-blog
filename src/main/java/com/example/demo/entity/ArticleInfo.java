package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 文章表 article_info表 实体类
 * 
 * @author:Maoxian
 * @creat:2019-01-21 14:43
 */
public class ArticleInfo {
	// 文章id
	private int id;
	// 文章标题
	private String title;
	// 文章简介
	private String summary;
	// 是否置顶
	private boolean isTop;
	// 创建日期
	private Timestamp createTime;
	// 修改日期
	private Timestamp modifiedTime;
	// 该文章对应的文章内容表id号
	private int articleId;

	// 该文章对应的文章评论表id号
	@Deprecated
	private List<Integer> articleCommentIdList;

	public ArticleInfo(int id, String title, String summary, boolean isTop, Timestamp createTime,
			Timestamp modifiedTime, int articleId) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.isTop = isTop;
		this.createTime = createTime;
		this.modifiedTime = modifiedTime;
		this.articleId = articleId;
		this.articleCommentIdList=new ArrayList<Integer>();
	}

	public ArticleInfo(int id, String title, String summary, boolean isTop, int articleId) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.isTop = isTop;

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.createTime = timestamp;
		this.modifiedTime = timestamp;

		this.articleId = articleId;
		this.articleCommentIdList = new ArrayList<Integer>();
	}
	
	public ArticleInfo() {
		super();
		this.id = 0;
		this.title = null;
		this.summary = null;
		this.isTop = false;

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.createTime = timestamp;
		this.modifiedTime = timestamp;

		this.articleId = 0;
		this.articleCommentIdList = null;
	}

	public void printArticleInfo() {
		System.out.println("id:" + getId() + "\ttitle:" + getTitle() + "\tsummary:" + getSummary() + "\tisTop:"
				+ getIsTop() + "\tcreatetime:" + getCreateTime() + "\tmodifiedTime:" + getModifiedTime()
				+ "\tarticleId:" + getArticleId() + "\tarticleCommentId:" + String.valueOf(articleCommentIdList));
	}

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

	public boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(boolean isTop) {
		this.isTop = isTop;
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

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	@Deprecated
	public List<Integer> getArticleCommentIdList() {
		return articleCommentIdList;
	}

	@Deprecated
	public void addArticleCommentId(int articleCommentId) {
		this.articleCommentIdList.add(articleCommentId);
	}

}
