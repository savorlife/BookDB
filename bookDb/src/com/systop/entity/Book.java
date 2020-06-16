package com.systop.entity;

public class Book {

	private int id;
	private String bookname;
	private int booktype;
	private String author;
	private String publisher;
	private Double price;
	private int kucun;
	private String img;
	private String content;
	private String typeName;
	
	public Book() {
	}


	public Book(int id, String bookname, int booktype, String author, String publisher, Double price, int kucun,
			String img, String content,String typeName) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.booktype = booktype;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.kucun = kucun;
		this.img = img;
		this.content = content;
		this.typeName = typeName;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getBooktype() {
		return booktype;
	}
	public void setBooktype(int booktype) {
		this.booktype = booktype;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getKucun() {
		return kucun;
	}
	public void setKucun(int kucun) {
		this.kucun = kucun;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
}
