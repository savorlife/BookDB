package com.systop.entity;

import java.util.List;

public class Page {
	
	//��ǰҳ
	private int pageNow;
	//��ҳ��
	private int pages;
	//ÿҳ����
	private int pageSize;
	//������
	private int counts;
	//չʾ
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
