package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Transfer;

public interface ModeDao {
	public int add_mode(Mode mode);//新增运输状态
	
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Mode> pageQueryMode(int page,int pageSize);
	public List<Mode> pageQueryMode(int page,int pageSize,String number);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getMode();
	
	/**
	 * 修改车辆位置以及状态
	 */
	public int update_mode(String city,String number);
	/**
	 * 查询单个
	 */
	public Mode query_mode(String number);
	
	/**
	 * 查询所有待中转的订单
	 */
	
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Mode> QueryMode(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getQuery();
	
	/**
	 * 查询地址对应的中转站
	 */
	public List<Transfer> Query_Transfer(String tr_city);
	/**
	 * 查询信息
	 */
	public Transfer query_Tra(String tr_name);
	/**
	 * 修改其订单状态
	 */
	public int update_mod(String fre_number,String con_receipt);
}
