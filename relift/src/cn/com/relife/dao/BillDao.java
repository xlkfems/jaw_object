package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;

public interface BillDao {
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Make> pageQueryBill(int page,int pageSize);
	
	public List<Bill> pageQueryBill(int page,int pageSize,String number);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getMake();
	/**
	 * 查询状态为待发的订单
	 */
	//public Bill query_bill(String );
	/**
	 * 查询状态为空闲而且所在地在附近的司机编号
	 */
	public List<Driver> query_driver(String dr_address);
	
	public List<Bill> QueryBill(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getBill();
	/**
	 * 新增票据信息
	 */
	public int add_Bill(Bill bill);
	/**
	 * 修改接货单状态
	 */
	public int update_bill(String fre_number);
	/**
	 * 修改司机状态
	 */
	public int update_driver(String dr_number);
	
}
