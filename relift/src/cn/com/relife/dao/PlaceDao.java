package cn.com.relife.dao;

import java.util.List;
import cn.com.relife.entity.Place;
/**
 * @remark ������ϢDao��
 * @author ���
 * @createTime 10��39��
 * @version 1.0
 */
public interface PlaceDao {
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Place> pageQueryPla(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getPlace();
	/**
	 * ��ѯ����������Ϣ
	 */
	public Place query_place(String number);
	/**
	 * ���Ķ���״̬
	 */
	public int update_place(String number ,String state);
	/**
	 * д���ˣ�����û�ȥ��
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Place> pageQueryPlace(int page,int pageSize);
	
	public List<Place> pageQueryReport(int page,int pageSize);
	
	public List<Place> pageQueryPla(int page,int pageSize,String number);
}
