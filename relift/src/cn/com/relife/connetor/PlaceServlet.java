package cn.com.relife.connetor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.PlaceBiz;
import cn.com.relife.entity.Place;
import cn.com.relife.entity.PlacePage;
import cn.com.relife.impl.PlaneDaoImpl;

public class PlaceServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//���봦��
		String oper=req.getParameter("oper");//�����߼���������
		PlaneDaoImpl pdil=new PlaneDaoImpl();
		PlaceBiz biz=new PlaceBiz();
		if(oper.equals("query")) {
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int totalCount=pdil.getPlace();//����ܼ�¼��
			PlacePage pages=new PlacePage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(totalCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Place> newsList=biz.pageQueryPla(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListPlace(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/order/details/order_details.jsp").forward(req, resp);
		}else if(oper.equals("details")) {
			String number=req.getParameter("number");
			Place place=biz.query_place(number);
			req.setAttribute("place", place);
			req.getRequestDispatcher("backstage/jsp/order/details/single_order.jsp").forward(req, resp);
		}else if(oper.equals("query_place")) {
			//���ж�����ϸ��Ϣ�Ĳ�ѯ
			String number=req.getParameter("number");
			Place place=biz.query_place(number);
			req.setAttribute("place", place);
			req.getRequestDispatcher("backstage/jsp/settle/goodsBill/close_goodsBill.jsp").forward(req, resp);
		}else if(oper.equals("update_place")) {
			//�ύ֮����ж������㣬�������֮�����״̬�޸�
			String number=req.getParameter("goodsBillCode");
			int count=biz.update_place(number, "�ѽ���");
			if(count>0) {
				System.out.println("�޸ĳɹ�");
			}
			req.getRequestDispatcher("centreServlet?oper=query_place").forward(req, resp);
		}else if(oper.equals("query_close")) {
				//��ѯ�Ѿ�����Ķ�����Ϣ
				String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
			    if(pageIndex== null){
			        pageIndex= "1";
			    }
			    int currPageNo = Integer.parseInt(pageIndex);
				int totalCount=pdil.getPlace();//����ܼ�¼��
				PlacePage pages=new PlacePage();
				pages.setPageSize(8);    //����ÿҳ����
				pages.setTotalCount(totalCount);   //�����ܼ�¼��
				int totalpages= pages.getTotalPageCount();
				/*����ҳ��ĩҳ���п���*/
			    if(currPageNo < 1){
			        currPageNo = 1;
			    }else if(currPageNo > pages.getTotalPageCount()){
			        currPageNo = totalpages;
			    }
			    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
			    List<Place> newsList=biz.pageQueryPlace(pages.getCurrPageNo(), pages.getPageSize());
			   		pages.setListPlace(newsList);  //����ÿҳ��ʾ�ļ���
			   	    req.setAttribute("pages", pages);
			   	    req.getRequestDispatcher("backstage/jsp/settle/goodsBill/goodbill.jsp").forward(req, resp);
		}else if(oper.equals("report")) {
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int totalCount=pdil.getPlace();//����ܼ�¼��
			PlacePage pages=new PlacePage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(totalCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Place> newsList=biz.pageQueryReport(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListPlace(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/report/arrive/arrive.jsp").forward(req, resp);
		}else if(oper.equals("client")) {
			String number=req.getParameter("number");
			Place place=biz.query_place(number);
			req.setAttribute("place", place);
			req.getRequestDispatcher("backstage/jsp/report/phone.jsp").forward(req, resp);
			
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int totalCount=pdil.getPlace();//����ܼ�¼��
			PlacePage pages=new PlacePage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(totalCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Place> newsList=biz.pageQueryPla(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListPlace(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/order/details/order_details.jsp").forward(req, resp);
		}else if(oper.equals("query_phon")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int totalCount=pdil.getPlace();//����ܼ�¼��
			PlacePage pages=new PlacePage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(totalCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Place> newsList=biz.pageQueryPlace(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListPlace(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/settle/goodsBill/goodbill.jsp").forward(req, resp);
		}
	}
}
