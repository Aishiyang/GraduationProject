package com.dufl.narutoworld.common;

import java.sql.*;

public class DBUtil {
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/narutoworld?characterEncoding=utf-8", "root", "123");
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

//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		//�������
//		Connection conn = DBUtil.getConnection();
//		
//		String sql = "select * from usertable";
//		PreparedStatement ps =  conn.prepareStatement(sql);
//		ResultSet rs = ps.executeQuery();
//		
//		while(rs.next()){
//			System.out.println(rs.getString("username")+" ");
//			System.out.println(rs.getString("role")+" ");
//			System.out.println(rs.getString("status")+" ");
//		}
//		
//		//�ر���Դ
//		DBUtil.closeAll(conn, ps, rs);
//	}

}
