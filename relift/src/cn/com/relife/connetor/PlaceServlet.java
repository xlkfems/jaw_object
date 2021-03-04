package cn.com.relife.connetor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.PlaceBiz;
import cn.com.relife.entity.Place;
import cn.com.relife.entity.PlacePage;
import cn.com.relife.impl.PlaneDaoImpl;

public class PlaceServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//编码处理
		String oper=req.getParameter("oper");//接收逻辑操作参数
		PlaneDaoImpl pdil=new PlaneDaoImpl();
		PlaceBiz biz=new PlaceBiz();
		if(oper.equals("query")) {
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int totalCount=pdil.getPlace();//获得总记录数
			PlacePage pages=new PlacePage();
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
		    List<Place> newsList=biz.pageQueryPla(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListPlace(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/order/details/order_details.jsp").forward(req, resp);
		}else if(oper.equals("details")) {
			String number=req.getParameter("number");
			Place place=biz.query_place(number);
			req.setAttribute("place", place);
			req.getRequestDispatcher("backstage/jsp/order/details/single_order.jsp").forward(req, resp);
		}else if(oper.equals("query_place")) {
			//进行订单详细信息的查询
			String number=req.getParameter("number");
			Place place=biz.query_place(number);
			req.setAttribute("place", place);
			req.getRequestDispatcher("backstage/jsp/settle/goodsBill/close_goodsBill.jsp").forward(req, resp);
		}else if(oper.equals("update_place")) {
			//提交之后进行订单结算，结算完成之后进行状态修改
			String number=req.getParameter("goodsBillCode");
			int count=biz.update_place(number, "已结算");
			if(count>0) {
				System.out.println("修改成功");
			}
			req.getRequestDispatcher("centreServlet?oper=query_place").forward(req, resp);
		}else if(oper.equals("query_close")) {
				//查询已经结算的订单信息
				String pageIndex= req.getParameter("pageNo");//获得当前页数
			    if(pageIndex== null){
			        pageIndex= "1";
			    }
			    int currPageNo = Integer.parseInt(pageIndex);
				int totalCount=pdil.getPlace();//获得总记录数
				PlacePage pages=new PlacePage();
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
			    List<Place> newsList=biz.pageQueryPlace(pages.getCurrPageNo(), pages.getPageSize());
			   		pages.setListPlace(newsList);  //设置每页显示的集合
			   	    req.setAttribute("pages", pages);
			   	    req.getRequestDispatcher("backstage/jsp/settle/goodsBill/goodbill.jsp").forward(req, resp);
		}else if(oper.equals("report")) {
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int totalCount=pdil.getPlace();//获得总记录数
			PlacePage pages=new PlacePage();
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
		    List<Place> newsList=biz.pageQueryReport(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListPlace(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/report/arrive/arrive.jsp").forward(req, resp);
		}else if(oper.equals("client")) {
			String number=req.getParameter("number");
			Place place=biz.query_place(number);
			req.setAttribute("place", place);
			req.getRequestDispatcher("backstage/jsp/report/phone.jsp").forward(req, resp);
			
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int totalCount=pdil.getPlace();//获得总记录数
			PlacePage pages=new PlacePage();
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
		    List<Place> newsList=biz.pageQueryPla(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListPlace(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/order/details/order_details.jsp").forward(req, resp);
		}else if(oper.equals("query_phon")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int totalCount=pdil.getPlace();//获得总记录数
			PlacePage pages=new PlacePage();
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
		    List<Place> newsList=biz.pageQueryPlace(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListPlace(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/settle/goodsBill/goodbill.jsp").forward(req, resp);
		}
	}
}
