package com.example.demo.entity;

import java.util.List;

public class Article {
	private ArticleInfo articleInfo;
	private ArticleContent articleContent;
	private List<ArticleComment> articleCommentList;
	
	public Article(ArticleInfo articleInfo, ArticleContent articleContent, List<ArticleComment> articleCommentList) {
		this.articleInfo = articleInfo;
		this.articleContent = articleContent;
		this.articleCommentList = articleCommentList;
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
	public List<ArticleComment> getArticleComment() {
		return articleCommentList;
	}
	public void addArticleCommentList(ArticleComment articleComment) {
		this.articleCommentList.add(articleComment);
	}
	
	
}
