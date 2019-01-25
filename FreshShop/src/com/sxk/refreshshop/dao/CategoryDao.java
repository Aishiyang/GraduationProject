package com.sxk.refreshshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxk.refreshshop.pojo.Category;
import com.sxk.refreshshop.utils.DBUtil;

public class CategoryDao{

	//DAO层的查询所有一级分类的方法
	public List<Category> findAll() {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Category> list = new ArrayList<Category>();
			while(rs.next()){
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCname(rs.getString("cname"));
				list.add(category);				
			}
			DBUtil.closeAll(conn, ps, null);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Dao中的保存一级分类的方法
//	public void save(Category category) {
//		this.getHibernateTemplate().save(category);
//	}

	// Dao中根据一级分类id查询一级分类
	public Category findByCid(Integer cid) {
		Connection connection = DBUtil.getConnection();
		try {
			
			String sql = "select * from category where cid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,cid);
			ResultSet rs = ps.executeQuery();
			Category category = new Category();
			if(rs.next()){
				category.setCid(rs.getInt("cid"));
				category.setCname(rs.getString("cname"));
				DBUtil.closeAll(connection, ps, rs);
				return category;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// DAO中删除一级分类
	public void delete(Category category) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from category where cid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,category.getCid());
			ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Dao中修改一级分类
//	public void update(Category category) {
//		this.getHibernateTemplate().update(category);
//	}
	
}
