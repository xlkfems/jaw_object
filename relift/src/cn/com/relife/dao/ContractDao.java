package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Contract;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;
/**
 * @remark 配车Dao层
 * @author 随便
 * @createTime 10点05分
 * @version 1.0
 */
public interface ContractDao {
	/**
	 * 查询所有票据编号
	 * @return
	 */
	public List<Bill> query_bill();
	
	public List<Contract> pageQueryContract(int page, int pageSize,String number);
	/**
	 * 查询收货地和发货地
	 */
	public Make query_make(String fre_number);
	/**
	 * 新增运输合同
	 */
	public int add_edit(Contract contract);
	/**
	 * 根据货运编号查询司机编号
	 */
	public Bill query_Bill(String number);
	/**
	 * 查询所有货运
	 */
	public List<Contract> pageQueryContract(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getContract();
	/**
	 * 查询所有货运信息
	 */
	public Contract query_Contract(String number);
	/**
	 * 修改状态
	 */
	public int update(String number);
	/**
	 * 修改东西
	 */
	public int update_alter(String number,String loadStation,String dealGoodsStation,String allCarriage);
}
