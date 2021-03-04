package cn.com.relife.dao;

import cn.com.relife.entity.Nmsl;

public interface NmslDao {
	public Nmsl query(int id); //查询单个
	
	public int update(Nmsl nmsl);//修改所有信息
}
