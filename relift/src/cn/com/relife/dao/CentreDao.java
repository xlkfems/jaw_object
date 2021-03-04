package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Centre;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Place;

public interface CentreDao {
	/**
	 * 新增中转订单信息
	 * @param centre
	 * @return
	 */
	public int add_Centre(Centre centre);
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Centre> pageQueryCentre(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getCentre();
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Place> pageQueryPlace(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getPlace();
}
