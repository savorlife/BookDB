package com.systop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.systop.dao.BookDao;
import com.systop.entity.Book;
import com.systop.util.DBUtilsDao;

public class BookDaoImpl implements BookDao{

	@Override
	public List<Book> findBookAll(int book_id,String author,int type,String publisher,String bookname) {
		List<Book> list = null;
		String sql = "select book.*,type.typeName from book left join type on book.booktype = type.typeID where 1=1 ";


		if(book_id != 0 && book_id > 0) {
			sql+=" and book.id = "+book_id;
			
		}
		if(author != null && !"".equals(author)) {
			sql+=" and book.author like '%"+author;
			sql+="%'";
			
		}
		if(bookname != null && !"".equals(bookname)) {
			sql+=" and book.bookname like '%"+bookname;
			sql+="%'";
		}
		if(publisher != null && !"".equals(publisher)) {
			sql+=" and book.publisher like '%"+publisher;
			sql+="%'";
		}
		if(type >= 0) {
			sql+=" and book.booktype = "+type;
		}
		

		try {
			list = DBUtilsDao.findAll(sql ,Book.class);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
	
	

	@Override
	public Book findBookById(int id) {
		Book book = null;
		String sql = "select * from book where id = ?";
		//调用后台方法
		try {
			book = DBUtilsDao.findObjectByParams(sql, Book.class, id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public int addBook(Book book) {
		int i = 0;
		String sql = "insert into book (bookname,booktype,author,publisher,price,kucun,content,img) values (?,?,?,?,?,?,?,?)";
		//调用后台方法
		try {
			i = DBUtilsDao.update(sql, book.getBookname(), book.getBooktype(),book.getAuthor(),book.getPublisher(),book.getPrice(),book.getKucun(),book.getContent(),book.getImg());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateBook(Book book) {
		int i = 0;
		String sql = "update book set bookname = ?,booktype = ?,author = ?,publisher = ?,price = ?,kucun = ?,img = ?,content = ? where id = ?";
		//调用后台方法
		try {
			i = DBUtilsDao.update(sql, book.getBookname(),book.getBooktype(),book.getAuthor(),book.getPublisher(),book.getPrice(),book.getKucun(),book.getImg(),book.getContent(),book.getId());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deletBook(int id) {
		int i = 0;
		String sql = "delete from book where id = ?";
		//调用后台方法
		try {
			i = DBUtilsDao.update(sql, id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return i;
	}

}
