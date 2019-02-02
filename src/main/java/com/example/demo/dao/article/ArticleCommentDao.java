package com.example.demo.dao.article;

import java.util.List;

import com.example.demo.entity.ArticleComment;

public interface ArticleCommentDao {
	public int insertArticleComment(ArticleComment recordArticleComment) throws Exception;
	
	public int deleteArticleCommentById(int recordId) throws Exception;
	public int deleteArticleCommentByArticleInfoId(int recordArticleInfoId) throws Exception;
	
	public ArticleComment selectArticleCommentById(int recordId) throws Exception;
	public List<ArticleComment> selectArticleCommentByArticleInfoId(int recordArticleInfoId) throws Exception;
	public List<ArticleComment> selectArticleCommentByContentParts(String recordContentParts) throws Exception;
	public List<ArticleComment> selectArticleCommentByName(String recordName) throws Exception;
	public List<ArticleComment> selectArticleCommentByIsEffective(boolean recordIsEffective) throws Exception;
	public List<ArticleComment> selectArticleCommentAll() throws Exception;
	

	public int updateArticleComment(ArticleComment recordArticleComment) throws Exception;
}
