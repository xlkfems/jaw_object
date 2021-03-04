package cn.com.relife.connetor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.CentreBiz;
import cn.com.relife.biz.ModeBiz;
import cn.com.relife.entity.Centre;
import cn.com.relife.entity.CentrePage;
import cn.com.relife.entity.Clerk;
import cn.com.relife.entity.ClerkPage;
import cn.com.relife.entity.Place;
import cn.com.relife.entity.PlacePage;
import cn.com.relife.impl.CentreDaoImpl;
import cn.com.relife.impl.ModeDaoImpl;

public class CentreServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//编码处理
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//接收逻辑操作参数
		
		CentreDaoImpl cdil=new CentreDaoImpl();
		CentreBiz biz=new CentreBiz();
		ModeDaoImpl mdil=new ModeDaoImpl();
		ModeBiz modebiz=new ModeBiz();
		
		if(oper.equals("add")) {
			//将填写好的中转订单进行保存
			String fre_number=req.getParameter("fre_number");
			String transferStation=req.getParameter("transferStation");//中转地
			String transferCheck=req.getParameter("transferCheck");//司机
			String receiveBillTime=req.getParameter("receiveBillTime");//时间
			String receiveBillPerson=req.getParameter("receiveBillPerson");//站点名称
			String transferCompany=req.getParameter("transferCompany");//详情地址
			String transferStationTel=req.getParameter("transferStationTel");//电话
			
			Centre centre=new Centre(fre_number,transferStation,transferCheck,receiveBillTime,receiveBillPerson
					,transferCompany,transferStationTel);
			int count=cdil.add_Centre(centre);
			//保存之后进行状态的修改
			int transit=mdil.update_mod(fre_number, "已中转");
			//然后跳转到中转运单的查询
	   	    req.getRequestDispatcher("modeServlet?oper=query_interim").forward(req, resp);
		}else if(oper.equals("query")) {
			//进行已近中转的订单历史查询
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//转换为int类型
			int totalCount=cdil.getCentre();//获得总记录数
			CentrePage pages=new CentrePage();
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
		    List<Centre> clList=biz.pageQueryCentre(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListCentre(clList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/transit/transfer/history.jsp").forward(req, resp);
		}else if(oper.equals("query_place")) {
			//进行需要结算的订单查询
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//转换为int类型
			int totalCount=cdil.getPlace();//获得总记录数
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
		    List<Place> placeist=biz.pageQueryPlace(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListPlace(placeist);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/settle/goodsBill/goodsBill.jsp").forward(req, resp);
		}else if(oper.equals("query_phone")) {
				String number=req.getParameter("phone");
				
				String pageIndex= req.getParameter("pageNo");//获得当前页数
			    if(pageIndex== null){
			        pageIndex= "1";
			    }
			    int currPageNo = Integer.parseInt(pageIndex);//转换为int类型
				int totalCount=cdil.getCentre();//获得总记录数
				CentrePage pages=new CentrePage();
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
			    List<Centre> clList=biz.pageQueryCentre(pages.getCurrPageNo(), pages.getPageSize(),number);
			   		pages.setListCentre(clList);  //设置每页显示的集合
			   	    req.setAttribute("pages", pages);
			   	    req.getRequestDispatcher("backstage/jsp/transit/transfer/history.jsp").forward(req, resp);
		}else if(oper.equals("query_phon")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//转换为int类型
			int totalCount=cdil.getPlace();//获得总记录数
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
		    List<Place> placeist=biz.pageQueryPlace(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListPlace(placeist);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/settle/goodsBill/goodsBill.jsp").forward(req, resp);
		}
	}
}	
