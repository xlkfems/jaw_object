package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Contract;
import cn.com.relife.entity.Make;
import cn.com.relife.impl.ContractDaoImpl;

public class ContractBiz {
	ContractDaoImpl cdil=new ContractDaoImpl();
	
	/**
	 * ��ѯ����Ʊ�ݱ��
	 * @return
	 */
	public List<Bill> query_bill(){
		return cdil.query_bill();
	}
	/**
	 * ��ѯ�ӻ����ķ����غ��ջ���
	 */
	public Make query_make(String fre_number) {
		return cdil.query_make(fre_number);
	}
	/**
	 * ��ѯ������
	 */
	public Bill query_Bill(String number) {
		return cdil.query_Bill(number);
	}
	/**
	 * �������䵥
	 */
	public int add_edit(Contract contract) {
		return cdil.add_edit(contract);
	}
	/**
	 * ��ѯ���л���
	 */
	public List<Contract> pageQueryContract(int page,int pageSize){
		return cdil.pageQueryContract(page, pageSize);
		
	}
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getContract() {
		return cdil.getContract();	
	}
	/**
	 * ��ѯ��ϸ��Ϣ
	 * @param number
	 * @return
	 */
	public Contract query_Contract(String number) {
		return cdil.query_Contract(number);
		
	}
	public int update(String number) {
		return cdil.update(number);
	}
	public int update_alter(String number, String loadStation, String dealGoodsStation, String allCarriage) {
		return cdil.update_alter(number, loadStation, dealGoodsStation, allCarriage);

	}
	public List<Contract> pageQueryContract(int page, int pageSize, String number) {
		return cdil.pageQueryContract(page, pageSize, number);

	}
}
