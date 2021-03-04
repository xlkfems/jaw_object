 package cn.com.relife.connetor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.MakeBiz;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.MakePage;
import cn.com.relife.entity.Place;
import cn.com.relife.entity.Transfer;
import cn.com.relife.entity.TransferPage;
import cn.com.relife.impl.MakeDaoImpl;
/**
 * @remark 票据
 * @author 随便
 * @createTime 00点37分
 * @version 1.0
 */
public class MakeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//编码处理
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//接收逻辑操作参数
		MakeDaoImpl mdil=new MakeDaoImpl();
		MakeBiz biz=new MakeBiz();
		List<Place> placeList = new ArrayList<Place>();
		if(oper.equals("inquire")) {
			placeList=biz.query_userInfo();
			req.setAttribute("placeList", placeList);
			req.getRequestDispatcher("backstage/jsp/cargo/addinvoice/addinvoice.jsp").forward(req, resp);
		}else if(oper.equals("query")) {
			PrintWriter out=resp.getWriter();//多去打印对象
			req.setCharacterEncoding("utf-8");//编码处理
			String  number=req.getParameter("number");
			Place query_place=biz.query_userInfo(number);
			req.setAttribute("query_place", query_place);
			//获取到各个位置的值,利用分割显示
			String a_name=query_place.getA_name()+",";
			String a_phone=query_place.getA_phone()+",";
			String a_address_block=query_place.getA_address_block()+",";
			String m_name=query_place.getM_name()+",";
			String m_phone=query_place.getM_phone()+",";
			String m_address_block=query_place.getM_address_block()+",";
			String piece=query_place.getPiece()+",";//件数
			String cost=query_place.getInsuredPrice();//保价
			int money = Integer.parseInt(cost);
			money=(int) (money*0.003);
			String cost_money=Integer.toString(money);
			cost_money=cost_money+",";
			String weight=query_place.getWeight()+",";//体积
			String acceptStation=query_place.getState()+",";
			String pick=query_place.getPick()+",";
			String pl_money=query_place.getPl_money()+",";
			String remark=query_place.getRemark();
			
			//写入对象中
			String msg=null;
			msg=a_name;
			out.write(msg);
			msg=a_phone;
			out.write(msg);
			msg=a_address_block;
			out.write(msg);
			msg=m_name;
			out.write(msg);
			msg=m_phone;
			out.write(msg);
			msg=m_address_block;
			out.write(msg);
			msg=piece;//件数
			out.write(msg);
			msg=cost_money;//保价
			out.write(msg);
			msg=weight;//体积
			out.write(msg);
			msg=acceptStation;
			out.write(msg);
			msg=pick;
			out.write(msg);
			msg=pl_money;
			out.write(msg);
			msg=remark;
			out.write(msg);
			//关闭输出流对象
			out.close();
		}else if(oper.equals("add")) {
			String a_name=req.getParameter("a_name");
			String a_phone=req.getParameter("a_phone");
			String a_address_block=req.getParameter("a_address_block");
			String m_name=req.getParameter("m_name");
			String m_phone=req.getParameter("m_phone");
			String m_address_block=req.getParameter("m_address_block");
			String consignment=req.getParameter("consignment");//发货地址
			String delivery=req.getParameter("delivery");//收货地址
			String payMode=req.getParameter("payMode");//付款方式
			String fetchGoodsMode=req.getParameter("fetchGoodsMode");//取货方式
			String writeBillPerson=req.getParameter("writeBillPerson");//填票人
			String writeDate=req.getParameter("writeDate");//填票日期
			String transferStation=req.getParameter("transferStation");//中转地
			String transferFee=req.getParameter("transferFee");//中转费
			String carriage=req.getParameter("carriage");//运费
			String employeeCode="admin";//职员编号
			String remark=req.getParameter("remark");//备注
			String piece=req.getParameter("piece");//件数
			String bulk=req.getParameter("bulk");//总体积
			String sendGoodsDate=req.getParameter("sendGoodsDate");//发货日期
			String support=req.getParameter("support");//保价费
			String acceptStation=req.getParameter("acceptStation");//状态
			
			
			acceptStation="待发";
			String number=req.getParameter("send_place");//编号
			if(transferStation=="") {
				transferStation="直达";
				transferFee="0";
			}
			Make make=new Make(sendGoodsDate,payMode,fetchGoodsMode,writeBillPerson,writeDate,
					transferStation,transferFee,carriage,remark,delivery,consignment,m_name,m_phone,m_address_block
					,a_name,a_phone,a_address_block,number,piece,bulk,support,employeeCode,acceptStation);
			int result=biz.addMake(make);//新增
			
			int count=biz.update(number);//修改状态
			if(result>0 && count>0) {
				System.out.println("成功");
				req.getRequestDispatcher("backstage/jsp/cargo/addinvoice/addinvoice.jsp").forward(req, resp);
			}
		}else if(oper.equals("committed")) {
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
		   	    req.getRequestDispatcher("backstage/jsp/cargo/queryinvoice/queryinvoice.jsp").forward(req, resp);
		}else if(oper.equals("Queryfreight")) {
			String number=req.getParameter("number");
			Make make=biz.queryMake(number);
			req.setAttribute("make", make);
			req.getRequestDispatcher("backstage/jsp/cargo/queryinvoice/query_invoice.jsp").forward(req, resp);
		}else if(oper.equals("update_incoice")) {
			String number=req.getParameter("number");
			Make make=biz.queryMake(number);
			req.setAttribute("make", make);
			req.getRequestDispatcher("backstage/jsp/cargo/queryinvoice/update_incoice.jsp").forward(req, resp);
		}else if(oper.equals("update_make")) {
			String number=req.getParameter("sendGoodsCustomerNo");
			String makes=req.getParameter("sendGoodsAddr");
			String make_receipt=req.getParameter("receiveGoodsAddr");
			String make_freight=req.getParameter("carriage");
			int count=biz.update_Make(number, makes, make_receipt, make_freight);
			
			Make make=biz.queryMake(number);
			req.setAttribute("make", make);
			req.getRequestDispatcher("backstage/jsp/cargo/queryinvoice/update_incoice.jsp").forward(req, resp);
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			
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
		    List<Make> newsList=biz.pageQueryMake(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListMake(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/cargo/queryinvoice/queryinvoice.jsp").forward(req, resp);
		}
	}
}
