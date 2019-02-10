package com.example.demo.dao.article;

import java.util.List;

import com.example.demo.entity.ArticleInfo;

public interface ArticleInfoDao {
	/* 插入 */
	public int insertArticleInfo(ArticleInfo recordArticleInfo) throws Exception;
	
	/* 删除 */
	public int deleteArticleInfoById(int recordId) throws Exception;
	
	/* 查找 */
	public ArticleInfo selectArticleInfoById(int recordId) throws Exception;
	public ArticleInfo selectArticleInfoByArticleContentId(int recordArticleContentId) throws Exception;
	public List<ArticleInfo> selectArticleInfoByTitle(String recordTitle) throws Exception;
	public List<ArticleInfo> selectArticleInfoBySummaryParts(String recordSummaryParts) throws Exception;
	public List<ArticleInfo> selectArticleInfoByIsTop(boolean recordIsTop) throws Exception;
	//根据修改时间排序 返回所有文章信息
	public List<ArticleInfo> selectArticleInfoAll() throws Exception;
	
	/* 修改 */
	public int updateArticleInfo(ArticleInfo recordArticleInfo) throws Exception;
}
