package cn.com.relife.connetor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.TransferBiz;
import cn.com.relife.entity.Transfer;
import cn.com.relife.entity.TransferPage;
import cn.com.relife.impl.TransferDaoImpl;

/**
 * @remark 中转站控制层
 * @author 随便
 * @createTime 08点42分
 * @version 1.0
 */
public class TransferServlet extends HttpServlet{
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
		TransferDaoImpl tdil=new TransferDaoImpl();
		TransferBiz biz=new TransferBiz();
		if(oper.equals("query")) {
			//进行所有的中转站点的查询
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int totalCount=tdil.getTotalCount();//获得总记录数
			TransferPage pages=new TransferPage();
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
		    List<Transfer> newsList=biz.pageQueryTra(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListTransfer(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/transit/company/company.jsp").forward(req, resp);
		   	//判断新增
		}else
		if(oper.equals("add")) {
			//进行中转站点的新增
			//获取其页面上的信息
				String tr_city = req.getParameter("tr_city");
				String tr_name = req.getParameter("tr_name");
				String tr_phone = req.getParameter("tr_phone");
				String tr_address = req.getParameter("tr_address");
				String tr_longitude = req.getParameter("tr_longitude");
				Transfer transfer=new Transfer(tr_city,tr_name,tr_phone,tr_address,tr_longitude);
				int result=biz.addTtansfer(transfer);
				//新增成功之后进行站点的查询
				if(result>0) {
					System.out.println("新增成功");
					//执行分页
					String pageIndex= req.getParameter("pageNo");//获得当前页数
				    if(pageIndex== null){
				        pageIndex= "1";
				    }
				    int currPageNo = Integer.parseInt(pageIndex);
					int totalCount=tdil.getTotalCount();//获得总记录数
					TransferPage pages=new TransferPage();
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
				    List<Transfer> newsList=biz.pageQueryTra(pages.getCurrPageNo(), pages.getPageSize());
				   		pages.setListTransfer(newsList);  //设置每页显示的集合
				   	    req.setAttribute("pages", pages);
				   	    req.getRequestDispatcher("backstage/jsp/transit/company/company.jsp").forward(req, resp);
			} 
		}else if(oper.equals("nationwide")) {
			List<Transfer> traList = new ArrayList<Transfer>();
			traList = biz.pageQueryTra();
			req.setAttribute("traList", traList);
			req.getRequestDispatcher("backstage/jsp/transit/transfer/map.jsp").forward(req, resp);
		}
	}
}

