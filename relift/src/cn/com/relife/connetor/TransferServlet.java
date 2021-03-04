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
 * @remark ��תվ���Ʋ�
 * @author ���
 * @createTime 08��42��
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
		
		req.setCharacterEncoding("utf-8");//���봦��
		String oper=req.getParameter("oper");//�����߼���������
		TransferDaoImpl tdil=new TransferDaoImpl();
		TransferBiz biz=new TransferBiz();
		if(oper.equals("query")) {
			//�������е���תվ��Ĳ�ѯ
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int totalCount=tdil.getTotalCount();//����ܼ�¼��
			TransferPage pages=new TransferPage();
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
		    List<Transfer> newsList=biz.pageQueryTra(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListTransfer(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/transit/company/company.jsp").forward(req, resp);
		   	//�ж�����
		}else
		if(oper.equals("add")) {
			//������תվ�������
			//��ȡ��ҳ���ϵ���Ϣ
				String tr_city = req.getParameter("tr_city");
				String tr_name = req.getParameter("tr_name");
				String tr_phone = req.getParameter("tr_phone");
				String tr_address = req.getParameter("tr_address");
				String tr_longitude = req.getParameter("tr_longitude");
				Transfer transfer=new Transfer(tr_city,tr_name,tr_phone,tr_address,tr_longitude);
				int result=biz.addTtansfer(transfer);
				//�����ɹ�֮�����վ��Ĳ�ѯ
				if(result>0) {
					System.out.println("�����ɹ�");
					//ִ�з�ҳ
					String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
				    if(pageIndex== null){
				        pageIndex= "1";
				    }
				    int currPageNo = Integer.parseInt(pageIndex);
					int totalCount=tdil.getTotalCount();//����ܼ�¼��
					TransferPage pages=new TransferPage();
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
				    List<Transfer> newsList=biz.pageQueryTra(pages.getCurrPageNo(), pages.getPageSize());
				   		pages.setListTransfer(newsList);  //����ÿҳ��ʾ�ļ���
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

