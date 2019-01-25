package com.sxk.refreshshop.utils;

import java.sql.*;

public class DBUtil {
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/refreshshop?characterEncoding=utf-8", "root", "123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
