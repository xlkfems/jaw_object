package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Clerk;
import cn.com.relife.impl.ClerkDaoImpl;
/**
 * @remark 职员逻辑控制层
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public class ClerkBiz {
	ClerkDaoImpl impl = new ClerkDaoImpl();
	/**
	 * 查询集合
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Clerk> pageQueryTra(int page,int pageSize){
		return impl.pageQueryTra(page, pageSize);
	}
	public List<Clerk> pageQueryTra(int page,int pageSize,String number){
		return impl.pageQueryTra(page, pageSize,number);
	}
	/**
	 * 查询集合数量
	 * @return int类型
	 * */
	public int getTotalCount() {
		return impl.getTotalCount();
	}
	/**
	 * 新增职员
	 * @param clerk
	 * @return
	 */
	public int addClerk(Clerk clerk) {
		return impl.addClerk(clerk);
	}
	public int delClerk(int id) {
		return impl.delClerk(id);
	}
	public Clerk queryOne(int id) {
		return impl.queryOne(id);
	}
	public int updaClerk(Clerk clerk) {
		return impl.updaClerk(clerk);
	}
}
