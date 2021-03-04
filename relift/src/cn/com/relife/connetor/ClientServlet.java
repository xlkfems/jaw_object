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
 * @remark �ͻ����Ʋ�
 * @author ���
 * @createTime 15��14��
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
		
		req.setCharacterEncoding("utf-8");//���봦��
		String oper=req.getParameter("oper");//�����߼���������
		ClientDaoImpl tdil=new ClientDaoImpl();//ʵ����impl
		ClientBiz biz=new ClientBiz();//ʵ����biz
		//�����ӡ������󣬽���̨�����������Ľ����Ӧ���ͻ���ҳ����
		//PrintWriter out=resp.getWriter();
		//������ս������
		//String msg=null;
		
		if(oper.equals("all")) {
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//ת��Ϊint����
			int totalCount=tdil.getTotalCount();//����ܼ�¼��
			ClientPage pages=new ClientPage();
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
		    //���÷���
		    List<Client> cliList=biz.pageClientAll(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListClient(cliList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/application/customer/customer.jsp").forward(req, resp);
			}else
		if(oper.equals("add")){
			//����������ı��
			String number = ("KH"+String.valueOf(Math.round((100000+Math.random()*100000))));
			String name = req.getParameter("customer");
			String phone = req.getParameter("phone");
			String fax = req.getParameter("fax");
			String postcode = req.getParameter("postCode");
			String address = req.getParameter("address");//��ַ
			String contact = req.getParameter("linkman");//��ϵ��
			String conphone = req.getParameter("linkmanMobile");//��ϰ���ֻ�
			String usertype = req.getParameter("customerType");//�ͻ�����
			String enterprise = req.getParameter("enterpriseProperty");//��ҵ����
			String scale = req.getParameter("enterpriseSize");//��ҵ��ģ
			String email = req.getParameter("email");//����
			//ʵ�����û���Ϣ��
			Client entity = new Client(number,name, phone, fax, postcode, address,
					contact, conphone, usertype, enterprise, scale, email);
			
			int result = biz.addClient(entity);
			if(result>0) {
				//ִ�з�ҳ
				String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
			    if(pageIndex== null){
			        pageIndex= "1";
			    }
			    int currPageNo = Integer.parseInt(pageIndex);
				int totalCount=tdil.getTotalCount();//����ܼ�¼��
				ClientPage pages=new ClientPage();
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
			    List<Client> newsList=biz.pageClientAll(pages.getCurrPageNo(), pages.getPageSize());
			   		pages.setListClient(newsList); //����ÿҳ��ʾ�ļ���
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
			String address = req.getParameter("address");//��ַ
			String contact = req.getParameter("linkman");//��ϵ��
			String conphone = req.getParameter("linkmanMobile");//��ϰ���ֻ�
			String usertype = req.getParameter("customerType");//�ͻ�����
			String enterprise = req.getParameter("enterpriseProperty");//��ҵ����
			String scale = req.getParameter("enterpriseSize");//��ҵ��ģ
			String email = req.getParameter("email");//����
			Client cl = new Client(name, phone, fax, postcode, address, contact, conphone, usertype, enterprise, scale, email, id);
			int result = biz.updClient(cl);
			if(result>0) {
				req.getRequestDispatcher("ClientServlet?oper=all").forward(req, resp);
			}
		}else if(oper.equals("del")) {
			//��ȡ����
			int id = Integer.parseInt(req.getParameter("id"));
			//����ɾ������
			int result = biz.delClient(id);
			if(result>0) {
				//���ò�ѯȫ���ķ���
				System.out.println("servlet:ɾ���ͻ���Ϣ�ɹ�");
				
			   	req.getRequestDispatcher("ClientServlet?oper=all").forward(req, resp);
			}else {
				System.out.println("servlet:ɾ���ͻ���Ϣʧ��");
				req.getRequestDispatcher("backstage/jsp/application/customer/customer.jsp").forward(req, resp);
			}
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//ת��Ϊint����
			int totalCount=tdil.getTotalCount();//����ܼ�¼��
			ClientPage pages=new ClientPage();
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
		    //���÷���
		    List<Client> cliList=biz.pageClientAll(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListClient(cliList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/application/customer/customer.jsp").forward(req, resp);
		}
		//д�������
		//out.write(msg);
		//�ر��������
		//out.close();
		
	}
}
