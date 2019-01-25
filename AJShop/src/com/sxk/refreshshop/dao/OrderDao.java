package com.sxk.refreshshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sxk.refreshshop.pojo.Order;
import com.sxk.refreshshop.pojo.OrderItem;
import com.sxk.refreshshop.pojo.Product;
import com.sxk.refreshshop.utils.DBUtil;

public class OrderDao {

	private ProductDao productDao = new ProductDao();
	
	// Dao层的保存订单额操作
	public int save(Order order,int uid) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "insert into orders(total,ordertime,state,name,phone,addr,uid) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, order.getTotal());
			ps.setDate(2, order.getOrdertime());
			ps.setInt(3, order.getState());
			ps.setString(4, order.getName());
			ps.setString(5, order.getPhone());
			ps.setString(6, order.getAddr());
			ps.setInt(7, uid);
			ps.executeUpdate();
			
			int autoIncKeyFromFunc = -1;
		    ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
		    if (rs.next()) {
		        autoIncKeyFromFunc = rs.getInt(1);
		    }
		    Set<OrderItem> listItems = order.getOrderItems();
		    List<OrderItem> result = new ArrayList<>(listItems);
		    String sql1= "insert into orderitem(count,subtotal,pid,oid) values(?,?,?,?)";
		    PreparedStatement ps1 = connection.prepareStatement(sql1);
		    for(int i = 0; i <= result.size() - 1; i++) {
			    ps1.setInt(1, result.get(i).getCount());
			    ps1.setDouble(2, result.get(i).getSubtotal());
			    ps1.setInt(3, result.get(i).getProduct().getPid());
			    ps1.setInt(4, autoIncKeyFromFunc);
			    ps1.executeUpdate();
		    }
			DBUtil.closeAll(connection, ps, null);
			return autoIncKeyFromFunc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Dao层查询我的订单分页查询:统计个数
	public int findCountByUid(Integer uid) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select count(*) as countOrder from orders where uid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			List<Long> list = new ArrayList<>();
			while(rs.next()){
				Long long1 = (long) rs.getInt("countOrder");
				list.add(long1);
			}
			return list.get(0).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Dao层查询我的订单分页查询:查询数据
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from orders o where o.uid = ? order by o.ordertime desc limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, begin);
			ps.setInt(3, limit);
			ResultSet rs = ps.executeQuery();
			List<Order> list = new ArrayList<Order>();
			while(rs.next()){
				Order order = new Order();
//				List<OrderItem> findOrderItem = findOrderItem(rs.getInt("oid"));
//				List staffsList = Arrays.asList(findOrderItem);
//				Set result = new HashSet(staffsList);
				Set<OrderItem> findOrderItem = findOrderItem(rs.getInt("oid"));
				order.setOid(rs.getInt("oid"));
				order.setAddr(rs.getString("addr"));
				order.setName(rs.getString("name"));
				order.setOrdertime(rs.getDate("ordertime"));
				order.setPhone(rs.getString("phone"));
				order.setState(rs.getInt("state"));
				order.setTotal(rs.getDouble("total"));
				order.setOrderItems(findOrderItem);
				list.add(order);
			}
			DBUtil.closeAll(conn, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// DAO层根据订单id查询订单
	public Order findByOid(Integer oid) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select * from orders where oid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,oid);
			ResultSet rs = ps.executeQuery();
			Order order = new Order();
			if(rs.next()){
				order.setOid(rs.getInt("oid"));
				order.setAddr(rs.getString("addr"));
				order.setName(rs.getString("name"));
				order.setOrdertime(rs.getDate("ordertime"));
				order.setPhone(rs.getString("phone"));
				order.setState(rs.getInt("state"));
				order.setTotal(rs.getDouble("total"));
				DBUtil.closeAll(connection, ps, rs);
				return order;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// DAO层修改订单的方法:
	public void update(Order currOrder) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "update orders set total=?,ordertime=?,state=?,name=?,phone=?,addr=? where oid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, currOrder.getTotal());
			ps.setDate(2, currOrder.getOrdertime());
			ps.setInt(3, currOrder.getState());
			ps.setString(4, currOrder.getName());
			ps.setString(5, currOrder.getPhone());
			ps.setString(6, currOrder.getAddr());
			ps.setInt(7,currOrder.getOid());
			ps.executeUpdate();
			DBUtil.closeAll(connection, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DAO中统计订单个数的方法
	public int findCount() {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select count(*) as countOrder from orders";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Long> list = new ArrayList<>();
			while(rs.next()){
				Long long1 = (long) rs.getInt("countOrder");
				list.add(long1);
			}
			return list.get(0).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// DAO中分页查询订单的方法
	public List<Order> findByPage(int begin, int limit) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from orders o order by o.ordertime desc limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, limit);
			ResultSet rs = ps.executeQuery();
			List<Order> list = new ArrayList<Order>();
			while(rs.next()){
				Order order = new Order();
				order.setOid(rs.getInt("oid"));
				order.setAddr(rs.getString("addr"));
				order.setName(rs.getString("name"));
				order.setOrdertime(rs.getDate("ordertime"));
				order.setPhone(rs.getString("phone"));
				order.setState(rs.getInt("state"));
				order.setTotal(rs.getDouble("total"));
				list.add(order);
			}
			DBUtil.closeAll(conn, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// DAo中根据订单id查询订单项
	public Set<OrderItem> findOrderItem(Integer oid) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select oi.* from orderItem oi,orders o where oi.oid=o.oid and oi.oid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			ResultSet rs = ps.executeQuery();
			Set<OrderItem> list = new HashSet<OrderItem>();
			while(rs.next()){
				OrderItem orderItem = new OrderItem();
				Product product = productDao.findByPid(rs.getInt("pid"));
				orderItem.setItemid(rs.getInt("itemid"));
				orderItem.setCount(rs.getInt("count"));
				orderItem.setSubtotal(rs.getDouble("subtotal"));
				orderItem.setProduct(product);
				list.add(orderItem);
			}
			DBUtil.closeAll(conn, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
