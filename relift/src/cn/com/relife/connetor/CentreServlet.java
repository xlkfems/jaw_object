package cn.com.relife.connetor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.CentreBiz;
import cn.com.relife.biz.ModeBiz;
import cn.com.relife.entity.Centre;
import cn.com.relife.entity.CentrePage;
import cn.com.relife.entity.Clerk;
import cn.com.relife.entity.ClerkPage;
import cn.com.relife.entity.Place;
import cn.com.relife.entity.PlacePage;
import cn.com.relife.impl.CentreDaoImpl;
import cn.com.relife.impl.ModeDaoImpl;

public class CentreServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//���봦��
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//�����߼���������
		
		CentreDaoImpl cdil=new CentreDaoImpl();
		CentreBiz biz=new CentreBiz();
		ModeDaoImpl mdil=new ModeDaoImpl();
		ModeBiz modebiz=new ModeBiz();
		
		if(oper.equals("add")) {
			//����д�õ���ת�������б���
			String fre_number=req.getParameter("fre_number");
			String transferStation=req.getParameter("transferStation");//��ת��
			String transferCheck=req.getParameter("transferCheck");//˾��
			String receiveBillTime=req.getParameter("receiveBillTime");//ʱ��
			String receiveBillPerson=req.getParameter("receiveBillPerson");//վ������
			String transferCompany=req.getParameter("transferCompany");//�����ַ
			String transferStationTel=req.getParameter("transferStationTel");//�绰
			
			Centre centre=new Centre(fre_number,transferStation,transferCheck,receiveBillTime,receiveBillPerson
					,transferCompany,transferStationTel);
			int count=cdil.add_Centre(centre);
			//����֮�����״̬���޸�
			int transit=mdil.update_mod(fre_number, "����ת");
			//Ȼ����ת����ת�˵��Ĳ�ѯ
	   	    req.getRequestDispatcher("modeServlet?oper=query_interim").forward(req, resp);
		}else if(oper.equals("query")) {
			//�����ѽ���ת�Ķ�����ʷ��ѯ
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//ת��Ϊint����
			int totalCount=cdil.getCentre();//����ܼ�¼��
			CentrePage pages=new CentrePage();
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
		    List<Centre> clList=biz.pageQueryCentre(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListCentre(clList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/transit/transfer/history.jsp").forward(req, resp);
		}else if(oper.equals("query_place")) {
			//������Ҫ����Ķ�����ѯ
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//ת��Ϊint����
			int totalCount=cdil.getPlace();//����ܼ�¼��
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
		    List<Place> placeist=biz.pageQueryPlace(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListPlace(placeist);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/settle/goodsBill/goodsBill.jsp").forward(req, resp);
		}else if(oper.equals("query_phone")) {
				String number=req.getParameter("phone");
				
				String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
			    if(pageIndex== null){
			        pageIndex= "1";
			    }
			    int currPageNo = Integer.parseInt(pageIndex);//ת��Ϊint����
				int totalCount=cdil.getCentre();//����ܼ�¼��
				CentrePage pages=new CentrePage();
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
			    List<Centre> clList=biz.pageQueryCentre(pages.getCurrPageNo(), pages.getPageSize(),number);
			   		pages.setListCentre(clList);  //����ÿҳ��ʾ�ļ���
			   	    req.setAttribute("pages", pages);
			   	    req.getRequestDispatcher("backstage/jsp/transit/transfer/history.jsp").forward(req, resp);
		}else if(oper.equals("query_phon")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//ת��Ϊint����
			int totalCount=cdil.getPlace();//����ܼ�¼��
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
		    List<Place> placeist=biz.pageQueryPlace(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListPlace(placeist);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/settle/goodsBill/goodsBill.jsp").forward(req, resp);
		}
	}
}	
