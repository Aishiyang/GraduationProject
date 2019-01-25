package com.dufl.narutoworld.vo;

public class Admin {
	private String adminName;
	private String adminLoginName;
	private String adminPassword;
	
	public String getAdminName() {
		return adminName;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getAdminLoginName() {
		return adminLoginName;
	}
	
	public void setAdminLoginName(String adminLoginName) {
		this.adminLoginName = adminLoginName;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminLoginName=" + adminLoginName + ", adminPassword="
				+ adminPassword + "]";
	}

}
