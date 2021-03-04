package cn.com.relife.biz;



import java.util.List;

import cn.com.relife.entity.Roadmapadd;
import cn.com.relife.impl.RoadmapaddDaoImpl;

/**
 * @remark ·���߼���
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */

public class RoadmapaddBiz {
	RoadmapaddDaoImpl impl = new RoadmapaddDaoImpl();
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Roadmapadd> pageRoadmapaddAll(int page,int pageSize){
		return impl.pageRoadmapaddAll(page, pageSize);
	}
	/**
	 * ��ѯ������
	 * @return int����
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
