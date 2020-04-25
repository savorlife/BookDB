package com.systop.entity;

import java.util.List;

public class Page {
	
	//当前页
	private int pageNow;
	//总页数
	private int pages;
	//每页几条
	private int pageSize;
	//总数据
	private int counts;
	//展示
	public List<Admin> adminShow;
	
	
	public int getCount() {
		return counts;
	}
	public void setCount(int counts) {
		this.counts = counts;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPages() {
		
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
