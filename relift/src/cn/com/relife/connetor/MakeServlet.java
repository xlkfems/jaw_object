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
 * @remark Ʊ��
 * @author ���
 * @createTime 00��37��
 * @version 1.0
 */
public class MakeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//���봦��
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//�����߼���������
		MakeDaoImpl mdil=new MakeDaoImpl();
		MakeBiz biz=new MakeBiz();
		List<Place> placeList = new ArrayList<Place>();
		if(oper.equals("inquire")) {
			placeList=biz.query_userInfo();
			req.setAttribute("placeList", placeList);
			req.getRequestDispatcher("backstage/jsp/cargo/addinvoice/addinvoice.jsp").forward(req, resp);
		}else if(oper.equals("query")) {
			PrintWriter out=resp.getWriter();//��ȥ��ӡ����
			req.setCharacterEncoding("utf-8");//���봦��
			String  number=req.getParameter("number");
			Place query_place=biz.query_userInfo(number);
			req.setAttribute("query_place", query_place);
			//��ȡ������λ�õ�ֵ,���÷ָ���ʾ
			String a_name=query_place.getA_name()+",";
			String a_phone=query_place.getA_phone()+",";
			String a_address_block=query_place.getA_address_block()+",";
			String m_name=query_place.getM_name()+",";
			String m_phone=query_place.getM_phone()+",";
			String m_address_block=query_place.getM_address_block()+",";
			String piece=query_place.getPiece()+",";//����
			String cost=query_place.getInsuredPrice();//����
			int money = Integer.parseInt(cost);
			money=(int) (money*0.003);
			String cost_money=Integer.toString(money);
			cost_money=cost_money+",";
			String weight=query_place.getWeight()+",";//���
			String acceptStation=query_place.getState()+",";
			String pick=query_place.getPick()+",";
			String pl_money=query_place.getPl_money()+",";
			String remark=query_place.getRemark();
			
			//д�������
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
			msg=piece;//����
			out.write(msg);
			msg=cost_money;//����
			out.write(msg);
			msg=weight;//���
			out.write(msg);
			msg=acceptStation;
			out.write(msg);
			msg=pick;
			out.write(msg);
			msg=pl_money;
			out.write(msg);
			msg=remark;
			out.write(msg);
			//�ر����������
			out.close();
		}else if(oper.equals("add")) {
			String a_name=req.getParameter("a_name");
			String a_phone=req.getParameter("a_phone");
			String a_address_block=req.getParameter("a_address_block");
			String m_name=req.getParameter("m_name");
			String m_phone=req.getParameter("m_phone");
			String m_address_block=req.getParameter("m_address_block");
			String consignment=req.getParameter("consignment");//������ַ
			String delivery=req.getParameter("delivery");//�ջ���ַ
			String payMode=req.getParameter("payMode");//���ʽ
			String fetchGoodsMode=req.getParameter("fetchGoodsMode");//ȡ����ʽ
			String writeBillPerson=req.getParameter("writeBillPerson");//��Ʊ��
			String writeDate=req.getParameter("writeDate");//��Ʊ����
			String transferStation=req.getParameter("transferStation");//��ת��
			String transferFee=req.getParameter("transferFee");//��ת��
			String carriage=req.getParameter("carriage");//�˷�
			String employeeCode="admin";//ְԱ���
			String remark=req.getParameter("remark");//��ע
			String piece=req.getParameter("piece");//����
			String bulk=req.getParameter("bulk");//�����
			String sendGoodsDate=req.getParameter("sendGoodsDate");//��������
			String support=req.getParameter("support");//���۷�
			String acceptStation=req.getParameter("acceptStation");//״̬
			
			
			acceptStation="����";
			String number=req.getParameter("send_place");//���
			if(transferStation=="") {
				transferStation="ֱ��";
				transferFee="0";
			}
			Make make=new Make(sendGoodsDate,payMode,fetchGoodsMode,writeBillPerson,writeDate,
					transferStation,transferFee,carriage,remark,delivery,consignment,m_name,m_phone,m_address_block
					,a_name,a_phone,a_address_block,number,piece,bulk,support,employeeCode,acceptStation);
			int result=biz.addMake(make);//����
			
			int count=biz.update(number);//�޸�״̬
			if(result>0 && count>0) {
				System.out.println("�ɹ�");
				req.getRequestDispatcher("backstage/jsp/cargo/addinvoice/addinvoice.jsp").forward(req, resp);
			}
		}else if(oper.equals("committed")) {
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
		    List<Make> newsList=biz.pageQueryMake(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListMake(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/cargo/queryinvoice/queryinvoice.jsp").forward(req, resp);
		}
	}
}
