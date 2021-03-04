package cn.com.relife.connetor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.ClerkBiz;
import cn.com.relife.entity.Clerk;
import cn.com.relife.entity.ClerkPage;
import cn.com.relife.impl.ClerkDaoImpl;
/**
 * @remark 职员控制层
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public class ClerkServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		ClerkDaoImpl tdil=new ClerkDaoImpl();//实例化impl
		ClerkBiz biz=new ClerkBiz();//实例化biz
		//根据传过来的参数进行相关操作
		if(oper.equals("all")) {
		String pageIndex= req.getParameter("pageNo");//获得当前页数
	    if(pageIndex== null){
	        pageIndex= "1";
	    }
	    int currPageNo = Integer.parseInt(pageIndex);//转换为int类型
		int totalCount=tdil.getTotalCount();//获得总记录数
		ClerkPage pages=new ClerkPage();
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
	    List<Clerk> clList=biz.pageQueryTra(pages.getCurrPageNo(), pages.getPageSize());
	   		pages.setListClerk(clList);  //设置每页显示的集合
	   	    req.setAttribute("pages", pages);
	   	    req.getRequestDispatcher("backstage/jsp/application/employee/employee.jsp").forward(req, resp);
	   	//判断新增
		}else
		if(oper.equals("add")) {
				//随机数产生的编号
				String number = ("YZ"+String.valueOf(Math.round((100000+Math.random()*100000))));
				String cl_name = req.getParameter("employeeName");//姓名
				String cl_section = req.getParameter("position");//职位
				String cl_sex = req.getParameter("gender");//性别
				String cl_time = req.getParameter("birthday");//生日
				Clerk cle=new Clerk(cl_name,number, cl_section, cl_sex, cl_time);
				int result=biz.addClerk(cle);//添加
				if(result>0) {
					//执行分页
					String pageIndex= req.getParameter("pageNo");//获得当前页数
				    if(pageIndex== null){
				        pageIndex= "1";
				    }
				    int currPageNo = Integer.parseInt(pageIndex);
					int totalCount=tdil.getTotalCount();//获得总记录数
					ClerkPage pages=new ClerkPage();
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
				    List<Clerk> newsList=biz.pageQueryTra(pages.getCurrPageNo(), pages.getPageSize());
				   		pages.setListClerk(newsList); //设置每页显示的集合
				   	    req.setAttribute("pages", pages);
				   	    req.getRequestDispatcher("backstage/jsp/application/employee/employee.jsp").forward(req, resp);
			} 
		}else 
			if(oper.equals("del")) {
			//获取属性
			int id = Integer.parseInt(req.getParameter("id"));
			//调用删除方法
			int result = biz.delClerk(id);
			if(result>0) {
				//调用查询全部的方法
				System.out.println("servlet:删除客户信息成功");
				
			   	req.getRequestDispatcher("ClerkServlet?oper=all").forward(req, resp);
			}else {
				System.out.println("servlet:删除客户信息信息失败");
				req.getRequestDispatcher("ClerkServlet?oper=all").forward(req, resp);
			}
		}else
			if(oper.equals("one")) {
				//转换为int接收jsp页面的id参数
				int id = Integer.parseInt(req.getParameter("id"));
				Clerk clerk = biz.queryOne(id);
				req.setAttribute("clerk", clerk);
				req.getRequestDispatcher("backstage/jsp/application/employee/emp_update.jsp").forward(req, resp);
		}else if(oper.equals("upd")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String cl_name = req.getParameter("employeeName");//姓名
			String cl_section = req.getParameter("position");//职位
			String cl_sex = req.getParameter("gender");//性别
			String cl_time = req.getParameter("birthday");//生日
			Clerk clerk = new Clerk(cl_name, cl_section, cl_sex, cl_time, id);
			int result = biz.updaClerk(clerk);
			if(result>0) {
				req.getRequestDispatcher("ClerkServlet?oper=all").forward(req, resp);
			}
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//转换为int类型
			int totalCount=tdil.getTotalCount();//获得总记录数
			ClerkPage pages=new ClerkPage();
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
		    List<Clerk> clList=biz.pageQueryTra(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListClerk(clList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/application/employee/employee.jsp").forward(req, resp);
		}
	}
}
