package com.sxk.refreshshop.service;

import java.util.List;
import java.util.Set;

import com.sxk.refreshshop.dao.OrderDao;
import com.sxk.refreshshop.pojo.Order;
import com.sxk.refreshshop.pojo.OrderItem;
import com.sxk.refreshshop.utils.PageBean;

public class OrderService {
	private OrderDao orderDao = new OrderDao();

	// 业务层保存订单的方法
	public int save(Order order, int uid) {
		return orderDao.save(order, uid);
	}

	// 业务层根据用户id查询订单,带分页查询.
	public PageBean<Order> findByUid(Integer uid,Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<Order> list = orderDao.findPageByUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 根据订单id查询订单
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	// 业务层修改订单的方法:
	public void update(Order currOrder) {
		orderDao.update(currOrder);
	}

	// 业务层查询所有订单方法
	public PageBean<Order> findAll(Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		// 设置参数
		pageBean.setPage(page);
		// 设置每页显示的记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = orderDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合
		int begin = (page - 1) * limit;
		List<Order> list = orderDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层查询订单项的方法
	public Set<OrderItem> findOrderItem(Integer oid) {
		return orderDao.findOrderItem(oid);
	}
	
}
