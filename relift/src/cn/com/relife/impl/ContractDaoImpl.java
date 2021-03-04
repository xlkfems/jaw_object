package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.ContractDao;
import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Contract;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.Place;
import cn.com.relife.util.JDBCUtil;
/**
 * @remark �䳵��ʵ����
 * @author ���
 * @createTime 10��11��
 * @version 1.0
 */
public class ContractDaoImpl implements ContractDao{
	private Connection conn=null;//���Ӷ���
	private PreparedStatement pst=null;//Ԥ�������
	private Statement st=null;//�������
	private ResultSet rs=null;//���������
	//ʵ�����������ӳع���
	JDBCUtil jdbc=new JDBCUtil();
	List<Bill> billList = new ArrayList<Bill>();
	
	@Override
	public List<Bill> query_bill() {
		//��һ������ȡ���ݿ����Ӷ���
		conn = jdbc.getConnection();
		
		try {
			//�ڶ�������������������
			st = conn.createStatement();
			//����������֯sql���
			String sql="select bi_number from bill";
			//���Ĳ���ִ��sql��ѯ����
			rs = st.executeQuery(sql);
			//���岽��ʹ��whileѭ���ӽ����������ȡ������
			while(rs.next()) {//�ж��Ƿ�ȡ������
				//ʵ��������ѧ������
				Bill bill = new Bill();
				bill.setBi_number(rs.getString(1));
				//��ӵ����϶�����
				billList.add(bill);
			}
		} catch (Exception e) {
			System.out.println("��ѯ���ݿ�ʧ�ܣ�");
			e.printStackTrace();
		} finally {
			//���������ر����ݿ�
			jdbc.closeConnection(conn, st, null, rs);
		}
		return billList;
	}

	@Override
	public Make query_make(String fre_number) {
		Make make = new Make();
		//��һ������ȡ���ݿ�����
		conn =jdbc.getConnection();
		//�ڶ�������֯sql���
		String sql="select make_receipt,make,take_Name,take_phone,take_site,make_time,remark,moneystate,make_freight  from make where fre_number='"+fre_number+"';";
		try {
			//����������������������
			st = conn.createStatement();
			//���Ĳ���ִ��sql��ѯ,��ִ�в�ѯ�����ֵ�����������
			rs = st.executeQuery(sql);
			//���岽��ʹ��ѭ��ȡ������
			while(rs.next()) {
				make.setMake(rs.getString("make"));
				make.setMake_receipt(rs.getString("make_receipt"));
				make.setTake_Name(rs.getString("take_Name"));
				make.setTake_phone(rs.getString("take_phone"));
				make.setTake_site(rs.getString("take_site"));
				make.setMake_time(rs.getString("make_time"));
				make.setRemark(rs.getString("remark"));
				make.setMoneystate(rs.getString("moneystate"));
				make.setMake_freight(rs.getString("make_freight"));
			}
			if(make!=null) {
				System.out.println("��ѯ�ɹ���");
			}
		} catch (Exception e) {
			System.out.println("��ѯʧ�ܣ�");
			e.printStackTrace();
		} finally {
			//���������ر����ݿ�
			jdbc.closeConnection(conn, st, null, rs);
		}
		return make;
	}

	@Override
	public int add_edit(Contract contract) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into contract(fre_number,make_receipt,make,bi_state,take_Name,\r\n" + 
				"take_phone,take_site,con_close,con_remark,dr_number,con_time,con_freight,con_receipt\r\n" + 
				") values(?,?,?,?,?,?,?,?,?,?,?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,contract.getFre_number());
			pst.setString(2,contract.getMake_receipt());
			pst.setString(3,contract.getMake());
			pst.setString(4,contract.getBi_state());
			pst.setString(5,contract.getTake_Name());
			pst.setString(6,contract.getTake_phone());
			pst.setString(7,contract.getTake_site());
			pst.setString(8,contract.getCon_close());
			pst.setString(9,contract.getCon_remark());
			pst.setString(10,contract.getDr_number());
			pst.setString(11,contract.getCon_time());
			pst.setString(12,contract.getCon_freight());
			pst.setString(13,contract.getCon_receipt());
			count=pst.executeUpdate();
			if(count>1) {
				System.out.println("�����ɹ�");
			}
		} catch (SQLException e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		} finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return count;
	}

	@Override
	public Bill query_Bill(String number) {
		Bill bill = new Bill();
		//��һ������ȡ���ݿ�����
		conn =jdbc.getConnection();
		//�ڶ�������֯sql���
		String sql="select bi_driver from bill where bi_number='"+number+"'";
		try {
			//����������������������
			st = conn.createStatement();
			//���Ĳ���ִ��sql��ѯ,��ִ�в�ѯ�����ֵ�����������
			rs = st.executeQuery(sql);
			//���岽��ʹ��ѭ��ȡ������
			while(rs.next()) {
				bill.setBi_driver(rs.getString("bi_driver"));
			}
			if(bill!=null) {
				System.out.println("��ѯ�ɹ���");
			}
		} catch (Exception e) {
			System.out.println("��ѯʧ�ܣ�");
			e.printStackTrace();
		} finally {
			//���������ر����ݿ�
			jdbc.closeConnection(conn, st, null, rs);
		}
		return bill;
	}

	@Override
	public List<Contract> pageQueryContract(int page, int pageSize) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select * from contract limit "+pageNo+","+pageSize+"";
		//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Contract> contractList=new ArrayList<Contract>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs=st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Contract contract=new Contract(rs.getInt("con_id"),rs.getString("fre_number"),rs.getString("con_receipt"),rs.getString("take_Name"));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				contractList.add(contract);
			}
		} catch (Exception e) {
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return contractList;
	}

	@Override
	public int getContract() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from contract;";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return count;
	}

	@Override
	public Contract query_Contract(String number) {
		Contract contract = new Contract();
		//��һ������ȡ���ݿ�����
		conn =jdbc.getConnection();
		//�ڶ�������֯sql���
		String sql="select * from contract where fre_number='"+number+"'";
		try {
			//����������������������
			st = conn.createStatement();
			//���Ĳ���ִ��sql��ѯ,��ִ�в�ѯ�����ֵ�����������
			rs = st.executeQuery(sql);
			//���岽��ʹ��ѭ��ȡ������
			while(rs.next()) {
				contract.setFre_number(rs.getString("fre_number"));
				contract.setMake_receipt(rs.getString("make_receipt"));
				contract.setMake(rs.getString("make"));
				contract.setBi_state(rs.getString("bi_state"));
				contract.setTake_Name(rs.getString("take_Name"));
				contract.setTake_phone(rs.getString("take_phone"));
				contract.setTake_site(rs.getString("take_site"));
				contract.setCon_close(rs.getString("con_close"));
				contract.setCon_remark(rs.getString("con_remark"));
				contract.setDr_number(rs.getString("dr_number"));
				contract.setCon_time(rs.getString("con_time"));
				contract.setCon_freight(rs.getString("con_freight"));
				contract.setCon_receipt(rs.getString("con_receipt"));
			}
			if(contract!=null) {
				System.out.println("��ѯ�ɹ���");
			}
		} catch (Exception e) {
			System.out.println("��ѯʧ�ܣ�");
			e.printStackTrace();
		} finally {
			//���������ر����ݿ�
			jdbc.closeConnection(conn, st, null, rs);
		}
		return contract;
	}

	@Override
	public int update(String number) {
		int result =0;
		//��ȡ���ݿ�����
		conn = jdbc.getConnection();
		//��֯sql���
		String sql="update place set state='���䳵' where number='"+number+"';";
		try {
			//����Ԥ�������
			pst = conn.prepareStatement(sql);
			//ִ��sql�޸Ĳ���
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("�޸ĳɹ���");
			}
		} catch (Exception e) {
			System.out.println("�޸�ʧ�ܣ�");
			e.printStackTrace();
		} finally {
			//�ر����ݿ�
			jdbc.closeConnection(conn, null, pst, rs);
		}
		return result;
	}

	@Override
	public int update_alter(String number, String loadStation, String dealGoodsStation, String allCarriage) {
		int result =0;
		//��ȡ���ݿ�����
		conn = jdbc.getConnection();
		//��֯sql���
		String sql="update contract set con_freight='"+allCarriage+"',make_receipt='"+dealGoodsStation+"',make='"+loadStation+"' where fre_number='"+number+"';";
		try {
			//����Ԥ�������
			pst = conn.prepareStatement(sql);
			//ִ��sql�޸Ĳ���
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("�޸ĳɹ���");
			}
		} catch (Exception e) {
			System.out.println("�޸�ʧ�ܣ�");
			e.printStackTrace();
		} finally {
			//�ر����ݿ�
			jdbc.closeConnection(conn, null, pst, rs);
		}
		return result;
	}

	@Override
	public List<Contract> pageQueryContract(int page, int pageSize, String number) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from contract where fre_number='"+number+"' limit "+pageNo+","+pageSize+"";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Contract> contractList=new ArrayList<Contract>();
				try {
					//��������������
					st=conn.createStatement();
					//ִ��sql��� ��ѯ���� ���ý��������
					rs=st.executeQuery(sql);
					//ͨ��whileѭ���ó����ݿ�������
					while(rs.next()) {
						//ʵ��������ѧ������ ��ͨ�����췽����ֵ (id����š�״̬������)
						Contract contract=new Contract(rs.getInt("con_id"),rs.getString("fre_number"),rs.getString("con_receipt"),rs.getString("take_Name"));
						//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
						contractList.add(contract);
					}
				} catch (Exception e) {
					System.out.println("��ѯʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return contractList;
	}

	

}
