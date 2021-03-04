package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Clerk;
/**
 * @remark ְԱdao��
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public interface ClerkDao {
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Clerk> pageQueryTra(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getTotalCount();
	public Clerk queryOne(int id);
	/**
	 * ����ְԱ
	 * @param clerk
	 * @return
	 */
	public int addClerk(Clerk clerk);
	public int delClerk(int id);
	public int updaClerk(Clerk clerk);
}
