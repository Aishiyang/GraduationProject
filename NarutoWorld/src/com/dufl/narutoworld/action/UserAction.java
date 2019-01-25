package com.dufl.narutoworld.action;

import org.apache.struts2.ServletActionContext;

import com.dufl.narutoworld.service.UserService;
import com.dufl.narutoworld.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	
	public User getModel(){
		return user;
	}
	
	private UserService userService = new UserService();
	
	public String regist(){
		boolean isExists = userService.existsUser(user.getUsername());
		if(isExists){
		    this.addFieldError("user.username", "用户名已存在！！！");
			return "registExists";
		}
		int res = userService.regist(user);
		if(res > 0){
			return "registSuccess";
		}
		return null;
	}
	
	public String login(){
		User users = userService.login(user.getUsername());
		if(users == null || users.getUsername() == "null"){
			this.addFieldError("user.login", "用户不存在！！！");
			return "loginFail";
		}else if(users.getUsername().equals(user.getUsername()) && users.getPassword().equals(user.getPassword())){
			ServletActionContext.getRequest().getSession().setAttribute("existUser", users);
			return "loginSuccess";
		}else {
			this.addFieldError("user.login", "用户或密码错误！！！");
			return "loginFail";
		}
	}
	
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
