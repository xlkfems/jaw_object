package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Place;
import cn.com.relife.impl.PlaneDaoImpl;
/**
 * @remark ¶©µ¥ÒµÎñÂß¼­²ã
 * @author Ëæ±ã
 *
 */
public class PlaceBiz {
	PlaneDaoImpl pdil=new PlaneDaoImpl();
	
	public List<Place> pageQueryPla(int page,int pageSize){
		return pdil.pageQueryPla(page, pageSize);
	}
	
	public int getPlace() {
		return pdil.getPlace();
	}
	
	public Place query_place(String number) {
		return pdil.query_place(number);
	}
	public int update_place(String number ,String state) {
		return pdil.update_place(number, state);
		
	}
	
	public List<Place> pageQueryPlace(int page,int pageSize){
		return pdil.pageQueryPlace(page, pageSize);
		
	}
	public List<Place> pageQueryPlace(int page,int pageSize,String number){
		return pdil.pageQueryPlace(page, pageSize,number);
		
	}
	public List<Place> pageQueryReport(int page,int pageSize){
		return pdil.pageQueryReport(page, pageSize);
	}
	
	public List<Place> pageQueryPla(int page, int pageSize, String number) {
		return pdil.pageQueryPla(page, pageSize, number);
	}
}
