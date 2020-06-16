package com.systop.entity;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Borrow {
	//���ı��
	int id;
	//ͼ����
	int book_id;
	//�����˱��
	int user_id;
	//����ʱ��
	Date borrow_date;
	//����ͼ�����
	String img;
	//����ʱ��
	Date back_date;
	//�黹״̬ 0�ѽ�δȡ1�ѽ���ȡ2�Ի�
	int or_back;
	//Ӧ��ʱ��
	String yinghuan;
	//�Ƿ�����
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


	//ͼ������
	String bookname;
	//�û�����
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
	    
	  //��ȡ����ʱ��
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// ��ʽ��ʱ�� 
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
		    
		  //��ȡ����ʱ��
			 SimpleDateFormat sdf = new SimpleDateFormat();// ��ʽ��ʱ�� 
		        sdf.applyPattern("yyyy-MM-dd");
		        Date nowTime = new Date();// ��ȡ��ǰʱ�� 
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
