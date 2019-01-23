package com.example.demo.dao.article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.BaseDao;
import com.example.demo.entity.ArticleComment;

public class ArticleCommentDaoImpl extends BaseDao implements ArticleCommentDao {

	@Override
	public int insertArticleComment(ArticleComment recordArticleComment) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into article_comment(content,create_time,name,is_effective,article_info_id) values(?,?,?,?,?)";
		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recordArticleComment.getContent());
			stmt.setTimestamp(2, recordArticleComment.getCreateTime());
			stmt.setString(3, recordArticleComment.getName());
			stmt.setBoolean(4, recordArticleComment.getIsEffective());
			stmt.setInt(5, recordArticleComment.getArticleInfoId());
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 插入文章评论错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

	@Override
	public int deleteArticleCommentById(int recordId) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from article_comment where id = ?";
		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, recordId);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 删除文章评论错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

	@Override
	public ArticleComment selectArticleCommentById(int recordId) throws Exception {
		System.out.println("---------- 查询 id : " + recordId + " 文章评论信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_comment where id = " + recordId;
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArticleComment articleComment = null;
		int i = 0;
		while (rs.next()) {
			articleComment = new ArticleComment(rs.getInt("id"), rs.getString("content"),
					rs.getTimestamp("create_time"), rs.getString("name"), rs.getBoolean("is_effective"),
					rs.getInt("article_info_id"));
			i++;
		}

		System.out.println("---------- 查询到 " + i + " 条文章评论信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return articleComment;
	}

	@Override
	public ArticleComment selectArticleCommentByArticleInfoId(int recordArticleInfoId) throws Exception {
		System.out.println("---------- 查询 article_info_id : " + recordArticleInfoId + " 文章评论信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_comment where article_info_id = " + recordArticleInfoId;
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArticleComment articleComment = null;
		int i = 0;
		while (rs.next()) {
			articleComment = new ArticleComment(rs.getInt("id"), rs.getString("content"),
					rs.getTimestamp("create_time"), rs.getString("name"), rs.getBoolean("is_effective"),
					rs.getInt("article_info_id"));
			i++;
		}

		System.out.println("---------- 查询到 " + i + " 条文章评论信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return articleComment;
	}

	@Override
	public List<ArticleComment> selectArticleCommentByContentParts(String recordContentParts) throws Exception {
		System.out.println("---------- 查询 文本包含 : " + recordContentParts + " 文章评论信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_comment where find_in_set(" + recordContentParts + ",content)";
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<ArticleComment> list = new ArrayList<ArticleComment>();
		while (rs.next()) {
			ArticleComment articleComment = new ArticleComment(rs.getInt("id"), rs.getString("content"),
					rs.getTimestamp("create_time"), rs.getString("name"), rs.getBoolean("is_effective"),
					rs.getInt("article_info_id"));
			list.add(articleComment);
		}
		System.out.println("---------- 查询到 " + list.size() + " 条文章评论信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public List<ArticleComment> selectArticleCommentByName(String recordName) throws Exception {
		System.out.println("---------- 查询 name : " + recordName + " 文章评论信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_comment where name = " + recordName;
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<ArticleComment> list = new ArrayList<ArticleComment>();
		while (rs.next()) {
			ArticleComment articleComment = new ArticleComment(rs.getInt("id"), rs.getString("content"),
					rs.getTimestamp("create_time"), rs.getString("name"), rs.getBoolean("is_effective"),
					rs.getInt("article_info_id"));
			list.add(articleComment);
		}
		System.out.println("---------- 查询到 " + list.size() + " 条文章评论信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public List<ArticleComment> selectArticleCommentByIsEffective(boolean recordIsEffective) throws Exception {
		System.out.println("---------- 查询 isEffctive : " + recordIsEffective + " 文章评论信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_comment where is_effective = " + recordIsEffective;
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<ArticleComment> list = new ArrayList<ArticleComment>();
		while (rs.next()) {
			ArticleComment articleComment = new ArticleComment(rs.getInt("id"), rs.getString("content"),
					rs.getTimestamp("create_time"), rs.getString("name"), rs.getBoolean("is_effective"),
					rs.getInt("article_info_id"));
			list.add(articleComment);
		}
		System.out.println("---------- 查询到 " + list.size() + " 条文章评论信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public List<ArticleComment> selectArticleCommentAll() throws Exception {
		System.out.println("---------- 查询所有文章评论信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_comment";
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<ArticleComment> list = new ArrayList<ArticleComment>();
		while (rs.next()) {
			ArticleComment articleComment = new ArticleComment(rs.getInt("id"), rs.getString("content"),
					rs.getTimestamp("create_time"), rs.getString("name"), rs.getBoolean("is_effective"),
					rs.getInt("article_info_id"));
			list.add(articleComment);
		}
		System.out.println("---------- 查询到 " + list.size() + " 条文章评论信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public int updateArticleComment(ArticleComment recordArticleComment) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "update article_comment set is_effective = ? where id = ?";
		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1, recordArticleComment.getIsEffective());
			stmt.setInt(2, recordArticleComment.getId());
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 修改文章评论错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}
}
