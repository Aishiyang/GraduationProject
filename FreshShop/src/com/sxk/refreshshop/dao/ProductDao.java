package com.sxk.refreshshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxk.refreshshop.pojo.Category;
import com.sxk.refreshshop.pojo.Product;
import com.sxk.refreshshop.utils.DBUtil;

public class ProductDao {

	// 首页上热门商品查询
	public List<Product> findHot() {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from product where is_hot = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while(rs.next()){
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setMarket_price(rs.getDouble("market_price"));
				product.setShop_price(rs.getDouble("shop_price"));
				product.setImage(rs.getString("image"));
				product.setPdesc(rs.getString("pdesc"));
				product.setIs_hot(rs.getInt("is_hot"));
				product.setPdate(rs.getDate("pdate"));
				list.add(product);				
			}
			DBUtil.closeAll(conn, ps, null);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 首页上最新商品的查询
	public List<Product> findNew() {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from product order by pdate desc limit 10";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while(rs.next()){
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setMarket_price(rs.getDouble("market_price"));
				product.setShop_price(rs.getDouble("shop_price"));
				product.setImage(rs.getString("image"));
				product.setPdesc(rs.getString("pdesc"));
				product.setIs_hot(rs.getInt("is_hot"));
				product.setPdate(rs.getDate("pdate"));
				list.add(product);				
			}
			DBUtil.closeAll(conn, ps, null);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 根据商品ID查询商品
	public Product findByPid(Integer pid) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from product where pid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,pid);
			ResultSet rs = ps.executeQuery();
			Product product = new Product();
			if(rs.next()){
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setMarket_price(rs.getDouble("market_price"));
				product.setShop_price(rs.getDouble("shop_price"));
				product.setImage(rs.getString("image"));
				product.setPdesc(rs.getString("pdesc"));
				product.setIs_hot(rs.getInt("is_hot"));
				product.setPdate(rs.getDate("pdate"));
				DBUtil.closeAll(connection, ps, rs);
				return product;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 根据分类id查询商品的个数
	public int findCountCid(Integer cid) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,cid);
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

	// 根据分类id查询商品的集合
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ? limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, begin);
			ps.setInt(3, limit);
			ResultSet rs = ps.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while(rs.next()){
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setMarket_price(rs.getDouble("market_price"));
				product.setShop_price(rs.getDouble("shop_price"));
				product.setImage(rs.getString("image"));
				product.setPdesc(rs.getString("pdesc"));
				product.setIs_hot(rs.getInt("is_hot"));
				product.setPdate(rs.getDate("pdate"));
				list.add(product);				
			}
			DBUtil.closeAll(conn, ps, null);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
//
//	// 根据二级分类查询商品个数
//	public int findCountCsid(Integer csid) {
//		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
//		List<Long> list = this.getHibernateTemplate().find(hql, csid);
//		if(list != null && list.size() > 0){
//			return list.get(0).intValue();
//		}
//		return 0;
//	}
//
//	// 根据二级分类查询商品信息
//	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
//		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
//		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
//		if(list != null && list.size() > 0){
//			return list;
//		}
//		return null;
//	}

	// 后台统计商品个数的方法
	public int findCount() {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select count(*) from product";
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

	// 后台查询所有商品的方法
	public List<Product> findByPage(int begin, int limit) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from product order by pdate desc limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, limit);
			ResultSet rs = ps.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while(rs.next()){
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setMarket_price(rs.getDouble("market_price"));
				product.setShop_price(rs.getDouble("shop_price"));
				product.setImage(rs.getString("image"));
				product.setPdesc(rs.getString("pdesc"));
				product.setIs_hot(rs.getInt("is_hot"));
				product.setPdate(rs.getDate("pdate"));
				list.add(product);				
			}
			DBUtil.closeAll(conn, ps, null);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	// DAO中的保存商品的方法
//	public void save(Product product) {
//		this.getHibernateTemplate().save(product);
//	}

	// DAO中的删除商品的方法
	public void delete(Product product) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from product where pid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,product.getPid());
			ps.executeUpdate();
			DBUtil.closeAll(conn, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public void update(Product product) {
//		this.getHibernateTemplate().update(product);
//	}

}
