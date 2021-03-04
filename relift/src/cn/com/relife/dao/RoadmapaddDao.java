package cn.com.relife.dao;



import java.util.List;

import cn.com.relife.entity.Roadmapadd;

/**
 * @remark ·�߽ӿ���
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public interface RoadmapaddDao {
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Roadmapadd> pageRoadmapaddAll(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getTotalCount();
	public Roadmapadd queryOne(int path_id);
	public int addRoad(Roadmapadd road);
	public int delRoad(int path_id);
	public int updRoad(Roadmapadd road);
}
