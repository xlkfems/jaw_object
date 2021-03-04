package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Clerk;
/**
 * @remark 职员dao层
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public interface ClerkDao {
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Clerk> pageQueryTra(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getTotalCount();
	public Clerk queryOne(int id);
	/**
	 * 新增职员
	 * @param clerk
	 * @return
	 */
	public int addClerk(Clerk clerk);
	public int delClerk(int id);
	public int updaClerk(Clerk clerk);
}
