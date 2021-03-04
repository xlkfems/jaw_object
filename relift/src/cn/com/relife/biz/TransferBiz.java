package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Transfer;
import cn.com.relife.impl.TransferDaoImpl;

public class TransferBiz {
	TransferDaoImpl tdil=new TransferDaoImpl();
	/**
	 * 查询集合
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Transfer> pageQueryTra(int page,int pageSize){
		return tdil.pageQueryTra(page, pageSize);
		
	}
	/**
	 * 查询集合数量
	 * @return
	 */
	public int getTotalCount() {
		return tdil.getTotalCount();
		
	}
	/**
	 * 新增方法
	 * @param transfer
	 * @return
	 */
	public int addTtansfer(Transfer transfer) {
		return tdil.addTtansfer(transfer);
		
	}
	public List<Transfer> pageQueryTra(){
		return tdil.pageQueryTra();
	}
}
