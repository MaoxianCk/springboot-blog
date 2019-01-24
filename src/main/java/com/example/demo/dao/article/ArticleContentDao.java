package com.example.demo.dao.article;

import java.util.List;

import com.example.demo.entity.ArticleContent;

public interface ArticleContentDao {
	public int insertArticleContent(ArticleContent recordArticleContent) throws Exception;
	
	public int deleteArticleContentById(int recordId) throws Exception;
	
	public ArticleContent selectArticleContentById(int recordId) throws Exception;
	public ArticleContent selectArticleContentByArticleInfoId(int recordArticleInfoId) throws Exception;
	public List<ArticleContent> selectArticleContentByContentParts(String recordContentParts) throws Exception;
	public List<ArticleContent> selectArticleContentAll() throws Exception; 
	
	public int updateArticleContent(ArticleContent recordArticleContent) throws Exception;
}
