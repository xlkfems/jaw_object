package cn.com.relife.connetor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.DriverBiz;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.DriverPage;
import cn.com.relife.impl.DriverDaoImpl;
/**
 * @remark ˾�����Ʋ�
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */

public class DriverServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getContextPath();
		   
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" +     
	    req.getServerPort() + path + "/";
		
		req.setCharacterEncoding("utf-8");//���봦��
		String oper=req.getParameter("oper");//�����߼���������
		DriverDaoImpl tdil=new DriverDaoImpl();//ʵ����impl
		DriverBiz biz=new DriverBiz();//ʵ����biz
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
			DriverPage pages=new DriverPage();
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
		    List<Driver> driverList=biz.pageDriverAll(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListDriver(driverList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/application/driver/driver.jsp").forward(req, resp);
			}else
		if(oper.equals("add")){
			//����������ı��
			String dr_number = ("SJ"+String.valueOf(Math.round((100000+Math.random()*100000))));
			 //int dr_id = Integer.parseInt(req.getParameter("id"));//˾��id
			 String dr_name = req.getParameter("driverName");//˾������
			 String dr_identity = req.getParameter("idCard");;//˾�����֤
			 String dr_phone = req.getParameter("phone");;//˾���绰
			 String dr_sex = req.getParameter("gender");;//˾���Ա�
			 String dr_hoday = req.getParameter("birthday");;//˾������
			 String dr_car = req.getParameter("carNo");;//����
			 String dr_state = req.getParameter("carType");;//����
			 String dr_volume = req.getParameter("allowCarryVolume");;//׼�����
			 String dr_load = req.getParameter("allowCarryWeight");;//׼������
			 String dr_address = req.getParameter("address");;//סַ
			 String dr_long = req.getParameter("carLength");;//��������
			 String dr_width = req.getParameter("carWidth");;//�������
			 String dr_length = req.getParameter("goodsHeight");;//����߶�
			 String dr_licence = req.getParameter("driveLicence");;//��ʻ֤
			 String dr_xing = req.getParameter("runLicence");;//��ʻ֤
			 String dr_run = req.getParameter("bizLicence");;//��Ӫ֤
			 String dr_vin = req.getParameter("carFrameNo");;//���ܺ�
			 dr_vin="����";
			 String dr_unit = req.getParameter("carDept");;//������λ
			 String unit_phone = req.getParameter("carDeptTel");;//��λ����
			 String dr_company = req.getParameter("companyCar");;//��˾��
			 String dr_remark = req.getParameter("remark");;//��ע
			//ʵ�����û���Ϣ��
			Driver driver = new Driver(dr_number,dr_name, dr_identity, dr_phone, dr_sex, dr_hoday
					, dr_car, dr_state, dr_volume, dr_load, dr_address, dr_long, dr_width
					, dr_length, dr_licence, dr_xing, dr_run, dr_vin, dr_unit, unit_phone
					, dr_company, dr_remark);
			int result = biz.addDriver(driver);
			if(result>0) {
				//ִ�з�ҳ
				String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
			    if(pageIndex== null){
			        pageIndex= "1";
			    }
			    int currPageNo = Integer.parseInt(pageIndex);
				int totalCount=tdil.getTotalCount();//����ܼ�¼��
				DriverPage pages=new DriverPage();
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
			    List<Driver> newsList=biz.pageDriverAll(pages.getCurrPageNo(), pages.getPageSize());
			   		pages.setListDriver(newsList); //����ÿҳ��ʾ�ļ���
			   	    req.setAttribute("pages", pages);
			   	    req.getRequestDispatcher("backstage/jsp/application/driver/driver.jsp").forward(req, resp);
				}
			}else if(oper.equals("one")) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			Driver driver = biz.queryOne(id);
			req.setAttribute("driver", driver);
			req.getRequestDispatcher("backstage/jsp/application/driver/dr_query.jsp").forward(req, resp);
			
		}else if(oper.equals("ones")) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			Driver driver = biz.queryOne(id);
			req.setAttribute("driver", driver);
			req.getRequestDispatcher("backstage/jsp/application/driver/dr_update.jsp").forward(req, resp);
		}
			else if(oper.equals("upda")) {
			 int dr_id = Integer.parseInt(req.getParameter("id"));//˾��id
			 String dr_name = req.getParameter("driverName");//˾������
			 String dr_identity = req.getParameter("idCard");;//˾�����֤
			 String dr_phone = req.getParameter("phone");;//˾���绰
			 String dr_sex = req.getParameter("gender");;//˾���Ա�
			 String dr_hoday = req.getParameter("birthday");;//˾������
			 String dr_car = req.getParameter("carNo");;//����
			 String dr_state = req.getParameter("carType");;//����
			 String dr_volume = req.getParameter("allowCarryVolume");;//׼�����
			 String dr_load = req.getParameter("allowCarryWeight");;//׼������
			 String dr_address = req.getParameter("address");;//סַ
			 String dr_long = req.getParameter("carLength");;//��������
			 String dr_width = req.getParameter("carWidth");;//�������
			 String dr_length = req.getParameter("goodsHeight");;//����߶�
			 String dr_licence = req.getParameter("driveLicence");;//��ʻ֤
			 String dr_xing = req.getParameter("runLicence");;//��ʻ֤
			 String dr_run = req.getParameter("bizLicence");;//��Ӫ֤
			 String dr_vin = req.getParameter("carFrameNo");;//���ܺ�
			 String dr_unit = req.getParameter("carDept");;//������λ
			 String unit_phone = req.getParameter("carDeptTel");;//��λ����
			 String dr_company = req.getParameter("companyCar");;//��˾��
			 String dr_remark = req.getParameter("remark");;//��ע
			//ʵ�����û���Ϣ��
			Driver driver = new Driver(dr_name, dr_identity, dr_phone, dr_sex, dr_hoday
					, dr_car, dr_state, dr_volume, dr_load, dr_address, dr_long, dr_width
					, dr_length, dr_licence, dr_xing, dr_run, dr_vin, dr_unit, unit_phone
					, dr_company, dr_remark,dr_id);
			int result = biz.updDriver(driver);
			if(result>0) {
				req.getRequestDispatcher("DriverServlet?oper=all").forward(req, resp);
			}
		}else
		if(oper.equals("del")) {
			//��ȡ����
			int id = Integer.parseInt(req.getParameter("id"));
			//����ɾ������
			int result = biz.delDriver(id);
			if(result>0) {
				//���ò�ѯȫ���ķ���
				System.out.println("servlet:ɾ��˾����Ϣ�ɹ�");
			   	req.getRequestDispatcher("DriverServlet?oper=all").forward(req, resp);
			}else {
				System.out.println("ɾ��˾����Ϣʧ��");
			}
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//ת��Ϊint����
			int totalCount=tdil.getTotalCount();//����ܼ�¼��
			DriverPage pages=new DriverPage();
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
		    List<Driver> driverList=biz.pageDriverAll(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListDriver(driverList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/application/driver/driver.jsp").forward(req, resp);
		}
	}
}
