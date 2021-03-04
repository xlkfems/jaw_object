package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Make;
import cn.com.relife.entity.Place;
import cn.com.relife.impl.MakeDaoImpl;

public class MakeBiz {
	MakeDaoImpl mdil=new MakeDaoImpl();
	public List<Make> pageQueryMake(int page,int pageSize){
		return mdil.pageQueryMake(page, pageSize);
	}
	public int getMake() {
		return mdil.getMake();
	}
	
	public int addMake(Make make) {
		return mdil.addMake(make);	
	}
		
	public List<Place> query_userInfo(){
		return mdil.query_userInfo();	
	}
		
	public Place query_userInfo(String number) {
		return mdil.query_userInfo(number);	
	}
	public int update(String number) {
		return mdil.updatePlace(number);
		
	}
	
	public Place query_refer(String number) {
		return mdil.query_refer(number);
		
	}
	public Make queryMake(String number){
		return mdil.queryMake(number);
		
	}
	public int update_Make(String number, String make, String make_receipt, String make_freight) {
		return mdil.update_Make(number, make, make_receipt, make_freight);
		
	}
	public List<Make> pageQueryMake(int page, int pageSize, String number) {
		return mdil.pageQueryMake(page, pageSize, number);
	}
}
