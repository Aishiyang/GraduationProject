package com.sxk.refreshshop.service;

import java.util.List;

import com.sxk.refreshshop.dao.UserDao;
import com.sxk.refreshshop.pojo.User;
import com.sxk.refreshshop.utils.PageBean;
import com.sxk.refreshshop.utils.UUIDUtils;

public class UserService {
	
	private UserDao userDao = new UserDao();

	// 按用户名查询用户的方法:
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}

	// 业务层完成用户注册代码:
	public void save(User user) {
		// 将数据存入到数据库
		user.setState(1); // 0:代表用户未激活.  1:代表用户已经激活.
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
	}

	// 用户登录的方法
	public User login(User user) {
		return userDao.login(user);
	}

	// 业务层用户查询所有
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = userDao.findCount();
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
		List<User> list = userDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}

	public void delete(User existUser) {
		userDao.delete(existUser);
	}
}
