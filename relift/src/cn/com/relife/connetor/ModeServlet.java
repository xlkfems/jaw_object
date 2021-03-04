package cn.com.relife.connetor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.ModeBiz;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.MakePage;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.ModePage;
import cn.com.relife.entity.Nmsl;
import cn.com.relife.entity.Transfer;
import cn.com.relife.impl.ModeDaoImpl;
import cn.com.relife.impl.NmslDaoImpl;
import cn.com.relife.impl.PlaneDaoImpl;

public class ModeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//编码处理
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//接收逻辑操作参数
		ModeDaoImpl mdil=new ModeDaoImpl();
		ModeBiz modebiz=new ModeBiz();
		
		if(oper.equals("query")) {
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int ModeCount=mdil.getMode();//获得总记录数
			ModePage pages=new ModePage();
			pages.setPageSize(8);    //设置每页条数
			pages.setTotalCount(ModeCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Mode> newsList=modebiz.pageQueryMode(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListMode(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/carriage/state/status.jsp").forward(req, resp);
		}else if(oper.equals("transfer")) {
			String number=req.getParameter("number");
			NmslDaoImpl ndil=new NmslDaoImpl();
			Nmsl nmsl=ndil.query(1);
			req.setAttribute("nmsl",nmsl);
			
			req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
		}else if(oper.equals("update")) {
			String city=req.getParameter("city");//编号
			String number=req.getParameter("number");//状态
			String weizhi=req.getParameter("weizhi");//状态
			
			req.setAttribute("number", number);
			req.setAttribute("city", city);
			req.setAttribute("weizhi", weizhi);
			req.getRequestDispatcher("backstage/jsp/carriage/state/mode.jsp").forward(req, resp);
			
		}else if(oper.equals("update_mode")) {
			String number=req.getParameter("number");//编号
			String acceptStation=req.getParameter("acceptStation");//编号
			Mode mod=mdil.query_mode(number);
			mdil.update_mode(number,acceptStation);
			
			PlaneDaoImpl pdil=new PlaneDaoImpl();
			
			if(acceptStation.equals(mod.getMake_receipt())) {
				pdil.update_place(number, "已送达");
			}else {
				pdil.update_place(number, "运输中");
				mdil.update_mod(number, "运输中");
			}
			String city=req.getParameter("dispense");//编号
			String weizhi=req.getParameter("acceptStation");//状态
			
			req.setAttribute("number", number);
			req.setAttribute("city", city);
			req.setAttribute("weizhi", weizhi);
			req.getRequestDispatcher("modeServlet?oper=query").forward(req, resp);
		}else if(oper.equals("update_nmsl")) {
			NmslDaoImpl ndil=new NmslDaoImpl();
			Nmsl nmsl=ndil.query(1);
			String name=nmsl.getLocation();
			if(name.equals("湖南")) {
				System.out.println("执行");
				Nmsl nb=new Nmsl("武汉",113.09564,30.37214,"已到达武汉,正在发往郑州");
				ndil.update(nb);
				
				Nmsl nms=ndil.query(1);
				req.setAttribute("nmsl",nms);
				
				req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
			}else if(nmsl.getLocation().equals("武汉")) {
				Nmsl nb=new Nmsl("郑州",114.50465,34.84645,"已到达郑州,正在发往石家庄");
				ndil.update(nb);
				Nmsl nms=ndil.query(1);
				req.setAttribute("nmsl",nms);
				req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
			}else if(nmsl.getLocation().equals("郑州")) {
				Nmsl nb=new Nmsl("石家庄",115.64358,38.10680,"已到达石家庄,正在发往北京");
				ndil.update(nb);
				Nmsl nms=ndil.query(1);
				req.setAttribute("nmsl",nms);
				req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
			}else if(nmsl.getLocation().equals("石家庄")) {
				Nmsl nb=new Nmsl("北京",116.41667,39.91667,"货物已送达");
				ndil.update(nb);
				Nmsl nms=ndil.query(1);
				req.setAttribute("nmsl",nms);
				req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
			}else if(nmsl.getLocation().equals("北京")) {
				Nmsl nb=new Nmsl("湖南",113.00001,28.21667,"已发车");
				ndil.update(nb);
				Nmsl nms=ndil.query(1);
				req.setAttribute("nmsl",nms);
				req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
			}
			
		}else if(oper.equals("query_interim")) {
			//进行中转运单的查询
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int ModeCount=mdil.getQuery();//获得总记录数
			ModePage pages=new ModePage();
			pages.setPageSize(8);    //设置每页条数
			pages.setTotalCount(ModeCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Mode> newsList=modebiz.QueryMode(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListMode(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/transit/transfer/transfer.jsp").forward(req, resp);
		}else if(oper.equals("query_centre")) {
			//详细查询中转订单的信息
			String number=req.getParameter("number");
			Mode modes=mdil.query_mode(number);
			req.setAttribute("number", number);
			req.setAttribute("modes", modes);
			
			String name=modes.getLocation();
			List<Transfer> trs=mdil.Query_Transfer(name);
			req.setAttribute("trs", trs);
	   	    req.getRequestDispatcher("backstage/jsp/transit/transfer/add_transfer.jsp").forward(req, resp);
		}else if(oper.equals("query_trark")) {
			//查询相对应的中转站的信息
			PrintWriter out=resp.getWriter();//多去打印对象
			String tr_name=req.getParameter("tr_name");
			
			Transfer transfer =mdil.query_Tra(tr_name);
			String tr_address=transfer.getTr_address()+",";
			String tr_phone=transfer.getTr_phone()+",";
			
			String msg=null;
			msg=tr_address;
			out.write(msg);
			msg=tr_phone;
			out.write(msg);
			out.close();
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int ModeCount=mdil.getMode();//获得总记录数
			ModePage pages=new ModePage();
			pages.setPageSize(8);    //设置每页条数
			pages.setTotalCount(ModeCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Mode> newsList=modebiz.pageQueryMode(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListMode(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/carriage/state/status.jsp").forward(req, resp);
		}else if(oper.equals("query_phon")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int ModeCount=mdil.getQuery();//获得总记录数
			ModePage pages=new ModePage();
			pages.setPageSize(8);    //设置每页条数
			pages.setTotalCount(ModeCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Mode> newsList=modebiz.QueryMode(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListMode(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/transit/transfer/transfer.jsp").forward(req, resp);
		}
	}
}
