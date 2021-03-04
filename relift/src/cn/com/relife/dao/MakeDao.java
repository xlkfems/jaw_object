package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Make;
import cn.com.relife.entity.Place;

public interface MakeDao {
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Make> pageQueryMake(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getMake();
	/**
	 * �������˵�
	 */
	public int addMake(Make make);
	/**
	 * ��ѯ״̬λ���µ��Ŀͻ����
	 */
	public List<Place> query_userInfo();
	/**
	 * ��ѯ״̬λ���µ��Ŀͻ���ϸ��Ϣ
	 */
	public Place query_userInfo(String number);
	/**
	 * ��ѯ��������ͱ���
	 */
	public Place query_refer(String number);
	/**
	 * �޸�״̬����
	 */
	public int updatePlace(String number);
	/**
	 * ��ѯ�������˵�
	 */
	public Make queryMake(String number);
	/*
	 * �޸��˻���
	 */
	public int update_Make(String number,String make,String make_receipt,String make_freight);
	
	public List<Make> pageQueryMake(int page,int pageSize,String number);
}
