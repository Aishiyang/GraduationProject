package com.dufl.narutoworld.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dufl.narutoworld.dao.UserDao;
import com.dufl.narutoworld.vo.User;

public class UserService {
	
	private UserDao userDao = new UserDao();

	public int regist(User user){
		user.setRegistdate(currentDate());
		int status = userDao.insertUser(user);
		return status;
	}
	
	public boolean existsUser(String username) {
		User user = userDao.selectByUsername(username);
		if(user == null) {
			return false;
		}
		return true;
	}
	
	public User login(String username) {
		User user = userDao.selectByUsername(username);
		return user;
	}
	
	private static String currentDate(){
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateString = simpleDateFormat.format(now);
		return currentDateString;
	}

	public List<User> selectAll(){
		return userDao.selectAll();
	}
	
	public int deleteUserById(String userid){
		return userDao.deleteUserById(userid);
	}
}
