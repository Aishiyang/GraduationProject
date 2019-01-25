package com.dufl.narutoworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dufl.narutoworld.common.DBUtil;
import com.dufl.narutoworld.vo.News;

public class NewsDao {
	
	public List<News> selectAll(){
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from news where newsUpdate = 1";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<News> list = new ArrayList<>();
			while(rs.next()){
				News news = new News();
				news.setNewsId(rs.getInt("newsId"));
				news.setNewsDesc(rs.getString("newsDesc"));
				news.setNewsLink(rs.getString("newsLink"));
				news.setNewsDate(rs.getString("newsDate"));
				news.setNewsUpdate(rs.getString("newsUpdate"));
				list.add(news);
			}
			DBUtil.closeAll(connection, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<News> selectByAdminAll(){
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from news";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<News> list = new ArrayList<>();
			while(rs.next()){
				News news = new News();
				news.setNewsId(rs.getInt("newsId"));
				news.setNewsDesc(rs.getString("newsDesc"));
				news.setNewsLink(rs.getString("newsLink"));
				news.setNewsDate(rs.getString("newsDate"));
				news.setNewsUpdate(rs.getString("newsUpdate"));
				list.add(news);
			}
			DBUtil.closeAll(connection, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int deleteNewsById(String newsId){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from news where newsid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(newsId));
			int i = ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int UpdateNewsById(News news){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "update news set newsDesc = ?,newsLink = ? where newsId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,news.getNewsDesc());
			ps.setString(2,news.getNewsLink());
			ps.setInt(3,news.getNewsId());
			int i = ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int activeNewsById(News news){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "update news set newsupdate = ? where newsid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			String temp = null;
			if("1".equals(news.getNewsUpdate())) {
				temp = "0";
			}else {
				temp = "1";
			}
			ps.setString(1,temp);
			ps.setInt(2,news.getNewsId());
			int i = ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
