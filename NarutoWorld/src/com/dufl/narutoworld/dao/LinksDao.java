package com.dufl.narutoworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dufl.narutoworld.common.DBUtil;
import com.dufl.narutoworld.vo.Links;

public class LinksDao {

	public List<Links> selectAll(){
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from links where linksUpdate = 1";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Links> list = new ArrayList<>();
			while(rs.next()){
				Links links = new Links();
				links.setLinksId(rs.getInt("linksId"));
				links.setLinksDesc(rs.getString("linksDesc"));
				links.setLinksLink(rs.getString("linksLink"));
				links.setLinksDate(rs.getString("linksDate"));
				links.setLinksUpdate(rs.getString("linksUpdate"));
				list.add(links);
			}
			DBUtil.closeAll(connection, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Links> selectByAdminAll(){
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from links";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Links> list = new ArrayList<>();
			while(rs.next()){
				Links links = new Links();
				links.setLinksId(rs.getInt("linksId"));
				links.setLinksDesc(rs.getString("linksDesc"));
				links.setLinksLink(rs.getString("linksLink"));
				links.setLinksDate(rs.getString("linksDate"));
				links.setLinksUpdate(rs.getString("linksUpdate"));
				list.add(links);
			}
			DBUtil.closeAll(connection, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int deleteLinksById(String linksId){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from links where linksId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(linksId));
			int i = ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int UpdateLinksById(Links links){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "update links set linksDesc = ?,linksLink = ? where linksId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,links.getLinksDesc());
			ps.setString(2,links.getLinksLink());
			ps.setInt(3,links.getLinksId());
			int i = ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int activeLinksById(Links links){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "update links set linksUpdate = ? where linksId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			String temp = null;
			if("1".equals(links.getLinksUpdate())) {
				temp = "0";
			}else {
				temp = "1";
			}
			ps.setString(1,temp);
			ps.setInt(2,links.getLinksId());
			int i = ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
