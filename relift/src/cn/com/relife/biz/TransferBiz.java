package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Transfer;
import cn.com.relife.impl.TransferDaoImpl;

public class TransferBiz {
	TransferDaoImpl tdil=new TransferDaoImpl();
	/**
	 * ��ѯ����
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Transfer> pageQueryTra(int page,int pageSize){
		return tdil.pageQueryTra(page, pageSize);
		
	}
	/**
	 * ��ѯ��������
	 * @return
	 */
	public int getTotalCount() {
		return tdil.getTotalCount();
		
	}
	/**
	 * ��������
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
