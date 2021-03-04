package cn.com.relife.entity;

import java.util.List;

public class ClientPage {
	/*
	 首先分析一下:我们分页需要哪些属性,
	 公式: select*from user where limit (pageNo-1)*pageSize,pageSize
	 pageNo 是当前页数 	pageSize 是当前显示的数据量
	 pageTotalCount 总记录数   pageTotle 总页数 
	 list<T> 集合 用于存储我查询到的数据
	  */
	private int currPageNo=1;//当前页号
	private int totalCount=0;//记录总数
	/*总页数 大家既然知道 当前页数由(pageNo-1)*pageSize求出来的 
	  那么我们反着来就能求出总页数了 */
	private int totalPageCount=1;//总页数
	private int pageSize=0;//页面大小，即每页显示记录数
	private List<Client> clientList;//学生集合对象
	
	public List<Client> getListClient() {
		return clientList;
	}
	public void setListClient(List<Client> clientList) {
		this.clientList = clientList;
	}
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
			this.currPageNo = currPageNo;	
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
			this.totalPageCount = totalPageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount>0){//记录总数
			this.totalCount = totalCount;
			/*
		 	totalPageCount是总页数 totalCount是总记录数 
		 	当前页数:(pageNo-1)*pageSize
		 	我们做个判断 如果总数%显示数==0 那么我直接拿总数/当前显示数就能拿到总码数
		 	如果有余数则为当前码数再添加一页
		 */
			totalPageCount=this.totalCount%pageSize==0?(this.totalCount/pageSize):
				this.totalCount/pageSize+1;
		}
	}
}
