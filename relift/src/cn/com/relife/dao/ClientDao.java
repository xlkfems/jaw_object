package cn.com.relife.dao;
import java.util.List;

import cn.com.relife.entity.Client;


/**
 * @remark 客户接口类
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public interface ClientDao {
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Client> pageClientAll(int page,int pageSize);
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getTotalCount();
	/**
	 * 	产询单个客户信息方法
	 * @param client
	 * @return
	 */
	public Client queryOne(int id);
	/**
	 * 	增加客户信息方法
	 * @param client
	 * @return
	 */
	public int addClient(Client client);
	/**
	 * 	删除客户信息方法
	 * @param client
	 * @return
	 */
	public int delClient(int id);
	/**
	 * 	修改客户信息方法
	 * @param client
	 * @return
	 */
	public int updClient(Client client);
	
}
