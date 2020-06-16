package com.systop.entity;

public class User {

	private int u_id;
	private String u_phone;
	private String userpass;
	private String u_name;
	private int max;
	
	
	public User() {
	}


	public User(int u_id, String u_phone, String userpass, String u_name, int max) {
		super();
		this.u_id = u_id;
		this.u_phone = u_phone;
		this.userpass = userpass;
		this.u_name = u_name;
		this.max = max;
	}


	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
}
