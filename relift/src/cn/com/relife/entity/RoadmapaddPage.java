package cn.com.relife.entity;

import java.util.List;

public class RoadmapaddPage {
	/*
	 ���ȷ���һ��:���Ƿ�ҳ��Ҫ��Щ����,
	 ��ʽ: select*from user where limit (pageNo-1)*pageSize,pageSize
	 pageNo �ǵ�ǰҳ�� 	pageSize �ǵ�ǰ��ʾ��������
	 pageTotalCount �ܼ�¼��   pageTotle ��ҳ�� 
	 list<T> ���� ���ڴ洢�Ҳ�ѯ��������
	  */
	private int currPageNo=1;//��ǰҳ��
	private int totalCount=0;//��¼����
	/*��ҳ�� ��Ҽ�Ȼ֪�� ��ǰҳ����(pageNo-1)*pageSize������� 
	  ��ô���Ƿ��������������ҳ���� */
	private int totalPageCount=1;//��ҳ��
	private int pageSize=0;//ҳ���С����ÿҳ��ʾ��¼��
	private List<Roadmapadd> roadList;//ѧ�����϶���
	
	public List<Roadmapadd> getListRoad() {
		return roadList;
	}
	public void setListRoadmapadd(List<Roadmapadd> roadList) {
		this.roadList = roadList;
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
		if(totalCount>0){//��¼����
			this.totalCount = totalCount;
			/*
		 	totalPageCount����ҳ�� totalCount���ܼ�¼�� 
		 	��ǰҳ��:(pageNo-1)*pageSize
		 	���������ж� �������%��ʾ��==0 ��ô��ֱ��������/��ǰ��ʾ�������õ�������
		 	�����������Ϊ��ǰ���������һҳ
		 */
			totalPageCount=this.totalCount%pageSize==0?(this.totalCount/pageSize):
				this.totalCount/pageSize+1;
		}
	}
}
