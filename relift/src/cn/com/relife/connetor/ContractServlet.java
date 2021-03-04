package cn.com.relife.connetor;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.ContractBiz;
import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Contract;
import cn.com.relife.entity.ContractPage;
import cn.com.relife.entity.DateTime;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.MakePage;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Place;
import cn.com.relife.impl.ContractDaoImpl;
import cn.com.relife.impl.ModeDaoImpl;
/**
 * @remark 运输管理控制层
 * @author 随便
 * @createTime 10点45分
 * version 1.0 
 */
public class ContractServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//编码处理
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//接收逻辑操作参数
		ContractBiz contbiz=new ContractBiz();
		List<Bill> billList = new ArrayList<Bill>();
		ContractDaoImpl contra=new ContractDaoImpl();
		
		if(oper.equals("query_bill")) {
			//查询所有已经填写完成的票据信息，显示在下拉列表中
			billList=contbiz.query_bill();
			req.setAttribute("billList", billList);
			req.getRequestDispatcher("backstage/jsp/vehicleControl/edit/edit.jsp").forward(req, resp);
		}else if(oper.equals("con_query")) {
			//使用ajax进行无刷新自动显示信息
			String msg=null;
			String number=req.getParameter("number");//获取页面下拉列表的编号信息
			Make make=contbiz.query_make(number);//将获取到的编号进行相对应的接货单信息的查询
			req.setAttribute("make", make);
			String cargo=make.getMake()+",";//发货地
			String delivery=make.getMake_receipt()+",";//收货点
			String take_name=make.getTake_Name()+",";//收货人
			String take_phone=make.getTake_phone()+",";//收货电话
			String take_site=make.getTake_site()+", ";//收货地址
			String time=make.getMake_time()+",";//填写日期
			//将信息使用逗号隔开如何进行分隔符处理
			PrintWriter out=resp.getWriter();//多去打印对象
			//更具距离判断预计到达时间
			String make_cargo=make.getMake().substring(0,3);//收货地信息计算
			String make_delivery=make.getMake_receipt().substring(0,3);//发货地信息计算
			int scheduled=0;
			//每个省预计到达的日期
			if(make_cargo.equals("湖南省")&&make_delivery.equals("湖南省")) {
				scheduled=1;
			}else if(make_cargo.equals("湖南省")&&make_delivery.equals("湖北省") || make_cargo.equals("湖南省")&&make_delivery.equals("江西省")) {
				scheduled=2;
			}else if(make_cargo.equals("湖南省")&&make_delivery.equals("广东省") || make_cargo.equals("湖南省")&&make_delivery.equals("安徽省")) {
				scheduled=3;
			}else if(make_cargo.equals("湖南省")&&make_delivery.equals("陕西省") || make_cargo.equals("湖南省")&&make_delivery.equals("江苏省") || make_cargo.equals("湖南省")&&make_delivery.equals("浙江省")
					|| make_cargo.equals("湖南省")&&make_delivery.equals("福建省") || make_cargo.equals("湖南省")&&make_delivery.equals("贵州省")
					) {
				scheduled=4;
			}else if(make_cargo.equals("湖南省")&&make_delivery.equals("四川省") || make_cargo.equals("湖南省")&&make_delivery.equals("河北省") || make_cargo.equals("湖南省")&&make_delivery.equals("山东省")
					|| make_cargo.equals("湖南省")&&make_delivery.equals("海南省")
					) {
				scheduled=5;
			}else if(make_cargo.equals("湖南省")&&make_delivery.equals("云南省") || make_cargo.equals("湖南省")&&make_delivery.equals("河南省") || make_cargo.equals("湖南省")&&make_delivery.equals("北京市")) {
				scheduled=6;
			}else if(make_cargo.equals("湖南省")&&make_delivery.equals("内蒙古") || make_cargo.equals("湖南省")&&make_delivery.equals("甘肃省")) {
				scheduled=7;
			}else if(make_cargo.equals("湖南省")&&make_delivery.equals("山西省")) {
				scheduled=9;
			}else if(make_cargo.equals("湖南省")&&make_delivery.equals("吉林省")) {
				scheduled=10;
			}else if(make_cargo.equals("湖南省")&&make_delivery.equals("黑龙江")) {
				scheduled=11;
			}
			//使用日期转换进行处理
			DateTime datetime=new DateTime();//实例化创建时间对象
			String expect=datetime.getDateStr(make.getMake_time(),scheduled)+",";//进行时间转换处理
			//查询票据相对应的司机编号
			Bill bill_number=contbiz.query_Bill(number);
			req.setAttribute("bill_number", bill_number);//放入
			String dr_sj=bill_number.getBi_driver()+",";//获取司机编号
			String remark=make.getRemark()+",";//备注
			String moneystate=make.getMoneystate()+",";//付款方式
			String make_freight=make.getMake_freight();//运费
			//将其一个一个进行存入
			msg=cargo;
			out.write(msg);
			msg=delivery;
			out.write(msg);
			msg=take_name;
			out.write(msg);
			msg=take_phone;
			out.write(msg);
			msg=take_site;
			out.write(msg);
			msg=time;
			out.write(msg);
			msg=expect;
			out.write(msg);
			msg=dr_sj;
			out.write(msg);
			msg=remark;
			out.write(msg);
			msg=moneystate;
			out.write(msg);
			msg=make_freight;
			out.write(msg);
			//关闭输出流对象
			out.close();
		}else if(oper.equals("qurey_edit")) {
			//进行运输单的新增
			String number=req.getParameter("goodsRevertBillCode");//订单编号
			String cargo=req.getParameter("cargo");//装货地点
			String startCarryTime=req.getParameter("startCarryTime");//起运时间
			String delivery=req.getParameter("delivery");//交货地点
			String receiveGoodsLinkman=req.getParameter("receiveGoodsLinkman");//收货联系人
			String linkmanPhone=req.getParameter("linkmanPhone");//联系人电话
			String receiveGoodsDetailAddr=req.getParameter("receiveGoodsDetailAddr");//收货详细地址
			String carriageBanlanceMode=req.getParameter("carriageBanlanceMode");//运费结算方式
			String remark=req.getParameter("remark");//备注
			String driverId=req.getParameter("driverId");//司机编号
			String signTime=req.getParameter("signTime");//签订时间
			String allCarriage=req.getParameter("allCarriage");//总运费
			String backBillState=req.getParameter("backBillState");//状态
			//实例化创建运输对象，将数据添加进去
			Contract contract=new Contract(number,delivery,cargo,startCarryTime,receiveGoodsLinkman,linkmanPhone,receiveGoodsDetailAddr,
					carriageBanlanceMode,remark,driverId,signTime,allCarriage,backBillState);
			int count=contbiz.add_edit(contract);//运输单的新增处理
			if(count>0) {
				//如果新增成功之后，司机正式上路，将其将订单状态改为运输中
				String state="运输中";//新增运输状态
				String location=cargo;//当前位置
				Mode mode=new Mode(number,driverId,delivery,cargo,state,location);//实例化创建运输类
				ModeDaoImpl mdis= new ModeDaoImpl();//实例化运输实现类进行新增
				mdis.add_mode(mode);//运输单的新增
				int dcide=contbiz.update(number);//修改订单状态
				req.getRequestDispatcher("backstage/jsp/vehicleControl/edit/edit.jsp").forward(req, resp);
			}
		}else if(oper.equals("query_contra")) {
			//进行运输订单的分页处理
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//将当前页面进行数据转换
			int ContraCount=contra.getContract();//获得总记录数
			ContractPage pages=new ContractPage();//实例化创建分页对象
			pages.setPageSize(8);    //设置每页条数
			pages.setTotalCount(ContraCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Contract> newsList=contbiz.pageQueryContract(pages.getCurrPageNo(), pages.getPageSize());
		    	pages.setListContract(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/vehicleControl/select/select.jsp").forward(req, resp);
		}else if(oper.equals("contract_query")) {
			//进行运输单详情的查询
			String number=req.getParameter("number");//获取货运编号
			Contract contract=contbiz.query_Contract(number);
			req.setAttribute("contract", contract);
			req.getRequestDispatcher("backstage/jsp/vehicleControl/select/query_select.jsp").forward(req, resp);
		}else if(oper.equals("update_contract")) {
			//进行运输单的查询
			String number=req.getParameter("number");//与上方相同，主要是要分出二个方法转发的页面皆不同
			Contract contract=contbiz.query_Contract(number);
			req.setAttribute("contract", contract);
			req.getRequestDispatcher("backstage/jsp/vehicleControl/select/update_select.jsp").forward(req, resp);
		}else if(oper.equals("update_alter")){
			//修改其运输订单的内容
			String number=req.getParameter("goodsRevertBillCode");//获取订单编号
			String loadStation=req.getParameter("loadStation");//获取发货地
			String dealGoodsStation=req.getParameter("dealGoodsStation");//获取收货地
			String allCarriage=req.getParameter("allCarriage");//获取订单状态
			
			int count=contbiz.update_alter(number, loadStation, dealGoodsStation, allCarriage);//进行其运输状态的填写
			Contract contract=contbiz.query_Contract(number);//查询所有运输合同
			req.setAttribute("contract", contract);
			req.getRequestDispatcher("backstage/jsp/vehicleControl/select/update_select.jsp").forward(req, resp);
		}else if(oper.equals("query_phone")) {
			//进行搜索框的查询
			String number=req.getParameter("phone");//获取其页面的编号
			//下面再次执行分页查询
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int ContraCount=contra.getContract();//获得总记录数
			ContractPage pages=new ContractPage();
			pages.setPageSize(8);    //设置每页条数
			pages.setTotalCount(ContraCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Contract> newsList=contbiz.pageQueryContract(pages.getCurrPageNo(), pages.getPageSize(),number);
		    	pages.setListContract(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/vehicleControl/select/select.jsp").forward(req, resp);
		}
	}
}
