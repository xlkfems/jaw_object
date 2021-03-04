package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Transfer;

public interface TransferDao {
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Transfer> pageQueryTra(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getTotalCount();
	/**
	 * 新增中转站
	 */
	public int addTtansfer(Transfer transfer);
	/**
	 * 查询所有中转站
	 */
	public List<Transfer> pageQueryTra();
}
