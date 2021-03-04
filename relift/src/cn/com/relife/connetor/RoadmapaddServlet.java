package cn.com.relife.connetor;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.RoadmapaddBiz;
import cn.com.relife.entity.Roadmapadd;
import cn.com.relife.entity.RoadmapaddPage;
import cn.com.relife.impl.RoadmapaddDaoImpl;

/**
 * @remark ·�߿��Ʋ�
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */

public class RoadmapaddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getContextPath();
		   
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" +     
	    req.getServerPort() + path + "/";
		
		req.setCharacterEncoding("utf-8");//���봦��
		String oper=req.getParameter("oper");//�����߼���������
		RoadmapaddDaoImpl tdil=new RoadmapaddDaoImpl();//ʵ����impl
		RoadmapaddBiz biz=new RoadmapaddBiz();//ʵ����biz
			
			if(oper.equals("all")) {
				String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
			    if(pageIndex== null){
			        pageIndex= "1";
			    }
			    int currPageNo = Integer.parseInt(pageIndex);//ת��Ϊint����
				int totalCount = tdil.getTotalCount();//����ܼ�¼��
				RoadmapaddPage pages=new RoadmapaddPage();
				pages.setPageSize(8);    //����ÿҳ����
				pages.setTotalCount(totalCount);   //�����ܼ�¼��
				int totalpages= pages.getTotalPageCount();
				/*����ҳ��ĩҳ���п���*/
			    if(currPageNo < 1){
			        currPageNo = 1;
			    }else if(currPageNo > pages.getTotalPageCount()){
			        currPageNo = totalpages;
			    }
			    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
			    //���÷���
			    List<Roadmapadd> roadList=biz.pageRoadmapaddAll(pages.getCurrPageNo(), pages.getPageSize());
			   		pages.setListRoadmapadd(roadList);  //����ÿҳ��ʾ�ļ���
			   	    req.setAttribute("pages", pages);
			   	    req.getRequestDispatcher("backstage/jsp/application/route/route.jsp").forward(req, resp);
			}else 
				
				if(oper.equals("add")) {
				String city = req.getParameter("city");
				String scope = req.getParameter("rangeCity");
				Roadmapadd road = new Roadmapadd(city, scope);
				int result = biz.addRoad(road);
				if(result>0) {
					//ִ�з�ҳ
					String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
				    if(pageIndex== null){
				        pageIndex= "1";
				    }
				    int currPageNo = Integer.parseInt(pageIndex);
					int totalCount=tdil.getTotalCount();//����ܼ�¼��
					RoadmapaddPage pages=new RoadmapaddPage();
					pages.setPageSize(8);    //����ÿҳ����
					pages.setTotalCount(totalCount);   //�����ܼ�¼��
					int totalpages= pages.getTotalPageCount();
					/*����ҳ��ĩҳ���п���*/
				    if(currPageNo < 1){
				        currPageNo = 1;
				    }else if(currPageNo > pages.getTotalPageCount()){
				        currPageNo = totalpages;
				    }
				    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
				    List<Roadmapadd> newsList=biz.pageRoadmapaddAll(pages.getCurrPageNo(), pages.getPageSize());
				   		pages.setListRoadmapadd(newsList); //����ÿҳ��ʾ�ļ���
				   	    req.setAttribute("pages", pages);
				   	    req.getRequestDispatcher("backstage/jsp/application/route/route.jsp").forward(req, resp);
				}
			}else if(oper.equals("one")) {
				
				int id = Integer.parseInt(req.getParameter("id"));
				Roadmapadd road  = biz.queryOne(id);
				req.setAttribute("road", road);
				req.getRequestDispatcher("backstage/jsp/application/route/rou_update.jsp").forward(req, resp);
			}else if(oper.equals("upda")) {
				String city = req.getParameter("city");
				String scope = req.getParameter("rangeCity");
				int id = Integer.parseInt(req.getParameter("id"));
				Roadmapadd road = new Roadmapadd( city, scope,id);
				int result = biz.updRoad(road);
				if(result>0) {
					req.getRequestDispatcher("RoadmapaddServlet?oper=all").forward(req, resp);
				}
			}else if(oper.equals("del")) {
				int id = Integer.parseInt(req.getParameter("id"));
				int result = biz.delRoad(id);
				if(result>0) {
					System.out.println("servlet:ɾ����·��Ϣ�ɹ�");
					req.getRequestDispatcher("RoadmapaddServlet?oper=all").forward(req, resp);
				}
			}
	}
}
