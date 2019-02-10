package com.example.demo.dao.article;

import java.util.List;

import com.example.demo.entity.ArticleContent;

public interface ArticleContentDao {
	/* 插入 */
	public int insertArticleContent(ArticleContent recordArticleContent) throws Exception;
	
	/* 删除 */
	public int deleteArticleContentById(int recordId) throws Exception;
	public int deleteArticleContentByArticleInfoId(int recordArticleInfoId) throws Exception;
	
	/* 查找 */
	public ArticleContent selectArticleContentById(int recordId) throws Exception;
	public ArticleContent selectArticleContentByArticleInfoId(int recordArticleInfoId) throws Exception;
	public List<ArticleContent> selectArticleContentByContentParts(String recordContentParts) throws Exception;
	public List<ArticleContent> selectArticleContentAll() throws Exception; 
	
	/* 修改 */
	public int updateArticleContent(ArticleContent recordArticleContent) throws Exception;
}
