package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Contract;
import cn.com.relife.entity.Make;
import cn.com.relife.impl.ContractDaoImpl;

public class ContractBiz {
	ContractDaoImpl cdil=new ContractDaoImpl();
	
	/**
	 * 查询所有票据编号
	 * @return
	 */
	public List<Bill> query_bill(){
		return cdil.query_bill();
	}
	/**
	 * 查询接货单的发货地和收货地
	 */
	public Make query_make(String fre_number) {
		return cdil.query_make(fre_number);
	}
	/**
	 * 查询订单号
	 */
	public Bill query_Bill(String number) {
		return cdil.query_Bill(number);
	}
	/**
	 * 新增运输单
	 */
	public int add_edit(Contract contract) {
		return cdil.add_edit(contract);
	}
	/**
	 * 查询所有货运
	 */
	public List<Contract> pageQueryContract(int page,int pageSize){
		return cdil.pageQueryContract(page, pageSize);
		
	}
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getContract() {
		return cdil.getContract();	
	}
	/**
	 * 查询详细信息
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
