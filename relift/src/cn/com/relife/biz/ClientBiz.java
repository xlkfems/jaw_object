package cn.com.relife.biz;



import java.util.List;

import cn.com.relife.entity.Client;
import cn.com.relife.impl.ClientDaoImpl;
/**
 * @remark 客户逻辑层
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public class ClientBiz {
	ClientDaoImpl impl = new ClientDaoImpl();
	/**
	 * 	查询全部方法
	 * @param client
	 * @return
	 */
	public List<Client> pageClientAll(int page,int pageSize){
		return impl.pageClientAll(page, pageSize);
	}
	public List<Client> pageClientAll(int page,int pageSize,String number){
		return impl.pageClientAll(page, pageSize,number);
	}
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getTotalCount() {
		return impl.getTotalCount();
	}
	/**
	 * 	产询单个客户信息方法
	 * @param client
	 * @return
	 */
	public Client queryOne(int id) {
		return impl.queryOne(id);
	}
	/**
	 * 	增加客户信息方法
	 * @param client
	 * @return
	 */
	public int addClient(Client client) {
		return impl.addClient(client);
	}
	/**
	 * 	删除客户信息方法
	 * @param client
	 * @return
	 */
	public int delClient(int id) {
		return impl.delClient(id);
	}
	/**
	 * 	修改客户信息方法
	 * @param client
	 * @return
	 */
	public int updClient(Client client) {
		return impl.updClient(client);
	}
}
