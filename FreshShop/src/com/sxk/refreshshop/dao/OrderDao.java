package com.sxk.refreshshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxk.refreshshop.pojo.Order;
import com.sxk.refreshshop.pojo.OrderItem;
import com.sxk.refreshshop.utils.DBUtil;

public class OrderDao {

	// Dao层的保存订单额操作
	public void save(Order order) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "insert into order values(?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,order.getOid());
			ps.setDouble(2, order.getTotal());
			ps.setDate(3, order.getOrdertime());
			ps.setInt(4, order.getState());
			ps.setString(5, order.getName());
			ps.setString(6, order.getPhone());
			ps.setString(7, order.getAddr());
			int i = ps.executeUpdate();
			DBUtil.closeAll(connection, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Dao层查询我的订单分页查询:统计个数
	public int findCountByUid(Integer uid) {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select count(*) from order where uid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, uid);
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

	// Dao层查询我的订单分页查询:查询数据
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from order o where o.user.uid = ? order by o.ordertime desc limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, begin);
			ps.setInt(3, limit);
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
				order.setTotal(rs.getDouble("totle"));
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
			String sql = "select * from order where oid = ?";
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
				order.setTotal(rs.getDouble("totle"));
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
			String sql = "update order set total=?,ordertime=?,state=?,name=?,phone=?,addr=? where oid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, currOrder.getTotal());
			ps.setDate(2, currOrder.getOrdertime());
			ps.setInt(3, currOrder.getState());
			ps.setString(4, currOrder.getName());
			ps.setString(5, currOrder.getPhone());
			ps.setString(6, currOrder.getAddr());
			ps.setInt(7,currOrder.getOid());
			int i = ps.executeUpdate();
			DBUtil.closeAll(connection, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DAO中统计订单个数的方法
	public int findCount() {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "select count(*) from order";
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

	// DAO中分页查询订单的方法
	public List<Order> findByPage(int begin, int limit) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from order o order by o.ordertime desc limit ?,?";
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
				order.setTotal(rs.getDouble("totle"));
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
	public List<OrderItem> findOrderItem(Integer oid) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from orderItem oi where oi.order.oid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			ResultSet rs = ps.executeQuery();
			List<OrderItem> list = new ArrayList<OrderItem>();
			while(rs.next()){
				OrderItem orderItem = new OrderItem();
				orderItem.setItemid(rs.getInt("itemid"));
				orderItem.setCount(rs.getInt("count"));
				orderItem.setSubtotal(rs.getDouble("subtotal"));
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
