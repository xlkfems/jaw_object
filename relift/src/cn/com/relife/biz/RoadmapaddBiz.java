package cn.com.relife.biz;



import java.util.List;

import cn.com.relife.entity.Roadmapadd;
import cn.com.relife.impl.RoadmapaddDaoImpl;

/**
 * @remark 路线逻辑层
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */

public class RoadmapaddBiz {
	RoadmapaddDaoImpl impl = new RoadmapaddDaoImpl();
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Roadmapadd> pageRoadmapaddAll(int page,int pageSize){
		return impl.pageRoadmapaddAll(page, pageSize);
	}
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getTotalCount() {
		return impl.getTotalCount();
	}
	public Roadmapadd queryOne(int path_id) {
		return impl.queryOne(path_id);
	}
	public int addRoad(Roadmapadd road) {
		return impl.addRoad(road);
	}
	public int delRoad(int path_id) {
		return impl.delRoad(path_id);
	}
	public int updRoad(Roadmapadd road) {
		return impl.updRoad(road);
	}
}
