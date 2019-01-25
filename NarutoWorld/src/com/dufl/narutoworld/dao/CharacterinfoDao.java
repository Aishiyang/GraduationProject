package com.dufl.narutoworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dufl.narutoworld.common.DBUtil;
import com.dufl.narutoworld.vo.Characterinfo;

public class CharacterinfoDao {
	
	public int deleteCharacterInfoById(String characterInfoId){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from characterinfo where characterinfoid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(characterInfoId));
			int i = ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int UpdateCharacterInfoById(Characterinfo characterinfo){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "update characterinfo set characterinfoNum = ?,characterinfoName = ?,characterinfoDesc = ? where characterinfoid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,characterinfo.getCharacterinfoNum());
			ps.setString(2,characterinfo.getCharacterinfoName());
			ps.setString(3,characterinfo.getCharacterinfoDesc());
			ps.setInt(4,characterinfo.getCharacterinfoId());
			int i = ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int activeCharacterInfoById(Characterinfo characterinfo){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "update characterinfo set characterinfoActivated = ? where characterinfoid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			int temp = -1;
			if(characterinfo.getCharacterinfoActivated() == 1) {
				temp = 0;
			}else {
				temp = 1;
			}
			ps.setInt(1,temp);
			ps.setInt(2,characterinfo.getCharacterinfoId());
			int i = ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Characterinfo> selectAll(){
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from characterinfo";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Characterinfo> list = new ArrayList<Characterinfo>();
			while(rs.next()){
				Characterinfo characterinfo = new Characterinfo();
				characterinfo.setCharacterinfoId(rs.getInt("characterinfoId"));
				characterinfo.setCharacterinfoNum(rs.getString("characterinfoNum"));
				characterinfo.setCharacterinfoName(rs.getString("characterinfoName"));
				characterinfo.setCharacterinfoDesc(rs.getString("characterinfoDesc"));
				characterinfo.setCharacterinfoActivated(rs.getInt("characterinfoActivated"));
				list.add(characterinfo);				
			}
			DBUtil.closeAll(connection, ps, null);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Characterinfo> selectAllByCondition(){
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from characterinfo where characterinfoActivated = 1";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Characterinfo> list = new ArrayList<Characterinfo>();
			while(rs.next()){
				Characterinfo characterinfo = new Characterinfo();
				characterinfo.setCharacterinfoId(rs.getInt("characterinfoId"));
				characterinfo.setCharacterinfoNum(rs.getString("characterinfoNum"));
				characterinfo.setCharacterinfoName(rs.getString("characterinfoName"));
				characterinfo.setCharacterinfoDesc(rs.getString("characterinfoDesc"));
				characterinfo.setCharacterinfoActivated(rs.getInt("characterinfoActivated"));
				list.add(characterinfo);				
			}
			DBUtil.closeAll(connection, ps, null);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
