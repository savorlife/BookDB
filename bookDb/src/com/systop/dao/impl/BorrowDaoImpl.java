package com.systop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.systop.dao.BorrowDao;
import com.systop.entity.Borrow;

import com.systop.util.DBUtilsDao;

public class BorrowDaoImpl implements BorrowDao{

	@Override
	public List<Borrow> findBorrowAllBy(int book_id,int user_id,int type) {
		List<Borrow> list = null;
		String sql = "select borrow.*,user.u_id,user.u_name,book.bookname,book.img from borrow left join user on borrow.user_id=user.u_id left join book on borrow.book_id=book.id where 1=1";
		
		if(book_id != 0) {
			sql+=" and borrow.book_id ="+book_id;
			
		}
		if(user_id != 0) {
			sql+=" and borrow.user_id ="+user_id;
			
		}
		if(type >= 0) {
			sql+=" and borrow.or_back = "+type;
		}
		
		sql+=" ORDER BY borrow.or_back ";
		//调用后台方法
		try {
			list = DBUtilsDao.findAll(sql ,Borrow.class);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Borrow findBorrowByUid(int user_id) {
		Borrow borrow = new Borrow();
		String sql = "select borrow.*,user.u_id,user.u_name,book.bookname,book.img from borrow left join user on borrow.user_id=user.u_id left join book on borrow.book_id=book.id where borrow.user_id = ?";

		try {
			borrow = DBUtilsDao.findObjectByParams(sql, Borrow.class, user_id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return borrow;
	}
	
	//根据id查询借阅记录
	@Override
	public Borrow findBorrowById(int id) {
		Borrow borrow = new Borrow();
		String sql = "select * from borrow where id = ?";

		try {
			borrow = DBUtilsDao.findObjectByParams(sql, Borrow.class, id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return borrow;
	}
	
	//添加
	@Override
	public int AddBorrow(Borrow borrow) {
	
		//sql语句
		String sql = "insert into borrow(book_id,user_id,borrow_date,or_back) values (?,?,?,?)";
		java.sql.Date Borrow_date =null;
		if(borrow.getBorrow_date() !=null&&!"".equals(borrow.getBorrow_date())) {
			Borrow_date = new java.sql.Date(borrow.getBorrow_date().getTime());
		}
		
		int row = 0;
		try {
			row = DBUtilsDao.update(sql,borrow.getBook_id(),borrow.getUser_id(),Borrow_date,borrow.getOr_back());
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return row;
	}
	
	
	//修改借阅记录的全部信息
		@Override
		public int updateBorrowAll(Borrow borrow) {
			int i = 0;
			String sql = "update borrow set book_id = ?,user_id = ?,borrow_date = ?,back_date = ?,or_back = ? where id = ?";
			java.sql.Date Borrow_date =null;
			if(borrow.getBorrow_date()!=null&&!"".equals(borrow.getBorrow_date())) {
				Borrow_date = new java.sql.Date(borrow.getBorrow_date().getTime());
			}
			java.sql.Date Back_date = null;
			if(borrow.getBack_date()!=null&&!"".equals(borrow.getBack_date())) {
				Back_date = new java.sql.Date(borrow.getBack_date().getTime());
			}
			
			
			try {
				i = DBUtilsDao.update(sql,borrow.getBook_id(),borrow.getUser_id(),Borrow_date,Back_date,borrow.getOr_back(),borrow.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return i;
		}


	//修改借阅记录的状态
	public int updateBorrow(int type,int id) {
		int i = 0;
		String sql = null;
		if(type == 1) {
			sql = "update borrow set or_back = 1,borrow_date = CURDATE() where id = ?";
		}else if(type == 2) {
			sql = "update borrow set or_back = 2,back_date = CURDATE() where id = ?";
		}else {
			sql = "update borrow set or_back = 0 where id = ?";
		}

		try {
			i = DBUtilsDao.update(sql,id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return i;
	}
	//删除借阅记录
	public int deleteBorrow(int id) {
		int i = 0;
		String sql = "delete from borrow where id = ?";
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
