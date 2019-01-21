package com.example.demo.dao.article;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.ArticleContent;

public interface ArticleContentDao {
	public boolean insertArticleContent(ArticleContent recordArticleContent);
	
	public boolean deleteArticleContentById(int recordId);
	
	public ArticleContent selectArticleContentById(int recordId);
	public ArticleContent selectArticleContentByArticleInfoId(int recordArticleInfoId);
	public List<ArticleContent> selectArticleContentByContentParts(String recordContentParts);
	public List<ArticleContent> selectArticleContentByCreateTime(Date recordCreateTime);
	public List<ArticleContent> selectArticleContentByModifiedTime(Date recordModifiedTime);
	
	public boolean updateArticleContent(ArticleContent recordarticleContent);
}
