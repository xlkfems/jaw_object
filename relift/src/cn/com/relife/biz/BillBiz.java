package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;
import cn.com.relife.impl.BillDaoImpl;
import cn.com.relife.impl.MakeDaoImpl;
/**
 * @remark 票据业务逻辑层
 * @author 随便
 * @createTime 19点15分
 * @version 1.0
 */
public class BillBiz {
	MakeDaoImpl mdil=new MakeDaoImpl();
	public List<Make> pageQueryBill(int page,int pageSize){
		return mdil.pageQueryMake(page, pageSize);
	}
	
	public int getMake() {
		return mdil.getMake();
	}
	BillDaoImpl bdil=new BillDaoImpl();
	public List<Driver> query_driver(String dr_address) {
		return bdil.query_driver(dr_address);
		
	}
	
	public List<Bill> QueryBill(int page,int pageSize){
		return bdil.QueryBill(page, pageSize);
		
	}
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getBill() {
		return bdil.getBill();
		
	}
	/**
	 * 新增票据
	 */
	public int add_Bill(Bill bill) {
		return bdil.add_Bill(bill);	
	}
	
	public int update_bill(String fre_number) {
		return bdil.update_bill(fre_number);
		
	}
	/**
	 * 修改司机状态
	 */
	public int update_driver(String dr_number) {
		return bdil.update_driver(dr_number);
		
	}
	public List<Bill> pageQueryBill(int page,int pageSize,String number){
		return bdil.pageQueryBill(page, pageSize,number);
	}
}
