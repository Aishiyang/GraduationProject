package com.sxk.refreshshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxk.refreshshop.pojo.CategorySecond;
import com.sxk.refreshshop.pojo.Order;
import com.sxk.refreshshop.utils.DBUtil;

public class CategorySecondDao {

	// DAO中的统计二级分类个数的方法
	public int findCount() {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select count(*) from categorySecond";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Long> list = new ArrayList<>();
			if(rs.next()){
				list.get(0).intValue();
			}
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// DAO中分页查询的方法
	public List<CategorySecond> findByPage(int begin, int limit) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from categorySecond order by csid desc limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, limit);
			ResultSet rs = ps.executeQuery();
			List<CategorySecond> list = new ArrayList<CategorySecond>();
			while(rs.next()){
				CategorySecond categorySecond = new CategorySecond();
				categorySecond.setCsid(rs.getInt("csid"));
				categorySecond.setCsname(rs.getString("csname"));
				list.add(categorySecond);
			}
			DBUtil.closeAll(conn, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// DAO中的保存二级分类的方法
	public void save(CategorySecond categorySecond) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "insert into categorySecond values(?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,categorySecond.getCsid());
			ps.setString(2, categorySecond.getCsname());
			int i = ps.executeUpdate();
			DBUtil.closeAll(connection, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DAO中的删除二级分类的方法
	public void delete(CategorySecond categorySecond) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from categorySecond where csid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,categorySecond.getCsid());
			ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DAO中根据id查询二级分类的方法
	public CategorySecond findByCsid(Integer csid) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from categorySecond where csid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,csid);
			ResultSet rs = ps.executeQuery();
			CategorySecond categorySecond = new CategorySecond();
			if(rs.next()){
				categorySecond.setCsid(rs.getInt("csid"));
				categorySecond.setCsname(rs.getString("csname"));
				DBUtil.closeAll(connection, ps, rs);
				return categorySecond;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// DAO中的修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "update categorySecond set csname=? where csid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, categorySecond.getCsname());
			ps.setInt(2, categorySecond.getCsid());
			int i = ps.executeUpdate();
			DBUtil.closeAll(connection, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DAO中的查询所有二级分类的方法
	public List<CategorySecond> findAll() {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from categorySecond";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<CategorySecond> list = new ArrayList<CategorySecond>();
			while(rs.next()){
				CategorySecond categorySecond = new CategorySecond();
				categorySecond.setCsid(rs.getInt("csid"));
				categorySecond.setCsname(rs.getString("csname"));
				list.add(categorySecond);
			}
			DBUtil.closeAll(conn, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
