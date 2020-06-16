package com.systop.dao;

import java.util.List;

import com.systop.entity.Book;

public interface BookDao {

	//查询列表所有信息
	public List<Book> findBookAll(int book_id,String author,int type,String publisher,String bookname);
	
	//根据id查1
	public Book findBookById(int id);
	
	//添加
	public int addBook(Book book);
		
	//修改
	public int updateBook(Book book);
	
	//删除
	public int deletBook(int id);
}
