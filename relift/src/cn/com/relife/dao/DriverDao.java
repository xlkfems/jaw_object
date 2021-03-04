package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Driver;

/**
 * @remark ˾���ӿ���
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public interface DriverDao {
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Driver> pageDriverAll(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getTotalCount();
	/**
	 * 	��ѯ����˾����Ϣ����
	 * @param Driver
	 * @return
	 */
	public Driver queryOne(int id);
	/**
	 * 	���ӿͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int addDriver(Driver driver);
	/**
	 * 	ɾ���ͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int delDriver(int id);
	/**
	 * 	�޸Ŀͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int updDriver(Driver driver);
}
