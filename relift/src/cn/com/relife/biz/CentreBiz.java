package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Centre;
import cn.com.relife.entity.Place;
import cn.com.relife.impl.CentreDaoImpl;

public class CentreBiz {
	CentreDaoImpl cdil=new CentreDaoImpl();
	
	public int add_Centre(Centre centre) {
		return cdil.add_Centre(centre);
	}
	public List<Centre> pageQueryCentre(int page,int pageSize){
		return cdil.pageQueryCentre(page, pageSize);
	}
	public List<Centre> pageQueryCentre(int page,int pageSize,String number){
		return cdil.pageQueryCentre(page, pageSize,number);
	}
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getCentre() {
		return cdil.getCentre();
	}
	
	public List<Place> pageQueryPlace(int page,int pageSize){
		return cdil.pageQueryPlace(page, pageSize);
	}
	public List<Place> pageQueryPlace(int page,int pageSize,String numebr){
		return cdil.pageQueryPlace(page, pageSize,numebr);
	}
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getPlace() {
		return cdil.getPlace();
	}
}
