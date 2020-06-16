package com.systop.dao;

import java.util.List;

import com.systop.entity.Borrow;

public interface BorrowDao {

	//查询借阅记录列表所有信息
	public List<Borrow> findBorrowAllBy(int book_id,int user_id,int type);
	/*
	//根据借阅ID查询
	public Borrow findBorroweByid(int u_id);
	//根据图书id查询
	public List<Borrow> findBorrowListByid(String u_name);
	//根据读者ID查询
	public Borrow findBorrowByUser(String phone);
	//根据状态查询
	public Borrow findBorrowByPhone(String phone);
	*/
	//动态查询
	//public List<Borrow> findBorrowBy(Borrow borrow);
	//查询今日超期
	//public Borrow findBorrowByCQ(String phone);
	//添加
	//public int addType(Borrow borrow);
	//修改
	//public int updateType(Borrow borrow);
	//删除
	//public int deletType(int u_id);

	public Borrow findBorrowByUid(int user_id);

	public Borrow findBorrowById(int id);
	//增加
	public int AddBorrow(Borrow borrow);
	//修改状态
	public int updateBorrow(int type,int id);
	//修改记录全部信息
	public int updateBorrowAll(Borrow borrow);
	//删除
	public int deleteBorrow(int id);
}
