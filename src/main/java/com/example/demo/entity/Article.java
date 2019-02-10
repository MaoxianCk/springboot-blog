package com.example.demo.entity;

import java.util.List;

/**
 * 文章实体类
 * 包含文章信息 和 文章评论 对象
 * 
 * 文章评论不再包含于文章实体类中，单独处理
 * @author:Maoxian
 */
public class Article {
	private ArticleInfo articleInfo;
	private ArticleContent articleContent;
	
	@Deprecated
	private List<ArticleComment> articleCommentList = null;
	
	@Deprecated
	public Article(ArticleInfo articleInfo, ArticleContent articleContent, List<ArticleComment> articleCommentList) {
		this.articleInfo = articleInfo;
		this.articleContent = articleContent;
		this.articleCommentList = articleCommentList;
	}
	public Article(ArticleInfo articleInfo, ArticleContent articleContent) {
		this.articleInfo = articleInfo;
		this.articleContent = articleContent;
	}
	public Article() {
		this.articleInfo = null;
		this.articleContent = null;
	}
	
	public ArticleInfo getArticleInfo() {
		return articleInfo;
	}
	public void setArticleInfo(ArticleInfo articleInfo) {
		this.articleInfo = articleInfo;
	}
	public ArticleContent getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(ArticleContent articleContent) {
		this.articleContent = articleContent;
	}
	@Deprecated
	public List<ArticleComment> getArticleComment() {
		return articleCommentList;
	}
	@Deprecated
	public void addArticleCommentList(ArticleComment articleComment) {
		this.articleCommentList.add(articleComment);
	}
	
	
}
