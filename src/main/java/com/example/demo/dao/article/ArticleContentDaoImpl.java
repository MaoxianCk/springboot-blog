package com.example.demo.dao.article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.BaseDao;
import com.example.demo.entity.ArticleContent;

public class ArticleContentDaoImpl extends BaseDao implements ArticleContentDao {

	@Override
	public int insertArticleContent(ArticleContent recordArticleContent) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into article_content (content,create_time,modified_time,article_info_id) values(?,?,?,?)";

		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recordArticleContent.getContent());
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			if (recordArticleContent.getCreateTime() == null) {
				stmt.setTimestamp(2, timestamp);
			} else {
				stmt.setTimestamp(2, recordArticleContent.getCreateTime());
			}
			
			if (recordArticleContent.getModifiedTime() == null) {
				stmt.setTimestamp(3, timestamp);
			} else {
				stmt.setTimestamp(3, recordArticleContent.getModifiedTime());
			}
			
			stmt.setInt(4, recordArticleContent.getArticleInfoId());
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 插入文章内容错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

	@Override
	public int deleteArticleContentById(int recordId) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from article_content where id = ?";

		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, recordId);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 删除文章内容错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}
	
	@Override
	public int deleteArticleContentByArticleInfoId(int recordArticleInfoId) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from article_content where article_info_id = ?";

		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, recordArticleInfoId);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 删除文章内容错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

	@Override
	public ArticleContent selectArticleContentById(int recordId) throws Exception {
		System.out.println("---------- 查询 id : " + recordId + " 文章内容 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_content where id = " + recordId;

		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArticleContent articleContent = null;
		int i = 0;
		while (rs.next()) {
			articleContent = new ArticleContent(rs.getInt("id"), rs.getString("content"),
					rs.getTimestamp("create_time"), rs.getTimestamp("modified_time"), rs.getInt("article_info_id"));
			i++;
			break;
		}

		System.out.println("---------- 查询到 " + i + " 条文章内容 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return articleContent;
	}

	@Override
	public ArticleContent selectArticleContentByArticleInfoId(int recordArticleInfoId) throws Exception {
		System.out.println("---------- 查询 article_info_id : " + recordArticleInfoId + " 文章内容 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_content where article_info_id = " + recordArticleInfoId;

		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArticleContent articleContent = null;
		int i = 0;
		while (rs.next()) {
			articleContent = new ArticleContent(rs.getInt("id"), rs.getString("content"),
					rs.getTimestamp("create_time"), rs.getTimestamp("modified_time"), rs.getInt("article_info_id"));
			i++;
			break;
		}

		System.out.println("---------- 查询到 " + i + " 条文章内容 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return articleContent;
	}

	@Override
	public List<ArticleContent> selectArticleContentByContentParts(String recordContentParts) throws Exception {
		System.out.println("---------- 查询 content_parts : " + recordContentParts + " 文章内容 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_content where content like \"%\"?\"%\"";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, recordContentParts);
		ResultSet rs = stmt.executeQuery();

		ArrayList<ArticleContent> list = new ArrayList<ArticleContent>();
		while (rs.next()) {
			ArticleContent articleContent = new ArticleContent(rs.getInt("id"), rs.getString("content"),
					rs.getTimestamp("create_time"), rs.getTimestamp("modified_time"), rs.getInt("article_info_id"));
			list.add(articleContent);
		}

		System.out.println("---------- 查询到 " + list.size() + " 条文章内容 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public List<ArticleContent> selectArticleContentAll() throws Exception {
		System.out.println("---------- 查询所有文章内容 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_content";

		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<ArticleContent> list = new ArrayList<ArticleContent>();
		while (rs.next()) {
			ArticleContent articleContent = new ArticleContent(rs.getInt("id"), rs.getString("content"),
					rs.getTimestamp("create_time"), rs.getTimestamp("modified_time"), rs.getInt("article_info_id"));
			list.add(articleContent);
		}

		System.out.println("---------- 查询到 " + list.size() + " 条文章内容 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public int updateArticleContent(ArticleContent recordArticleContent) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "update article_content set content = ? , modified_time = ?  where id = ?";
		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recordArticleContent.getContent());
			
			if (recordArticleContent.getModifiedTime() == null) {
				stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			} else {
				stmt.setTimestamp(2, recordArticleContent.getModifiedTime());
			}
			
			stmt.setInt(3, recordArticleContent.getId());
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 修改文章内容错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

}
