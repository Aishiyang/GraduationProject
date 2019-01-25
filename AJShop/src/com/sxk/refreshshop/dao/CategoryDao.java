package com.sxk.refreshshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sxk.refreshshop.pojo.Category;
import com.sxk.refreshshop.pojo.CategorySecond;
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
				Set<CategorySecond> list2 = new HashSet<>();
				if(category.getCid() == 1) {
					String sql1 = "select * from categorysecond cs where cs.cid=?";
					PreparedStatement ps1 = conn.prepareStatement(sql1);
					ps1.setInt(1,category.getCid());
					ResultSet rs1 = ps1.executeQuery();
					while(rs1.next()){
						CategorySecond categorySecond = new CategorySecond();
						categorySecond.setCsid(rs1.getInt("csid"));
						categorySecond.setCsname(rs1.getString("csname"));
						list2.add(categorySecond);
					}
					category.setCategorySeconds(list2);
				}
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
	public void save(Category category) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "insert into category(cname) values(?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, category.getCname());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
	public void update(Category category) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "update category set cname=? where cid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,category.getCname());
			ps.setInt(2, category.getCid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
