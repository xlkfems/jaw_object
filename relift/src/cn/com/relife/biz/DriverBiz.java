package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Driver;
import cn.com.relife.impl.DriverDaoImpl;
/**
 * @remark 司机逻辑层
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public class DriverBiz {
	DriverDaoImpl impl = new DriverDaoImpl();
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	public List<Driver> pageDriverAll(int page,int pageSize){
		return impl.pageDriverAll(page, pageSize);
	}
	public List<Driver> pageDriverAll(int page,int pageSize,String number){
		return impl.pageDriverAll(page, pageSize,number);
	}
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getTotalCount() {
		return impl.getTotalCount();
	}
	/**
	 * 	产询单个司机信息方法
	 * @param Driver
	 * @return
	 */
	public Driver queryOne(int id) {
		return impl.queryOne(id);
	}
	/**
	 * 	增加客户信息方法
	 * @param client
	 * @return
	 */
	public int addDriver(Driver driver) {
		return impl.addDriver(driver);
	}
	/**
	 * 	删除客户信息方法
	 * @param client
	 * @return
	 */
	public int delDriver(int id) {
		return impl.delDriver(id);
	}
	/**
	 * 	修改客户信息方法
	 * @param client
	 * @return
	 */
	public int updDriver(Driver driver) {
		return impl.updDriver(driver);
	}
}
