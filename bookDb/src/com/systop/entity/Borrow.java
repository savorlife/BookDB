package com.systop.entity;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Borrow {
	//借阅编号
	int id;
	//图书编号
	int book_id;
	//借阅人编号
	int user_id;
	//借阅时间
	Date borrow_date;
	//借阅图书封面
	String img;
	//还书时间
	Date back_date;
	//归还状态 0已借未取1已借已取2以还
	int or_back;
	//应还时间
	String yinghuan;
	//是否逾期
	boolean ory;
	
	public Borrow(int id, int book_id, int user_id, Date borrow_date, String img, Date back_date, int or_back,
			String yinghuan, boolean ory, String bookname, String u_name) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.user_id = user_id;
		this.borrow_date = borrow_date;
		this.img = img;
		this.back_date = back_date;
		this.or_back = or_back;
		this.yinghuan = yinghuan;
		this.ory = ory;
		this.bookname = bookname;
		this.u_name = u_name;
	}


	//图书名称
	String bookname;
	//用户名称
	String u_name;
	public String getBookname() {
		return bookname;
	}


	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public String getU_name() {
		return u_name;
	}


	public void setU_name(String u_name) {
		this.u_name = u_name;
	}


	public Borrow() {
	
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getYinghuan() {

	    Calendar calendar = new GregorianCalendar(); 
	    Date yinghuan =null;
	    String ying = null;
	    if(this.getBorrow_date()!=null&&!"".equals(this.getBorrow_date())) {
	    	calendar.setTime(this.getBorrow_date()); 
	    
	    calendar.add(Calendar.MONTH,1);
	    yinghuan =  calendar.getTime();
	    
	  //获取现在时间
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化时间 
		ying = sdf.format(yinghuan);
	        
	    }
		return ying;
	}


	public void setYinghuan(String yinghuan) {
		this.yinghuan = yinghuan;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}
	public Date getBack_date() {
		return back_date;
	}
	public void setBack_date(Date back_date) {
		this.back_date = back_date;
	}
	public int getOr_back() {
		return or_back;
	}
	public void setOr_back(int or_back) {
		this.or_back = or_back;
		
	}


	public boolean getOry() {

		    Calendar calendar = new GregorianCalendar(); 
		    boolean ory = false;
		    if(this.getBorrow_date()!=null&&!"".equals(this.getBorrow_date())) {
		    	calendar.setTime(this.getBorrow_date()); 
		    
		    calendar.add(Calendar.MONTH,1);
		    Date date =  calendar.getTime();
		   long yinghuan = date.getTime();
		    
		  //获取现在时间
			 SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
		        sdf.applyPattern("yyyy-MM-dd");
		        Date nowTime = new Date();// 获取当前时间 
		       long now =  nowTime.getTime();
		      
		       
		       if(this.getOr_back()==1) {
		    	    ory = yinghuan<now;
		       }
		    }else {
		    	  ory = false;
		    }
		     
		return ory;
	}


	public void setOry(boolean ory) {
		this.ory = ory;
	}



	
}
