package cn.com.relife.dao;

import java.util.List;

import cn.com.relife.entity.Notice;

public interface NoticeDao {
	public List<Notice> pageQueryMode(int page,int pageSize);
	
	public int getNotice();
	public Notice query(String number);
	public int add(Notice notice);
	public int delete(String id);
	public int query_hunan();
}
