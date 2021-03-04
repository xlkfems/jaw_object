package cn.com.relife.connetor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.DriverBiz;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.DriverPage;
import cn.com.relife.impl.DriverDaoImpl;
/**
 * @remark 司机控制层
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */

public class DriverServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getContextPath();
		   
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" +     
	    req.getServerPort() + path + "/";
		
		req.setCharacterEncoding("utf-8");//编码处理
		String oper=req.getParameter("oper");//接收逻辑操作参数
		DriverDaoImpl tdil=new DriverDaoImpl();//实例化impl
		DriverBiz biz=new DriverBiz();//实例化biz
		//定义打印输出对象，将后台服务器处理后的结果响应到客户端页面上
		//PrintWriter out=resp.getWriter();
		//定义接收结果变量
		//String msg=null;
		
		if(oper.equals("all")) {
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//转换为int类型
			int totalCount=tdil.getTotalCount();//获得总记录数
			DriverPage pages=new DriverPage();
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
		    List<Driver> driverList=biz.pageDriverAll(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListDriver(driverList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/application/driver/driver.jsp").forward(req, resp);
			}else
		if(oper.equals("add")){
			//随机数产生的编号
			String dr_number = ("SJ"+String.valueOf(Math.round((100000+Math.random()*100000))));
			 //int dr_id = Integer.parseInt(req.getParameter("id"));//司机id
			 String dr_name = req.getParameter("driverName");//司机姓名
			 String dr_identity = req.getParameter("idCard");;//司机身份证
			 String dr_phone = req.getParameter("phone");;//司机电话
			 String dr_sex = req.getParameter("gender");;//司机性别
			 String dr_hoday = req.getParameter("birthday");;//司机生日
			 String dr_car = req.getParameter("carNo");;//车号
			 String dr_state = req.getParameter("carType");;//车型
			 String dr_volume = req.getParameter("allowCarryVolume");;//准载体积
			 String dr_load = req.getParameter("allowCarryWeight");;//准载重量
			 String dr_address = req.getParameter("address");;//住址
			 String dr_long = req.getParameter("carLength");;//车辆长度
			 String dr_width = req.getParameter("carWidth");;//车辆宽度
			 String dr_length = req.getParameter("goodsHeight");;//载物高度
			 String dr_licence = req.getParameter("driveLicence");;//驾驶证
			 String dr_xing = req.getParameter("runLicence");;//行驶证
			 String dr_run = req.getParameter("bizLicence");;//运营证
			 String dr_vin = req.getParameter("carFrameNo");;//车架号
			 dr_vin="空闲";
			 String dr_unit = req.getParameter("carDept");;//车属单位
			 String unit_phone = req.getParameter("carDeptTel");;//单位号码
			 String dr_company = req.getParameter("companyCar");;//公司车
			 String dr_remark = req.getParameter("remark");;//备注
			//实例化用户信息类
			Driver driver = new Driver(dr_number,dr_name, dr_identity, dr_phone, dr_sex, dr_hoday
					, dr_car, dr_state, dr_volume, dr_load, dr_address, dr_long, dr_width
					, dr_length, dr_licence, dr_xing, dr_run, dr_vin, dr_unit, unit_phone
					, dr_company, dr_remark);
			int result = biz.addDriver(driver);
			if(result>0) {
				//执行分页
				String pageIndex= req.getParameter("pageNo");//获得当前页数
			    if(pageIndex== null){
			        pageIndex= "1";
			    }
			    int currPageNo = Integer.parseInt(pageIndex);
				int totalCount=tdil.getTotalCount();//获得总记录数
				DriverPage pages=new DriverPage();
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
			    List<Driver> newsList=biz.pageDriverAll(pages.getCurrPageNo(), pages.getPageSize());
			   		pages.setListDriver(newsList); //设置每页显示的集合
			   	    req.setAttribute("pages", pages);
			   	    req.getRequestDispatcher("backstage/jsp/application/driver/driver.jsp").forward(req, resp);
				}
			}else if(oper.equals("one")) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			Driver driver = biz.queryOne(id);
			req.setAttribute("driver", driver);
			req.getRequestDispatcher("backstage/jsp/application/driver/dr_query.jsp").forward(req, resp);
			
		}else if(oper.equals("ones")) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			Driver driver = biz.queryOne(id);
			req.setAttribute("driver", driver);
			req.getRequestDispatcher("backstage/jsp/application/driver/dr_update.jsp").forward(req, resp);
		}
			else if(oper.equals("upda")) {
			 int dr_id = Integer.parseInt(req.getParameter("id"));//司机id
			 String dr_name = req.getParameter("driverName");//司机姓名
			 String dr_identity = req.getParameter("idCard");;//司机身份证
			 String dr_phone = req.getParameter("phone");;//司机电话
			 String dr_sex = req.getParameter("gender");;//司机性别
			 String dr_hoday = req.getParameter("birthday");;//司机生日
			 String dr_car = req.getParameter("carNo");;//车号
			 String dr_state = req.getParameter("carType");;//车型
			 String dr_volume = req.getParameter("allowCarryVolume");;//准载体积
			 String dr_load = req.getParameter("allowCarryWeight");;//准载重量
			 String dr_address = req.getParameter("address");;//住址
			 String dr_long = req.getParameter("carLength");;//车辆长度
			 String dr_width = req.getParameter("carWidth");;//车辆宽度
			 String dr_length = req.getParameter("goodsHeight");;//载物高度
			 String dr_licence = req.getParameter("driveLicence");;//驾驶证
			 String dr_xing = req.getParameter("runLicence");;//行驶证
			 String dr_run = req.getParameter("bizLicence");;//运营证
			 String dr_vin = req.getParameter("carFrameNo");;//车架号
			 String dr_unit = req.getParameter("carDept");;//车属单位
			 String unit_phone = req.getParameter("carDeptTel");;//单位号码
			 String dr_company = req.getParameter("companyCar");;//公司车
			 String dr_remark = req.getParameter("remark");;//备注
			//实例化用户信息类
			Driver driver = new Driver(dr_name, dr_identity, dr_phone, dr_sex, dr_hoday
					, dr_car, dr_state, dr_volume, dr_load, dr_address, dr_long, dr_width
					, dr_length, dr_licence, dr_xing, dr_run, dr_vin, dr_unit, unit_phone
					, dr_company, dr_remark,dr_id);
			int result = biz.updDriver(driver);
			if(result>0) {
				req.getRequestDispatcher("DriverServlet?oper=all").forward(req, resp);
			}
		}else
		if(oper.equals("del")) {
			//获取属性
			int id = Integer.parseInt(req.getParameter("id"));
			//调用删除方法
			int result = biz.delDriver(id);
			if(result>0) {
				//调用查询全部的方法
				System.out.println("servlet:删除司机信息成功");
			   	req.getRequestDispatcher("DriverServlet?oper=all").forward(req, resp);
			}else {
				System.out.println("删除司机信息失败");
			}
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//转换为int类型
			int totalCount=tdil.getTotalCount();//获得总记录数
			DriverPage pages=new DriverPage();
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
		    List<Driver> driverList=biz.pageDriverAll(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListDriver(driverList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/application/driver/driver.jsp").forward(req, resp);
		}
	}
}
