package cn.com.relife.connetor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.ModeBiz;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.MakePage;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.ModePage;
import cn.com.relife.entity.Nmsl;
import cn.com.relife.entity.Transfer;
import cn.com.relife.impl.ModeDaoImpl;
import cn.com.relife.impl.NmslDaoImpl;
import cn.com.relife.impl.PlaneDaoImpl;

public class ModeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//���봦��
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//�����߼���������
		ModeDaoImpl mdil=new ModeDaoImpl();
		ModeBiz modebiz=new ModeBiz();
		
		if(oper.equals("query")) {
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int ModeCount=mdil.getMode();//����ܼ�¼��
			ModePage pages=new ModePage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(ModeCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Mode> newsList=modebiz.pageQueryMode(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListMode(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/carriage/state/status.jsp").forward(req, resp);
		}else if(oper.equals("transfer")) {
			String number=req.getParameter("number");
			NmslDaoImpl ndil=new NmslDaoImpl();
			Nmsl nmsl=ndil.query(1);
			req.setAttribute("nmsl",nmsl);
			
			req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
		}else if(oper.equals("update")) {
			String city=req.getParameter("city");//���
			String number=req.getParameter("number");//״̬
			String weizhi=req.getParameter("weizhi");//״̬
			
			req.setAttribute("number", number);
			req.setAttribute("city", city);
			req.setAttribute("weizhi", weizhi);
			req.getRequestDispatcher("backstage/jsp/carriage/state/mode.jsp").forward(req, resp);
			
		}else if(oper.equals("update_mode")) {
			String number=req.getParameter("number");//���
			String acceptStation=req.getParameter("acceptStation");//���
			Mode mod=mdil.query_mode(number);
			mdil.update_mode(number,acceptStation);
			
			PlaneDaoImpl pdil=new PlaneDaoImpl();
			
			if(acceptStation.equals(mod.getMake_receipt())) {
				pdil.update_place(number, "���ʹ�");
			}else {
				pdil.update_place(number, "������");
				mdil.update_mod(number, "������");
			}
			String city=req.getParameter("dispense");//���
			String weizhi=req.getParameter("acceptStation");//״̬
			
			req.setAttribute("number", number);
			req.setAttribute("city", city);
			req.setAttribute("weizhi", weizhi);
			req.getRequestDispatcher("modeServlet?oper=query").forward(req, resp);
		}else if(oper.equals("update_nmsl")) {
			NmslDaoImpl ndil=new NmslDaoImpl();
			Nmsl nmsl=ndil.query(1);
			String name=nmsl.getLocation();
			if(name.equals("����")) {
				System.out.println("ִ��");
				Nmsl nb=new Nmsl("�人",113.09564,30.37214,"�ѵ����人,���ڷ���֣��");
				ndil.update(nb);
				
				Nmsl nms=ndil.query(1);
				req.setAttribute("nmsl",nms);
				
				req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
			}else if(nmsl.getLocation().equals("�人")) {
				Nmsl nb=new Nmsl("֣��",114.50465,34.84645,"�ѵ���֣��,���ڷ���ʯ��ׯ");
				ndil.update(nb);
				Nmsl nms=ndil.query(1);
				req.setAttribute("nmsl",nms);
				req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
			}else if(nmsl.getLocation().equals("֣��")) {
				Nmsl nb=new Nmsl("ʯ��ׯ",115.64358,38.10680,"�ѵ���ʯ��ׯ,���ڷ�������");
				ndil.update(nb);
				Nmsl nms=ndil.query(1);
				req.setAttribute("nmsl",nms);
				req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
			}else if(nmsl.getLocation().equals("ʯ��ׯ")) {
				Nmsl nb=new Nmsl("����",116.41667,39.91667,"�������ʹ�");
				ndil.update(nb);
				Nmsl nms=ndil.query(1);
				req.setAttribute("nmsl",nms);
				req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
			}else if(nmsl.getLocation().equals("����")) {
				Nmsl nb=new Nmsl("����",113.00001,28.21667,"�ѷ���");
				ndil.update(nb);
				Nmsl nms=ndil.query(1);
				req.setAttribute("nmsl",nms);
				req.getRequestDispatcher("backstage/jsp/department/userGroup/userGroup.jsp").forward(req, resp);
			}
			
		}else if(oper.equals("query_interim")) {
			//������ת�˵��Ĳ�ѯ
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int ModeCount=mdil.getQuery();//����ܼ�¼��
			ModePage pages=new ModePage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(ModeCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Mode> newsList=modebiz.QueryMode(pages.getCurrPageNo(), pages.getPageSize());
		   		pages.setListMode(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/transit/transfer/transfer.jsp").forward(req, resp);
		}else if(oper.equals("query_centre")) {
			//��ϸ��ѯ��ת��������Ϣ
			String number=req.getParameter("number");
			Mode modes=mdil.query_mode(number);
			req.setAttribute("number", number);
			req.setAttribute("modes", modes);
			
			String name=modes.getLocation();
			List<Transfer> trs=mdil.Query_Transfer(name);
			req.setAttribute("trs", trs);
	   	    req.getRequestDispatcher("backstage/jsp/transit/transfer/add_transfer.jsp").forward(req, resp);
		}else if(oper.equals("query_trark")) {
			//��ѯ���Ӧ����תվ����Ϣ
			PrintWriter out=resp.getWriter();//��ȥ��ӡ����
			String tr_name=req.getParameter("tr_name");
			
			Transfer transfer =mdil.query_Tra(tr_name);
			String tr_address=transfer.getTr_address()+",";
			String tr_phone=transfer.getTr_phone()+",";
			
			String msg=null;
			msg=tr_address;
			out.write(msg);
			msg=tr_phone;
			out.write(msg);
			out.close();
		}else if(oper.equals("query_phone")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int ModeCount=mdil.getMode();//����ܼ�¼��
			ModePage pages=new ModePage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(ModeCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Mode> newsList=modebiz.pageQueryMode(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListMode(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/carriage/state/status.jsp").forward(req, resp);
		}else if(oper.equals("query_phon")) {
			String number=req.getParameter("phone");
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int ModeCount=mdil.getQuery();//����ܼ�¼��
			ModePage pages=new ModePage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(ModeCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Mode> newsList=modebiz.QueryMode(pages.getCurrPageNo(), pages.getPageSize(),number);
		   		pages.setListMode(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/transit/transfer/transfer.jsp").forward(req, resp);
		}
	}
}
