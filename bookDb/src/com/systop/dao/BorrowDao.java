package com.systop.dao;

import java.util.List;

import com.systop.entity.Borrow;

public interface BorrowDao {

	//��ѯ���ļ�¼�б�������Ϣ
	public List<Borrow> findBorrowAllBy(int book_id,int user_id,int type);
	/*
	//���ݽ���ID��ѯ
	public Borrow findBorroweByid(int u_id);
	//����ͼ��id��ѯ
	public List<Borrow> findBorrowListByid(String u_name);
	//���ݶ���ID��ѯ
	public Borrow findBorrowByUser(String phone);
	//����״̬��ѯ
	public Borrow findBorrowByPhone(String phone);
	*/
	//��̬��ѯ
	//public List<Borrow> findBorrowBy(Borrow borrow);
	//��ѯ���ճ���
	//public Borrow findBorrowByCQ(String phone);
	//���
	//public int addType(Borrow borrow);
	//�޸�
	//public int updateType(Borrow borrow);
	//ɾ��
	//public int deletType(int u_id);

	public Borrow findBorrowByUid(int user_id);

	public Borrow findBorrowById(int id);
	//����
	public int AddBorrow(Borrow borrow);
	//�޸�״̬
	public int updateBorrow(int type,int id);
	//�޸ļ�¼ȫ����Ϣ
	public int updateBorrowAll(Borrow borrow);
	//ɾ��
	public int deleteBorrow(int id);
}
