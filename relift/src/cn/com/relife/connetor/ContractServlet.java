package cn.com.relife.connetor;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.relife.biz.ContractBiz;
import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Contract;
import cn.com.relife.entity.ContractPage;
import cn.com.relife.entity.DateTime;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.MakePage;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Place;
import cn.com.relife.impl.ContractDaoImpl;
import cn.com.relife.impl.ModeDaoImpl;
/**
 * @remark ���������Ʋ�
 * @author ���
 * @createTime 10��45��
 * version 1.0 
 */
public class ContractServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//���봦��
		resp.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");//�����߼���������
		ContractBiz contbiz=new ContractBiz();
		List<Bill> billList = new ArrayList<Bill>();
		ContractDaoImpl contra=new ContractDaoImpl();
		
		if(oper.equals("query_bill")) {
			//��ѯ�����Ѿ���д��ɵ�Ʊ����Ϣ����ʾ�������б���
			billList=contbiz.query_bill();
			req.setAttribute("billList", billList);
			req.getRequestDispatcher("backstage/jsp/vehicleControl/edit/edit.jsp").forward(req, resp);
		}else if(oper.equals("con_query")) {
			//ʹ��ajax������ˢ���Զ���ʾ��Ϣ
			String msg=null;
			String number=req.getParameter("number");//��ȡҳ�������б�ı����Ϣ
			Make make=contbiz.query_make(number);//����ȡ���ı�Ž������Ӧ�Ľӻ�����Ϣ�Ĳ�ѯ
			req.setAttribute("make", make);
			String cargo=make.getMake()+",";//������
			String delivery=make.getMake_receipt()+",";//�ջ���
			String take_name=make.getTake_Name()+",";//�ջ���
			String take_phone=make.getTake_phone()+",";//�ջ��绰
			String take_site=make.getTake_site()+", ";//�ջ���ַ
			String time=make.getMake_time()+",";//��д����
			//����Ϣʹ�ö��Ÿ�����ν��зָ�������
			PrintWriter out=resp.getWriter();//��ȥ��ӡ����
			//���߾����ж�Ԥ�Ƶ���ʱ��
			String make_cargo=make.getMake().substring(0,3);//�ջ�����Ϣ����
			String make_delivery=make.getMake_receipt().substring(0,3);//��������Ϣ����
			int scheduled=0;
			//ÿ��ʡԤ�Ƶ��������
			if(make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ")) {
				scheduled=1;
			}else if(make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ") || make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ")) {
				scheduled=2;
			}else if(make_cargo.equals("����ʡ")&&make_delivery.equals("�㶫ʡ") || make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ")) {
				scheduled=3;
			}else if(make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ") || make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ") || make_cargo.equals("����ʡ")&&make_delivery.equals("�㽭ʡ")
					|| make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ") || make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ")
					) {
				scheduled=4;
			}else if(make_cargo.equals("����ʡ")&&make_delivery.equals("�Ĵ�ʡ") || make_cargo.equals("����ʡ")&&make_delivery.equals("�ӱ�ʡ") || make_cargo.equals("����ʡ")&&make_delivery.equals("ɽ��ʡ")
					|| make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ")
					) {
				scheduled=5;
			}else if(make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ") || make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ") || make_cargo.equals("����ʡ")&&make_delivery.equals("������")) {
				scheduled=6;
			}else if(make_cargo.equals("����ʡ")&&make_delivery.equals("���ɹ�") || make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ")) {
				scheduled=7;
			}else if(make_cargo.equals("����ʡ")&&make_delivery.equals("ɽ��ʡ")) {
				scheduled=9;
			}else if(make_cargo.equals("����ʡ")&&make_delivery.equals("����ʡ")) {
				scheduled=10;
			}else if(make_cargo.equals("����ʡ")&&make_delivery.equals("������")) {
				scheduled=11;
			}
			//ʹ������ת�����д���
			DateTime datetime=new DateTime();//ʵ��������ʱ�����
			String expect=datetime.getDateStr(make.getMake_time(),scheduled)+",";//����ʱ��ת������
			//��ѯƱ�����Ӧ��˾�����
			Bill bill_number=contbiz.query_Bill(number);
			req.setAttribute("bill_number", bill_number);//����
			String dr_sj=bill_number.getBi_driver()+",";//��ȡ˾�����
			String remark=make.getRemark()+",";//��ע
			String moneystate=make.getMoneystate()+",";//���ʽ
			String make_freight=make.getMake_freight();//�˷�
			//����һ��һ�����д���
			msg=cargo;
			out.write(msg);
			msg=delivery;
			out.write(msg);
			msg=take_name;
			out.write(msg);
			msg=take_phone;
			out.write(msg);
			msg=take_site;
			out.write(msg);
			msg=time;
			out.write(msg);
			msg=expect;
			out.write(msg);
			msg=dr_sj;
			out.write(msg);
			msg=remark;
			out.write(msg);
			msg=moneystate;
			out.write(msg);
			msg=make_freight;
			out.write(msg);
			//�ر����������
			out.close();
		}else if(oper.equals("qurey_edit")) {
			//�������䵥������
			String number=req.getParameter("goodsRevertBillCode");//�������
			String cargo=req.getParameter("cargo");//װ���ص�
			String startCarryTime=req.getParameter("startCarryTime");//����ʱ��
			String delivery=req.getParameter("delivery");//�����ص�
			String receiveGoodsLinkman=req.getParameter("receiveGoodsLinkman");//�ջ���ϵ��
			String linkmanPhone=req.getParameter("linkmanPhone");//��ϵ�˵绰
			String receiveGoodsDetailAddr=req.getParameter("receiveGoodsDetailAddr");//�ջ���ϸ��ַ
			String carriageBanlanceMode=req.getParameter("carriageBanlanceMode");//�˷ѽ��㷽ʽ
			String remark=req.getParameter("remark");//��ע
			String driverId=req.getParameter("driverId");//˾�����
			String signTime=req.getParameter("signTime");//ǩ��ʱ��
			String allCarriage=req.getParameter("allCarriage");//���˷�
			String backBillState=req.getParameter("backBillState");//״̬
			//ʵ��������������󣬽�������ӽ�ȥ
			Contract contract=new Contract(number,delivery,cargo,startCarryTime,receiveGoodsLinkman,linkmanPhone,receiveGoodsDetailAddr,
					carriageBanlanceMode,remark,driverId,signTime,allCarriage,backBillState);
			int count=contbiz.add_edit(contract);//���䵥����������
			if(count>0) {
				//��������ɹ�֮��˾����ʽ��·�����佫����״̬��Ϊ������
				String state="������";//��������״̬
				String location=cargo;//��ǰλ��
				Mode mode=new Mode(number,driverId,delivery,cargo,state,location);//ʵ��������������
				ModeDaoImpl mdis= new ModeDaoImpl();//ʵ��������ʵ�����������
				mdis.add_mode(mode);//���䵥������
				int dcide=contbiz.update(number);//�޸Ķ���״̬
				req.getRequestDispatcher("backstage/jsp/vehicleControl/edit/edit.jsp").forward(req, resp);
			}
		}else if(oper.equals("query_contra")) {
			//�������䶩���ķ�ҳ����
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);//����ǰҳ���������ת��
			int ContraCount=contra.getContract();//����ܼ�¼��
			ContractPage pages=new ContractPage();//ʵ����������ҳ����
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(ContraCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Contract> newsList=contbiz.pageQueryContract(pages.getCurrPageNo(), pages.getPageSize());
		    	pages.setListContract(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/vehicleControl/select/select.jsp").forward(req, resp);
		}else if(oper.equals("contract_query")) {
			//�������䵥����Ĳ�ѯ
			String number=req.getParameter("number");//��ȡ���˱��
			Contract contract=contbiz.query_Contract(number);
			req.setAttribute("contract", contract);
			req.getRequestDispatcher("backstage/jsp/vehicleControl/select/query_select.jsp").forward(req, resp);
		}else if(oper.equals("update_contract")) {
			//�������䵥�Ĳ�ѯ
			String number=req.getParameter("number");//���Ϸ���ͬ����Ҫ��Ҫ�ֳ���������ת����ҳ��Բ�ͬ
			Contract contract=contbiz.query_Contract(number);
			req.setAttribute("contract", contract);
			req.getRequestDispatcher("backstage/jsp/vehicleControl/select/update_select.jsp").forward(req, resp);
		}else if(oper.equals("update_alter")){
			//�޸������䶩��������
			String number=req.getParameter("goodsRevertBillCode");//��ȡ�������
			String loadStation=req.getParameter("loadStation");//��ȡ������
			String dealGoodsStation=req.getParameter("dealGoodsStation");//��ȡ�ջ���
			String allCarriage=req.getParameter("allCarriage");//��ȡ����״̬
			
			int count=contbiz.update_alter(number, loadStation, dealGoodsStation, allCarriage);//����������״̬����д
			Contract contract=contbiz.query_Contract(number);//��ѯ���������ͬ
			req.setAttribute("contract", contract);
			req.getRequestDispatcher("backstage/jsp/vehicleControl/select/update_select.jsp").forward(req, resp);
		}else if(oper.equals("query_phone")) {
			//����������Ĳ�ѯ
			String number=req.getParameter("phone");//��ȡ��ҳ��ı��
			//�����ٴ�ִ�з�ҳ��ѯ
			String pageIndex= req.getParameter("pageNo");//��õ�ǰҳ��
		    if(pageIndex== null){
		        pageIndex= "1";
		    }
		    int currPageNo = Integer.parseInt(pageIndex);
			int ContraCount=contra.getContract();//����ܼ�¼��
			ContractPage pages=new ContractPage();
			pages.setPageSize(8);    //����ÿҳ����
			pages.setTotalCount(ContraCount);   //�����ܼ�¼��
			int totalpages= pages.getTotalPageCount();
			/*����ҳ��ĩҳ���п���*/
		    if(currPageNo < 1){
		        currPageNo = 1;
		    }else if(currPageNo > pages.getTotalPageCount()){
		        currPageNo = totalpages;
		    }
		    pages.setCurrPageNo(currPageNo);    //���õ�ǰҳ��
		    List<Contract> newsList=contbiz.pageQueryContract(pages.getCurrPageNo(), pages.getPageSize(),number);
		    	pages.setListContract(newsList);  //����ÿҳ��ʾ�ļ���
		   	    req.setAttribute("pages", pages);
		   	    req.getRequestDispatcher("backstage/jsp/vehicleControl/select/select.jsp").forward(req, resp);
		}
	}
}
