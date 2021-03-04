package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;

public interface BillDao {
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Make> pageQueryBill(int page,int pageSize);
	
	public List<Bill> pageQueryBill(int page,int pageSize,String number);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getMake();
	/**
	 * ��ѯ״̬Ϊ�����Ķ���
	 */
	//public Bill query_bill(String );
	/**
	 * ��ѯ״̬Ϊ���ж������ڵ��ڸ�����˾�����
	 */
	public List<Driver> query_driver(String dr_address);
	
	public List<Bill> QueryBill(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getBill();
	/**
	 * ����Ʊ����Ϣ
	 */
	public int add_Bill(Bill bill);
	/**
	 * �޸Ľӻ���״̬
	 */
	public int update_bill(String fre_number);
	/**
	 * �޸�˾��״̬
	 */
	public int update_driver(String dr_number);
	
}
