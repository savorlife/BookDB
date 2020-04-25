package com.systop.entity;

public class Admin{
	private int a_id;
	private String account;
	private String adminpass;
	private int type;
	private int pages;
	public Admin() {
		
	}
	
	public Admin(int a_id,String account,String adminpass, int type) {
		this.a_id=a_id;
		this.account=account;
		this.adminpass=adminpass;
		this.type=type;

		
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}


	
}
