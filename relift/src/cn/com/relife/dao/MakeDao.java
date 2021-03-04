package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Make;
import cn.com.relife.entity.Place;

public interface MakeDao {
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Make> pageQueryMake(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getMake();
	/**
	 * 新增货运单
	 */
	public int addMake(Make make);
	/**
	 * 查询状态位已下单的客户编号
	 */
	public List<Place> query_userInfo();
	/**
	 * 查询状态位已下单的客户详细信息
	 */
	public Place query_userInfo(String number);
	/**
	 * 查询货物件数和保价
	 */
	public Place query_refer(String number);
	/**
	 * 修改状态方法
	 */
	public int updatePlace(String number);
	/**
	 * 查询单个货运单
	 */
	public Make queryMake(String number);
	/*
	 * 修改运货单
	 */
	public int update_Make(String number,String make,String make_receipt,String make_freight);
	
	public List<Make> pageQueryMake(int page,int pageSize,String number);
}
