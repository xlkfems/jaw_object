package cn.com.relife.connetor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.MessageBiz;
import cn.com.relife.entity.Message;
import cn.com.relife.impl.MessageDaoImpl;

public class MessageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//编码处理
		String oper=req.getParameter("oper");//接收逻辑操作参数
		MessageDaoImpl mdil=new MessageDaoImpl();
		MessageBiz biz=new MessageBiz();
		if(oper.equals("add")) {
			String dialNo=req.getParameter("dialNo");//客户编号
			String type=req.getParameter("type");//标题
			String content=req.getParameter("content");//内容
			String writer=req.getParameter("writer");//填写人
			String receiveBillTime=req.getParameter("receiveBillTime");//填写时间
			Message message=new Message(dialNo,type,content,writer,receiveBillTime);
			
			int count=biz.add_message(message);
			resp.sendRedirect("backstage/jsp/report/phone.jsp");
		}
	}
}
