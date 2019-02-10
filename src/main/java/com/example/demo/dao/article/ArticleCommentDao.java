package com.example.demo.dao.article;

import java.util.List;

import com.example.demo.entity.ArticleComment;

/**
 * 文章评论Dao接口
 * 
 * @author:Maoxian
 */
public interface ArticleCommentDao {
	/* 插入 */
	// 插入文章评论
	public int insertArticleComment(ArticleComment recordArticleComment) throws Exception;
	
	
	/* 删除 */
	//根据文章评论id号删除评论
	public int deleteArticleCommentById(int recordId) throws Exception;
	//根据文章评论对应的文章信息表id号删除评论
	public int deleteArticleCommentByArticleInfoId(int recordArticleInfoId) throws Exception;
	
	
	/* 查找 */
	//根据文章评论id号查找文章评论
	public ArticleComment selectArticleCommentById(int recordId) throws Exception;
	//根据文章信息id号查找所有匹配的评论 (文章与评论为 一对多 关系)
	public List<ArticleComment> selectArticleCommentByArticleInfoId(int recordArticleInfoId) throws Exception;
	//根据文章评论文本片段模糊查找匹配的评论
	public List<ArticleComment> selectArticleCommentByContentParts(String recordContentParts) throws Exception;
	//根据文章评论者昵称模糊查找匹配的评论
	public List<ArticleComment> selectArticleCommentByName(String recordName) throws Exception;
	//根据文章评论的有效性查找评论
	public List<ArticleComment> selectArticleCommentByIsEffective(boolean recordIsEffective) throws Exception;
	//根据创建时间顺序 返回所有的文章评论
	public List<ArticleComment> selectArticleCommentAll() throws Exception;
	

	/* 修改 */
	//根据新的文章评论对象进行更新
	public int updateArticleComment(ArticleComment recordArticleComment) throws Exception;
}
