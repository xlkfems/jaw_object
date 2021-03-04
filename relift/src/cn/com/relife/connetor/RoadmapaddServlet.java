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
 * @remark 路线控制层
 * @author 随便
 * @createTime 15点14分
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
		
		req.setCharacterEncoding("utf-8");//编码处理
		String oper=req.getParameter("oper");//接收逻辑操作参数
		RoadmapaddDaoImpl tdil=new RoadmapaddDaoImpl();//实例化impl
		RoadmapaddBiz biz=new RoadmapaddBiz();//实例化biz
			
			if(oper.equals("all")) {
				String pageIndex= req.getParameter("pageNo");//获得当前页数
			    if(pageIndex== null){
			        pageIndex= "1";
			    }
			    int currPageNo = Integer.parseInt(pageIndex);//转换为int类型
				int totalCount = tdil.getTotalCount();//获得总记录数
				RoadmapaddPage pages=new RoadmapaddPage();
				pages.setPageSize(8);    //设置每页条数
				pages.setTotalCount(totalCount);   //设置总记录数
				int totalpages= pages.getTotalPageCount();
				/*对首页与末页进行控制*/
			    if(currPageNo < 1){
			        currPageNo = 1;
			    }else if(currPageNo > pages.getTotalPageCount()){
			        currPageNo = totalpages;
			    }
			    pages.setCurrPageNo(currPageNo);    //设置当前页面
			    //调用方法
			    List<Roadmapadd> roadList=biz.pageRoadmapaddAll(pages.getCurrPageNo(), pages.getPageSize());
			   		pages.setListRoadmapadd(roadList);  //设置每页显示的集合
			   	    req.setAttribute("pages", pages);
			   	    req.getRequestDispatcher("backstage/jsp/application/route/route.jsp").forward(req, resp);
			}else 
				
				if(oper.equals("add")) {
				String city = req.getParameter("city");
				String scope = req.getParameter("rangeCity");
				Roadmapadd road = new Roadmapadd(city, scope);
				int result = biz.addRoad(road);
				if(result>0) {
					//执行分页
					String pageIndex= req.getParameter("pageNo");//获得当前页数
				    if(pageIndex== null){
				        pageIndex= "1";
				    }
				    int currPageNo = Integer.parseInt(pageIndex);
					int totalCount=tdil.getTotalCount();//获得总记录数
					RoadmapaddPage pages=new RoadmapaddPage();
					pages.setPageSize(8);    //设置每页条数
					pages.setTotalCount(totalCount);   //设置总记录数
					int totalpages= pages.getTotalPageCount();
					/*对首页与末页进行控制*/
				    if(currPageNo < 1){
				        currPageNo = 1;
				    }else if(currPageNo > pages.getTotalPageCount()){
				        currPageNo = totalpages;
				    }
				    pages.setCurrPageNo(currPageNo);    //设置当前页面
				    List<Roadmapadd> newsList=biz.pageRoadmapaddAll(pages.getCurrPageNo(), pages.getPageSize());
				   		pages.setListRoadmapadd(newsList); //设置每页显示的集合
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
					System.out.println("servlet:删除线路信息成功");
					req.getRequestDispatcher("RoadmapaddServlet?oper=all").forward(req, resp);
				}
			}
	}
}
