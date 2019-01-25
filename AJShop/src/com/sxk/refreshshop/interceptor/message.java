package com.sxk.refreshshop.interceptor;

import com.opensymphony.xwork2.ActionSupport;

public class message extends ActionSupport {

	private static final long serialVersionUID = 2353125932548676189L;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
