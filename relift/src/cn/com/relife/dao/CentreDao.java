package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Centre;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Place;

public interface CentreDao {
	/**
	 * ������ת������Ϣ
	 * @param centre
	 * @return
	 */
	public int add_Centre(Centre centre);
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Centre> pageQueryCentre(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getCentre();
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Place> pageQueryPlace(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getPlace();
}
