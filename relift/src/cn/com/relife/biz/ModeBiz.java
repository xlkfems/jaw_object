package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Transfer;
import cn.com.relife.impl.ModeDaoImpl;

public class ModeBiz {
	ModeDaoImpl mdil=new ModeDaoImpl();
	
	public List<Mode> pageQueryMode(int page,int pageSize){
		return mdil.pageQueryMode(page, pageSize);
		
	}
	public List<Mode> pageQueryMode(int page,int pageSize,String number){
		return mdil.pageQueryMode(page, pageSize, number);
		
	}
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getMode() {
		return mdil.getMode();
		
	}
	
	public int update_mode(String city, String number) {
		return mdil.update_mode(city, number);
	}
	
	public List<Mode> QueryMode(int page,int pageSize){
		return mdil.QueryMode(page, pageSize);
		
	}
	public List<Mode> QueryMode(int page,int pageSize,String number){
		return mdil.QueryMode(page, pageSize,number);
		
	}
	/**
	 * 查询总列数
	 * @return int类型
	 * */
	public int getQuery() {
		return mdil.getQuery();
	}
	
	public List<Transfer> Query_Transfer(String tr_city) {
		return mdil.Query_Transfer(tr_city);
	}
	public Transfer query_Tra(String tr_name) {
		return mdil.query_Tra(tr_name);
		
	}
	
	public int update_mod(String fre_number, String con_receipt) {
		return mdil.update_mod(fre_number, con_receipt);
		
	}
}
