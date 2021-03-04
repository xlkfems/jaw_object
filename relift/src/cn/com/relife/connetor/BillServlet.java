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
		req.setCharacterEncoding("utf-8");//���봦��
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//�����߼���������
		MakeDaoImpl mdil=new MakeDaoImpl();
		BillDaoImpl bdil=new BillDaoImpl();
		MakeBiz biz=new MakeBiz();
		BillBiz billbiz=new BillBiz();
		List<Driver> driverList = new ArrayList<Driver>();
		if(oper.equals("distribute")) {//Ʊ�ݷַ�
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int MakeCount=mdil.getMake();//����ܼ�¼��
			MakePage pages=new MakePage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(MakeCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Make> newsList=biz.pageQueryMake(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListMake(newsList);  //����ÿҳ��ʾ�ļ���
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
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int BillCount=bdil.getBill();//����ܼ�¼��
			BillPage pages=new BillPage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(BillCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Bill> newsList=billbiz.QueryBill(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListBill(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/bill/distribute/bill_demo.jsp").forward(req, resp);
		}else if(oper.equals("addbill")) {
			String br_distribute=req.getParameter("dispense");//�ַ���
			String br_number=req.getParameter("receiveBillPerson");//��Ʊ��
			String br_state=req.getParameter("receiveBillTime");//��Ʊʱ��
			String make_cargo=req.getParameter("acceptStation");//�ӻ���
			String state="���䳵";//״̬
			String number=req.getParameter("number");//
			Make make=biz.queryMake(number);
			String make_time=make.getMake_time();//��Ʊʱ��
			Bill bill=new Bill(number,make_time,br_state,br_number,make_cargo,br_distribute,state);
			int count=billbiz.add_Bill(bill);
			if(count>0) {
				System.out.println("�����ɹ�");
				//ִ��״̬�޸ķ���,�޸Ľӻ���״̬
				int counts=billbiz.update_bill(number);
				//ִ��˾��״̬�޸�
				int message=billbiz.update_driver(br_number);
			}
			req.getRequestDispatcher("billServlet?oper=distribute").forward(req, resp);
			
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int BillCount=bdil.getBill();//����ܼ�¼��
			BillPage pages=new BillPage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(BillCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Bill> newsList=billbiz.pageQueryBill(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListBill(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/bill/distribute/bill_demo.jsp").forward(req, resp);
		}
	}
}
