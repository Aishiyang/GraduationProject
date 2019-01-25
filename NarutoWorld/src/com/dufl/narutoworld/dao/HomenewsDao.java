package com.dufl.narutoworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dufl.narutoworld.common.DBUtil;
import com.dufl.narutoworld.vo.Homenews;

public class HomenewsDao {
	
	public List<Homenews> selectAll(){
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from homenews";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Homenews> list = new ArrayList<>();
			while(rs.next()){
				Homenews homenews = new Homenews();
				homenews.setHomenewsLink(rs.getString("homenewsLink"));
				homenews.setHomenewsPhoto(rs.getString("homenewsPhoto"));
				list.add(homenews);
			}
			DBUtil.closeAll(connection, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
