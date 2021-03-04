package cn.com.relife.dao;

import java.util.List;
import cn.com.relife.entity.Place;
/**
 * @remark 订单信息Dao层
 * @author 随便
 * @createTime 10点39分
 * @version 1.0
 */
public interface PlaceDao {
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Place> pageQueryPla(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getPlace();
	/**
	 * 查询单个详情信息
	 */
	public Place query_place(String number);
	/**
	 * 更改订单状态
	 */
	public int update_place(String number ,String state);
	/**
	 * 写错了，不想该回去了
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Place> pageQueryPlace(int page,int pageSize);
	
	public List<Place> pageQueryReport(int page,int pageSize);
	
	public List<Place> pageQueryPla(int page,int pageSize,String number);
}
