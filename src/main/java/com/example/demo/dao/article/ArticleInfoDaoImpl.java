package com.example.demo.dao.article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.BaseDao;
import com.example.demo.entity.ArticleInfo;

public class ArticleInfoDaoImpl extends BaseDao implements ArticleInfoDao {

	@Override
	public int insertArticleInfo(ArticleInfo recordArticleInfo) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into article_info (title,summary,is_top,create_time,modified_time,article_id) values(?,?,?,?,?,?)";

		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recordArticleInfo.getTitle());
			stmt.setString(2, recordArticleInfo.getSummary());
			stmt.setBoolean(3, recordArticleInfo.getIsTop());

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			if (recordArticleInfo.getCreateTime() == null) {
				stmt.setTimestamp(4, timestamp);
			} else {
				stmt.setTimestamp(4, recordArticleInfo.getCreateTime());
			}

			if (recordArticleInfo.getModifiedTime() == null) {
				stmt.setTimestamp(5, timestamp);
			} else {
				stmt.setTimestamp(5, recordArticleInfo.getModifiedTime());
			}

			stmt.setInt(6, recordArticleInfo.getArticleId());

			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 插入文章信息错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

	@Override
	public int deleteArticleInfoById(int recordId) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from article_info where id = " + recordId;

		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 删除文章信息错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

	@Override
	public ArticleInfo selectArticleInfoById(int recordId) throws Exception {
		//System.out.println("---------- 查询 id : " + recordId + " 文章信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_info where id = " + recordId;

		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArticleInfo articleInfo = null;
		int i = 0;
		while (rs.next()) {
			articleInfo = new ArticleInfo(rs.getInt("id"), rs.getString("title"), rs.getString("summary"),
					rs.getBoolean("is_top"), rs.getInt("article_id"));
			i++;
			break;
		}

		System.out.println("---------- 查询到 " + i + " 条文章信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return articleInfo;
	}

	@Override
	public ArticleInfo selectArticleInfoByArticleContentId(int recordArticleContentId) throws Exception {
		//System.out.println("---------- 查询 article_id : " + recordArticleContentId + " 文章信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_info where article_id = " + recordArticleContentId;

		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArticleInfo articleInfo = null;
		int i = 0;
		while (rs.next()) {
			articleInfo = new ArticleInfo(rs.getInt("id"), rs.getString("title"), rs.getString("summary"),
					rs.getBoolean("is_top"), rs.getTimestamp("create_time"), rs.getTimestamp("modified_time"),
					rs.getInt("article_id"));
			i++;
			break;
		}

		System.out.println("---------- 查询到 " + i + " 条文章信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return articleInfo;
	}

	@Override
	public List<ArticleInfo> selectArticleInfoByTitle(String recordTitle) throws Exception {
		//System.out.println("---------- 查询 title : " + recordTitle + " 文章信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_info where title like \"%\"?\"%\"";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, recordTitle);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<ArticleInfo> list=new ArrayList<ArticleInfo>();

		while (rs.next()) {
			ArticleInfo articleInfo = new ArticleInfo(rs.getInt("id"), rs.getString("title"), rs.getString("summary"),
					rs.getBoolean("is_top"), rs.getTimestamp("create_time"), rs.getTimestamp("modified_time"),
					rs.getInt("article_id"));
			list.add(articleInfo);
		}

		System.out.println("---------- 查询到 " + list.size() + " 条文章信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public List<ArticleInfo> selectArticleInfoBySummaryParts(String recordSummaryParts) throws Exception {
		//System.out.println("---------- 查询 summary : " + recordSummaryParts + " 文章信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_info where summary like \"%\"?\"%\"";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, recordSummaryParts);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<ArticleInfo> list=new ArrayList<ArticleInfo>();

		while (rs.next()) {
			ArticleInfo articleInfo = new ArticleInfo(rs.getInt("id"), rs.getString("title"), rs.getString("summary"),
					rs.getBoolean("is_top"), rs.getTimestamp("create_time"), rs.getTimestamp("modified_time"),
					rs.getInt("article_id"));
			list.add(articleInfo);
		}

		System.out.println("---------- 查询到 " + list.size() + " 条文章信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public List<ArticleInfo> selectArticleInfoByIsTop(boolean recordIsTop) throws Exception {
		//System.out.println("---------- 查询 is_top : " + recordIsTop + " 文章信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_info where is_top = " + recordIsTop;

		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
		
		ArrayList<ArticleInfo> list=new ArrayList<ArticleInfo>();

		while (rs.next()) {
			ArticleInfo articleInfo = new ArticleInfo(rs.getInt("id"), rs.getString("title"), rs.getString("summary"),
					rs.getBoolean("is_top"), rs.getTimestamp("create_time"), rs.getTimestamp("modified_time"),
					rs.getInt("article_id"));
			list.add(articleInfo);
		}

		System.out.println("---------- 查询到 " + list.size() + " 条文章信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public List<ArticleInfo> selectArticleInfoAll() throws Exception {
		//System.out.println("---------- 查询所有文章信息 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from article_info";

		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
		
		ArrayList<ArticleInfo> list=new ArrayList<ArticleInfo>();

		while (rs.next()) {
			ArticleInfo articleInfo = new ArticleInfo(rs.getInt("id"), rs.getString("title"), rs.getString("summary"),
					rs.getBoolean("is_top"), rs.getTimestamp("create_time"), rs.getTimestamp("modified_time"),
					rs.getInt("article_id"));
			list.add(articleInfo);
		}

		System.out.println("---------- 查询到 " + list.size() + " 条文章信息 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public int updateArticleInfo(ArticleInfo recordArticleInfo) throws Exception {
		Connection conn = BaseDao.getConnection();
		String sql = "update article_info set title = ?, summary = ?, is_top = ?, modified_time = ? where id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,recordArticleInfo.getTitle());
		stmt.setString(2, recordArticleInfo.getSummary());
		stmt.setBoolean(3, recordArticleInfo.getIsTop());
		if(recordArticleInfo.getModifiedTime()==null) {
			stmt.setTimestamp(4, recordArticleInfo.getModifiedTime());
		}else {
			stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		}
		stmt.setInt(5, recordArticleInfo.getId());

		int i=-1;
		try {
			i=stmt.executeUpdate();
		}catch( Exception e){
			e.printStackTrace();
			System.out.println("---------- 修改文章信息错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

}
