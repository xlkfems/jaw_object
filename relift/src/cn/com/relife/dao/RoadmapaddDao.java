package cn.com.relife.dao;



import java.util.List;

import cn.com.relife.entity.Roadmapadd;

/**
 * @remark 路线接口类
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public interface RoadmapaddDao {
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Roadmapadd> pageRoadmapaddAll(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getTotalCount();
	public Roadmapadd queryOne(int path_id);
	public int addRoad(Roadmapadd road);
	public int delRoad(int path_id);
	public int updRoad(Roadmapadd road);
}
