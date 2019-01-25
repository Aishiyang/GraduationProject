package com.sxk.refreshshop.service;

import com.sxk.refreshshop.dao.AdminUserDao;
import com.sxk.refreshshop.pojo.AdminUser;

public class AdminUserService {
	private AdminUserDao adminUserDao = new AdminUserDao();
	
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
