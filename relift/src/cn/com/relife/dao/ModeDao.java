package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Transfer;

public interface ModeDao {
	public int add_mode(Mode mode);//��������״̬
	
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Mode> pageQueryMode(int page,int pageSize);
	public List<Mode> pageQueryMode(int page,int pageSize,String number);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getMode();
	
	/**
	 * �޸ĳ���λ���Լ�״̬
	 */
	public int update_mode(String city,String number);
	/**
	 * ��ѯ����
	 */
	public Mode query_mode(String number);
	
	/**
	 * ��ѯ���д���ת�Ķ���
	 */
	
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Mode> QueryMode(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getQuery();
	
	/**
	 * ��ѯ��ַ��Ӧ����תվ
	 */
	public List<Transfer> Query_Transfer(String tr_city);
	/**
	 * ��ѯ��Ϣ
	 */
	public Transfer query_Tra(String tr_name);
	/**
	 * �޸��䶩��״̬
	 */
	public int update_mod(String fre_number,String con_receipt);
}
