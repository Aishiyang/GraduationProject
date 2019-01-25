package com.dufl.narutoworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dufl.narutoworld.common.DBUtil;
import com.dufl.narutoworld.vo.User;
import com.sun.org.apache.regexp.internal.recompile;

public class UserDao {

	public int insertUser(User user){
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "insert into user(username,password,sex,level,country,registdate) values(?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getLevel());
			ps.setString(5, user.getCountry());
			ps.setString(6, user.getRegistdate());
			int i = ps.executeUpdate();
			DBUtil.closeAll(connection, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public User selectByUsername(String username){
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from user where username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			
			User user = new User();
			if(rs.next()){
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setLevel(rs.getString("level"));
				user.setCountry(rs.getString("country"));
				user.setSex(rs.getString("sex"));
				user.setRegistdate(rs.getString("registdate"));
				DBUtil.closeAll(connection, ps, rs);
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> selectAll(){
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from user";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()){
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setLevel(rs.getString("level"));
				user.setCountry(rs.getString("country"));
				user.setSex(rs.getString("sex"));
				user.setRegistdate(rs.getString("registdate"));
				list.add(user);				
			}
			DBUtil.closeAll(connection, ps, null);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int deleteUserById(String userid){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from user where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(userid));
			int i = ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
