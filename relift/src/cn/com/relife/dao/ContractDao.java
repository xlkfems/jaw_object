package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Contract;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;
/**
 * @remark �䳵Dao��
 * @author ���
 * @createTime 10��05��
 * @version 1.0
 */
public interface ContractDao {
	/**
	 * ��ѯ����Ʊ�ݱ��
	 * @return
	 */
	public List<Bill> query_bill();
	
	public List<Contract> pageQueryContract(int page, int pageSize,String number);
	/**
	 * ��ѯ�ջ��غͷ�����
	 */
	public Make query_make(String fre_number);
	/**
	 * ���������ͬ
	 */
	public int add_edit(Contract contract);
	/**
	 * ���ݻ��˱�Ų�ѯ˾�����
	 */
	public Bill query_Bill(String number);
	/**
	 * ��ѯ���л���
	 */
	public List<Contract> pageQueryContract(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getContract();
	/**
	 * ��ѯ���л�����Ϣ
	 */
	public Contract query_Contract(String number);
	/**
	 * �޸�״̬
	 */
	public int update(String number);
	/**
	 * �޸Ķ���
	 */
	public int update_alter(String number,String loadStation,String dealGoodsStation,String allCarriage);
}
