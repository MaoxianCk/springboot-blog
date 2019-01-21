package com.example.demo.dao.article;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.ArticleInfo;

public interface ArticleInfoDao {
	public boolean insertArticleInfo(ArticleInfo recordArticleInfo);
	
	public boolean deleteArticleInfoById(int recordId);
	
	public ArticleInfo selectArticleInfoById(int recordId);
	public ArticleInfo selectArticleInfoByArticleContentId(int recordArticleContentId);
	public ArticleInfo selectArticleInfoByCommentId(int recordCommentId); 
	public List<ArticleInfo> selectArticleInfoByTitle(String recordTitle);
	public List<ArticleInfo> selectArticleInfoBySummaryParts(String recordSummaryParts);//文章简介片段匹配
	public List<ArticleInfo> selectArticleInfoByIsTop(boolean recordIsTop);
	public List<ArticleInfo> selectArticleInfoByCreateTime(Date recordCreateTime);
	public List<ArticleInfo> selectArticleInfoByModifiedTime(Date recordModifiedTime);
	
	public boolean updateArticleInfo(ArticleInfo recordArticleInfo);
}
