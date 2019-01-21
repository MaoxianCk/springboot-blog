package com.example.demo.dao.article;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.ArticleComment;

public interface ArticleCommentDao {
	public boolean insertArticleComment(ArticleComment recordArticleComment);
	
	public boolean deleteArticleCommentById(int recordId);
	
	public ArticleComment selectArticleCommentById(int recordId);
	public ArticleComment selectArticleCommentByArticleInfoId(int recordArticleInfoId);
	public List<ArticleComment> selectArticleCommentByCreateTime(Date recordCreateTime);
	public List<ArticleComment> selectArticleCommentByContentParts(String recordContentParts);
	public List<ArticleComment> selectArticleCommentByName(String recordName);
	public List<ArticleComment> selectArticleCommentByIsEffective(boolean recordIsEffective);
	
	public boolean updateArticleComment(ArticleComment recordArticleComment);
}
