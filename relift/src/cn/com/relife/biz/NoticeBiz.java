package cn.com.relife.biz;

import java.util.List;

import cn.com.relife.entity.Notice;
import cn.com.relife.impl.NoticeDaoImpl;

public class NoticeBiz {
	NoticeDaoImpl ndil=new NoticeDaoImpl();
	
	public List<Notice> pageQueryMode(int page,int pageSize){
		return ndil.pageQueryMode(page, pageSize);	
	}
	public int getNotice() {
		return ndil.getNotice();
	}
	public Notice query(String number) {
		return ndil.query(number);
	}
	public int add(Notice notice) {
		return ndil.add(notice);
	}
}
