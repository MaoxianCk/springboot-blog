package com.example.demo.dao.article;

import java.util.List;

import com.example.demo.entity.ArticleInfo;

public interface ArticleInfoDao {
	public int insertArticleInfo(ArticleInfo recordArticleInfo) throws Exception;
	
	public int deleteArticleInfoById(int recordId) throws Exception;
	
	public ArticleInfo selectArticleInfoById(int recordId) throws Exception;
	public ArticleInfo selectArticleInfoByArticleContentId(int recordArticleContentId) throws Exception;
	public ArticleInfo selectArticleInfoByCommentId(int recordCommentId) throws Exception; 
	public List<ArticleInfo> selectArticleInfoByTitle(String recordTitle) throws Exception;
	public List<ArticleInfo> selectArticleInfoBySummaryParts(String recordSummaryParts) throws Exception;
	public List<ArticleInfo> selectArticleInfoByIsTop(boolean recordIsTop) throws Exception;
	public List<ArticleInfo> selectArticleInfoAll() throws Exception;
	
	public int updateArticleInfo(ArticleInfo recordArticleInfo) throws Exception;
}
