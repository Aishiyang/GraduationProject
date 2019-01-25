package com.sxk.refreshshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sxk.refreshshop.pojo.AdminUser;
import com.sxk.refreshshop.pojo.User;
import com.sxk.refreshshop.utils.DBUtil;


public class AdminUserDao {

	// Dao完成登录的代码
	public AdminUser login(AdminUser adminUser) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from adminUser where username = ? and password = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,adminUser.getUsername());
			ps.setString(2,adminUser.getPassword());
			ResultSet rs = ps.executeQuery();
			AdminUser adminUser1 = new AdminUser();
			if(rs.next()){
				adminUser.setUid(rs.getInt("uid"));
				adminUser.setUsername(rs.getString("username"));
				adminUser.setPassword(rs.getString("password"));
				DBUtil.closeAll(connection, ps, rs);
				return adminUser;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
