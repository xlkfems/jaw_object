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
 * @remark ְԱ���Ʋ�
 * @author ���
 * @createTime 15��14��
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
		
		req.setCharacterEncoding("utf-8");//���봦��
		String oper=req.getParameter("oper");//�����߼���������
		ClerkDaoImpl tdil=new ClerkDaoImpl();//ʵ����impl
		ClerkBiz biz=new ClerkBiz();//ʵ����biz
		//���ݴ������Ĳ���������ز���
		if(oper.equals("all")) {
		String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
	    if(pageIndex== null){
	        pageIndex= "1";
	    }
	    int currPageNo = Integer.parseInt(pageIndex);//ת��Ϊint����
		int totalCount=tdil.getTotalCount();//����ܼ�¼��
		ClerkPage pages=new ClerkPage();
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
	    List<Clerk> clList=biz.pageQueryTra(pages.getCurrPageNo(), pages.getPageSize());
	   		pages.setListClerk(clList);  //����ÿҳ��ʾ�ļ���
	   	    req.setAttribute("pages", pages);
	   	    req.getRequestDispatcher("backstage/jsp/application/employee/employee.jsp").forward(req, resp);
	   	//�ж�����
		}else
		if(oper.equals("add")) {
				//����������ı��
				String number = ("YZ"+String.valueOf(Math.round((100000+Math.random()*100000))));
				String cl_name = req.getParameter("employeeName");//����
				String cl_section = req.getParameter("position");//ְλ
				String cl_sex = req.getParameter("gender");//�Ա�
				String cl_time = req.getParameter("birthday");//����
				Clerk cle=new Clerk(cl_name,number, cl_section, cl_sex, cl_time);
				int result=biz.addClerk(cle);//���
				if(result>0) {
					//ִ�з�ҳ
					String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
				    if(pageIndex== null){
				        pageIndex= "1";
				    }
				    int currPageNo = Integer.parseInt(pageIndex);
					int totalCount=tdil.getTotalCount();//����ܼ�¼��
					ClerkPage pages=new ClerkPage();
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
				    List<Clerk> newsList=biz.pageQueryTra(pages.getCurrPageNo(), pages.getPageSize());
				   		pages.setListClerk(newsList); //����ÿҳ��ʾ�ļ���
				   	    req.setAttribute("pages", pages);
				   	    req.getRequestDispatcher("backstage/jsp/application/employee/employee.jsp").forward(req, resp);
			} 
		}else 
			if(oper.equals("del")) {
			//��ȡ����
			int id = Integer.parseInt(req.getParameter("id"));
			//����ɾ������
			int result = biz.delClerk(id);
			if(result>0) {
				//���ò�ѯȫ���ķ���
				System.out.println("servlet:ɾ���ͻ���Ϣ�ɹ�");
				
			   	req.getRequestDispatcher("ClerkServlet?oper=all").forward(req, resp);
			}else {
				System.out.println("servlet:ɾ���ͻ���Ϣ��Ϣʧ��");
				req.getRequestDispatcher("ClerkServlet?oper=all").forward(req, resp);
			}
		}else
			if(oper.equals("one")) {
				//ת��Ϊint����jspҳ���id����
				int id = Integer.parseInt(req.getParameter("id"));
				Clerk clerk = biz.queryOne(id);
				req.setAttribute("clerk", clerk);
				req.getRequestDispatcher("backstage/jsp/application/employee/emp_update.jsp").forward(req, resp);
		}else if(oper.equals("upd")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String cl_name = req.getParameter("employeeName");//����
			String cl_section = req.getParameter("position");//ְλ
			String cl_sex = req.getParameter("gender");//�Ա�
			String cl_time = req.getParameter("birthday");//����
			Clerk clerk = new Clerk(cl_name, cl_section, cl_sex, cl_time, id);
			int result = biz.updaClerk(clerk);
			if(result>0) {
				req.getRequestDispatcher("ClerkServlet?oper=all").forward(req, resp);
			}
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//ת��Ϊint����
			int totalCount=tdil.getTotalCount();//����ܼ�¼��
			ClerkPage pages=new ClerkPage();
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
		    List<Clerk> clList=biz.pageQueryTra(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListClerk(clList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/application/employee/employee.jsp").forward(req, resp);
		}
	}
}
