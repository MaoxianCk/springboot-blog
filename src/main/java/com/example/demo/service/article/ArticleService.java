package com.example.demo.service.article;

import java.util.List;

import com.example.demo.entity.ArticleContent;
import com.example.demo.entity.ArticleInfo;
import com.example.demo.entity.Article;

public interface ArticleService {
	public void addArticle(ArticleInfo info,ArticleContent content);
	public void deleteArticle(int articleInfoId);
	public void updateArticle(ArticleInfo info,ArticleContent content);
	public Article findArticle(int articleInfoId);
	public ArticleInfo findArticleInfo(int articleInfoId);
	public List<Article> findArticles(String title,String contentPart);
	public List<Article> findArticles();
	public List<ArticleInfo> findArticleInfos();
}
