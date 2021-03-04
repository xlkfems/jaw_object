package cn.com.relife.connetor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.NoticeBiz;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.ModePage;
import cn.com.relife.entity.Notice;
import cn.com.relife.entity.NoticePage;
import cn.com.relife.impl.NoticeDaoImpl;

public class NoticeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//编码处理
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//接收逻辑操作参数
		NoticeDaoImpl ndil=new NoticeDaoImpl();
		NoticeBiz biz=new NoticeBiz();
		
		if(oper.equals("query")) {
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int noticeCount=ndil.getNotice();//获得总记录数
			NoticePage pages=new NoticePage();
			pages.setPageSize(5);    //设置每页条数
			pages.setTotalCount(noticeCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Notice> newsList=biz.pageQueryMode(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListNotice(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    int count=ndil.query_hunan();
		   	    req.setAttribute("count", count);
		   	    req.getRequestDispatcher("backstage/main.jsp").forward(req, resp);
		}else if(oper.equals("query_no")) {
			String number=req.getParameter("number");
			Notice notice=biz.query(number);
			req.setAttribute("notice", notice);
			req.getRequestDispatcher("backstage/notice.jsp").forward(req, resp);
		}else if(oper.equals("query_phone")) {
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int noticeCount=ndil.getNotice();//获得总记录数
			NoticePage pages=new NoticePage();
			pages.setPageSize(5);    //设置每页条数
			pages.setTotalCount(noticeCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Notice> newsList=biz.pageQueryMode(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListNotice(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/notice/xjb.jsp").forward(req, resp);
		}else if(oper.equals("add")) {
			String title=req.getParameter("employeeName");
			String birthday=req.getParameter("birthday");
			String content=req.getParameter("content");
			Notice notice=new Notice(title,content,birthday);
			biz.add(notice);
			
			String pageIndex= req.getParameter("pageNo");//获得当前页数
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int noticeCount=ndil.getNotice();//获得总记录数
			NoticePage pages=new NoticePage();
			pages.setPageSize(5);    //设置每页条数
			pages.setTotalCount(noticeCount);   //设置总记录数
			int totalpages= pages.getTotalPageCount();
			/*对首页与末页进行控制*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //设置当前页面
		    List<Notice> newsList=biz.pageQueryMode(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListNotice(newsList);  //设置每页显示的集合
		   	    req.setAttribute("pages", pages);
			req.getRequestDispatcher("backstage/jsp/notice/xjb.jsp").forward(req, resp);
		}else if(oper.equals("delete")) {
			String id=req.getParameter("id");
			ndil.delete(id);
			req.getRequestDispatcher("noticeServlet?oper=query_phone").forward(req, resp);
		}
	}
}
