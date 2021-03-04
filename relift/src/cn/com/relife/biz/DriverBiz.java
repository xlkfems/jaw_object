package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Driver;
import cn.com.relife.impl.DriverDaoImpl;
/**
 * @remark ˾���߼���
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public class DriverBiz {
	DriverDaoImpl impl = new DriverDaoImpl();
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Driver> pageDriverAll(int page,int pageSize){
		return impl.pageDriverAll(page, pageSize);
	}
	public List<Driver> pageDriverAll(int page,int pageSize,String number){
		return impl.pageDriverAll(page, pageSize,number);
	}
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getTotalCount() {
		return impl.getTotalCount();
	}
	/**
	 * 	��ѯ����˾����Ϣ����
	 * @param Driver
	 * @return
	 */
	public Driver queryOne(int id) {
		return impl.queryOne(id);
	}
	/**
	 * 	���ӿͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int addDriver(Driver driver) {
		return impl.addDriver(driver);
	}
	/**
	 * 	ɾ���ͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int delDriver(int id) {
		return impl.delDriver(id);
	}
	/**
	 * 	�޸Ŀͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int updDriver(Driver driver) {
		return impl.updDriver(driver);
	}
}
