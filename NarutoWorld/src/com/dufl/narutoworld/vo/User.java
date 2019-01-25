package com.dufl.narutoworld.vo;

public class User{
	private int userid;
	private String username;
	private String password;
	private String sex;
	private String level;
	private String country;
	private String registdate;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegistdate() {
		return registdate;
	}

	public void setRegistdate(String registdate) {
		this.registdate = registdate;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", sex=" + sex
				+ ", level=" + level + ", country=" + country + ", registdate=" + registdate + "]";
	}

}
