package com.systop.dao;

import java.util.List;

import com.systop.entity.Book;

public interface BookDao {

	//��ѯ�б�������Ϣ
	public List<Book> findBookAll(int book_id,String author,int type,String publisher,String bookname);
	
	//����id��1
	public Book findBookById(int id);
	
	//���
	public int addBook(Book book);
		
	//�޸�
	public int updateBook(Book book);
	
	//ɾ��
	public int deletBook(int id);
}
