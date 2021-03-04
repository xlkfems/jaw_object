package cn.com.relife.connetor;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.ClientBiz;
import cn.com.relife.entity.Client;
import cn.com.relife.entity.ClientPage;
import cn.com.relife.impl.ClientDaoImpl;
/**
 * @remark 客户控制层
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public class ClientServlet extends HttpServlet{
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getContextPath();
	   
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" +     
	    req.getServerPort() + path + "/";
		
		req.setCharacterEncoding("utf-8");//编码处理
		String oper=req.getParameter("oper");//接收逻辑操作参数
		ClientDaoImpl tdil=new ClientDaoImpl();//实例化impl
		ClientBiz biz=new ClientBiz();//实例化biz
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
			ClientPage pages=new ClientPage();
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
		    List<Client> cliList=biz.pageClientAll(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListClient(cliList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/application/customer/customer.jsp").forward(req, resp);
			}else
		if(oper.equals("add")){
			//随机数产生的编号
			String number = ("KH"+String.valueOf(Math.round((100000+Math.random()*100000))));
			String name = req.getParameter("customer");
			String phone = req.getParameter("phone");
			String fax = req.getParameter("fax");
			String postcode = req.getParameter("postCode");
			String address = req.getParameter("address");//地址
			String contact = req.getParameter("linkman");//联系人
			String conphone = req.getParameter("linkmanMobile");//练习人手机
			String usertype = req.getParameter("customerType");//客户类型
			String enterprise = req.getParameter("enterpriseProperty");//企业性质
			String scale = req.getParameter("enterpriseSize");//企业规模
			String email = req.getParameter("email");//邮箱
			//实例化用户信息类
			Client entity = new Client(number,name, phone, fax, postcode, address,
					contact, conphone, usertype, enterprise, scale, email);
			
			int result = biz.addClient(entity);
			if(result>0) {
				//执行分页
				String pageIndex= req.getParameter("pageNo");//获得当前页数
			    if(pageIndex== null){
			        pageIndex= "1";
			    }
			    int currPageNo = Integer.parseInt(pageIndex);
				int totalCount=tdil.getTotalCount();//获得总记录数
				ClientPage pages=new ClientPage();
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
			    List<Client> newsList=biz.pageClientAll(pages.getCurrPageNo(), pages.getPageSize());
			   		pages.setListClient(newsList); //设置每页显示的集合
			   	    req.setAttribute("pages", pages);
			   	    req.getRequestDispatcher("backstage/jsp/application/customer/customer.jsp").forward(req, resp);
				}
			}else				
			if(oper.equals("one")) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			Client  client = biz.queryOne(id);
			req.setAttribute("client", client);
			req.getRequestDispatcher("backstage/jsp/application/customer/cus_query.jsp").forward(req, resp);
		}else if(oper.equals("ones")){
			int id = Integer.parseInt(req.getParameter("id"));
			Client  client = biz.queryOne(id);
			req.setAttribute("client", client);
			req.getRequestDispatcher("backstage/jsp/application/customer/cus_update.jsp").forward(req, resp);
		}else if(oper.equals("upda")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("customer");
			String phone = req.getParameter("phone");
			String fax = req.getParameter("fax");
			String postcode = req.getParameter("postCode");
			String address = req.getParameter("address");//地址
			String contact = req.getParameter("linkman");//联系人
			String conphone = req.getParameter("linkmanMobile");//练习人手机
			String usertype = req.getParameter("customerType");//客户类型
			String enterprise = req.getParameter("enterpriseProperty");//企业性质
			String scale = req.getParameter("enterpriseSize");//企业规模
			String email = req.getParameter("email");//邮箱
			Client cl = new Client(name, phone, fax, postcode, address, contact, conphone, usertype, enterprise, scale, email, id);
			int result = biz.updClient(cl);
			if(result>0) {
				req.getRequestDispatcher("ClientServlet?oper=all").forward(req, resp);
			}
		}else if(oper.equals("del")) {
			//获取属性
			int id = Integer.parseInt(req.getParameter("id"));
			//调用删除方法
			int result = biz.delClient(id);
			if(result>0) {
				//调用查询全部的方法
				System.out.println("servlet:删除客户信息成功");
				
			   	req.getRequestDispatcher("ClientServlet?oper=all").forward(req, resp);
			}else {
				System.out.println("servlet:删除客户信息失败");
				req.getRequestDispatcher("backstage/jsp/application/customer/customer.jsp").forward(req, resp);
			}
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//转换为int类型
			int totalCount=tdil.getTotalCount();//获得总记录数
			ClientPage pages=new ClientPage();
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
		    List<Client> cliList=biz.pageClientAll(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListClient(cliList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/application/customer/customer.jsp").forward(req, resp);
		}
		//写入对象中
		//out.write(msg);
		//关闭输出对象
		//out.close();
		
	}
}
