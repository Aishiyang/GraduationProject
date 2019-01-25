package com.sxk.refreshshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxk.refreshshop.pojo.User;
import com.sxk.refreshshop.utils.DBUtil;

public class UserDao {

	// 按名次查询是否有该用户:
	public User findByUsername(String username) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from user where username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			if(rs.next()){
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setAddr(rs.getString("addr"));
				user.setState(rs.getInt("state"));
				user.setCode(rs.getString("code"));
				DBUtil.closeAll(connection, ps, rs);
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 注册用户存入数据库代码实现
	public void save(User user) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "insert into user(username,password,name,email,phone,addr,state,code) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAddr());
			ps.setInt(7, user.getState());
			ps.setString(8, user.getCode());
			ps.executeUpdate();
			DBUtil.closeAll(connection, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	// 用户登录的方法
	public User login(User user) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from user where username = ? and password = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ResultSet rs = ps.executeQuery();
			User user1 = new User();
			if(rs.next()){
				user1.setUid(rs.getInt("uid"));
				user1.setUsername(rs.getString("username"));
				user1.setPassword(rs.getString("password"));
				user1.setName(rs.getString("name"));
				user1.setEmail(rs.getString("email"));
				user1.setPhone(rs.getString("phone"));
				user1.setAddr(rs.getString("addr"));
				user1.setState(rs.getInt("state"));
				user1.setCode(rs.getString("code"));
				DBUtil.closeAll(connection, ps, rs);
				return user1;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int findCount() {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select count(*) as countUser from user";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Long> list = new ArrayList<>();
			while(rs.next()){
				Long long1 = (long) rs.getInt("countUser");
				list.add(long1);
			}
			return list.get(0).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<User> findByPage(int begin, int limit) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from user limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, limit);
			ResultSet rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()){
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setAddr(rs.getString("addr"));
				user.setState(rs.getInt("state"));
				user.setCode(rs.getString("code"));
				list.add(user);
			}
			DBUtil.closeAll(conn, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findByUid(Integer uid) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from user where uid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,uid);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			if(rs.next()){
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setAddr(rs.getString("addr"));
				user.setState(rs.getInt("state"));
				user.setCode(rs.getString("code"));
				DBUtil.closeAll(connection, ps, rs);
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(User existUser) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from user where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,existUser.getUid());
			ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
