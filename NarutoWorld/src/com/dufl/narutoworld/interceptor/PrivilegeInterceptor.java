package com.dufl.narutoworld.interceptor;

import org.apache.struts2.ServletActionContext;

import com.dufl.narutoworld.vo.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// 判断是否登录,如果登录,放行,没有登录,跳转到登录页面.
		User attribute = (User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
		String username = null;
		if(attribute != null) {
			username = attribute.getUsername();
		}
		if(username == null || username == ""){
			// 跳转到登录页面:
			ActionSupport support = (ActionSupport) actionInvocation.getAction();
			support.addActionError("您还没有登录!没有权限访问!");
			return ActionSupport.LOGIN;
		}else{
			// 已经登录过
			return actionInvocation.invoke();
		}
	}

}
