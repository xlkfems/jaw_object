package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Transfer;

public interface TransferDao {
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Transfer> pageQueryTra(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getTotalCount();
	/**
	 * ������תվ
	 */
	public int addTtansfer(Transfer transfer);
	/**
	 * ��ѯ������תվ
	 */
	public List<Transfer> pageQueryTra();
}
