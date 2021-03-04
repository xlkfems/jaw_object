package cn.com.relife.connetor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.com.relife.biz.BillBiz;
import cn.com.relife.biz.MakeBiz;
import cn.com.relife.entity.Bill;
import cn.com.relife.entity.BillPage;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.MakePage;
import cn.com.relife.entity.Place;
import cn.com.relife.entity.PlacePage;
import cn.com.relife.impl.BillDaoImpl;
import cn.com.relife.impl.MakeDaoImpl;

public class BillServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//编码处理
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//接收逻辑操作参数
		MakeDaoImpl mdil=new MakeDaoImpl();
		BillDaoImpl bdil=new BillDaoImpl();
		MakeBiz biz=new MakeBiz();
		BillBiz billbiz=new BillBiz();
		List<Driver> driverList = new ArrayList<Driver>();
		if(oper.equals("distribute")) {//票据分发
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int MakeCount=mdil.getMake();//获得总记录数
			MakePage pages=new MakePage();
			pages.setPageSize(8);    //设置每页条数
			pages.setTotalCount(MakeCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Make> newsList=biz.pageQueryMake(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListMake(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/bill/distribute/bill_distribute.jsp").forward(req, resp);
		}else if(oper.equals("query_bill")) {
			String number=req.getParameter("number");
			Make make=biz.queryMake(number);
			String name=make.getMake();
			name=name.substring(0,5);
			driverList=billbiz.query_driver(name);
			
			req.setAttribute("driverList", driverList);
			req.setAttribute("make", make);
			req.getRequestDispatcher("backstage/jsp/bill/distribute/bill_out.jsp").forward(req, resp);
		}else if(oper.equals("query")) {
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int BillCount=bdil.getBill();//获得总记录数
			BillPage pages=new BillPage();
			pages.setPageSize(8);    //设置每页条数
			pages.setTotalCount(BillCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Bill> newsList=billbiz.QueryBill(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListBill(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/bill/distribute/bill_demo.jsp").forward(req, resp);
		}else if(oper.equals("addbill")) {
			String br_distribute=req.getParameter("dispense");//分发人
			String br_number=req.getParameter("receiveBillPerson");//领票人
			String br_state=req.getParameter("receiveBillTime");//领票时间
			String make_cargo=req.getParameter("acceptStation");//接货点
			String state="待配车";//状态
			String number=req.getParameter("number");//
			Make make=biz.queryMake(number);
			String make_time=make.getMake_time();//填票时间
			Bill bill=new Bill(number,make_time,br_state,br_number,make_cargo,br_distribute,state);
			int count=billbiz.add_Bill(bill);
			if(count>0) {
				System.out.println("新增成功");
				//执行状态修改方法,修改接货单状态
				int counts=billbiz.update_bill(number);
				//执行司机状态修改
				int message=billbiz.update_driver(br_number);
			}
			req.getRequestDispatcher("billServlet?oper=distribute").forward(req, resp);
			
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int BillCount=bdil.getBill();//获得总记录数
			BillPage pages=new BillPage();
			pages.setPageSize(8);    //设置每页条数
			pages.setTotalCount(BillCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Bill> newsList=billbiz.pageQueryBill(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListBill(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/bill/distribute/bill_demo.jsp").forward(req, resp);
		}
	}
}
