package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.BillDao;
import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.Place;
import cn.com.relife.util.JDBCUtil;

public class BillDaoImpl implements BillDao{
	private Connection conn=null;//���Ӷ���
	private PreparedStatement pst=null;//Ԥ�������
	private Statement st=null;//�������
	private ResultSet rs=null;//���������
	//ʵ�����������ӳع���
	JDBCUtil jdbc=new JDBCUtil();
	List<Driver> driverList = new ArrayList<Driver>();
	@Override
	public List<Make> pageQueryBill(int page, int pageSize) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from make where state='����'  limit "+pageNo+","+pageSize+"";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Make> makeList=new ArrayList<Make>();
				try {
					//��������������
					st=conn.createStatement();
					//ִ��sql��� ��ѯ���� ���ý��������
					rs=st.executeQuery(sql);
					//ͨ��whileѭ���ó����ݿ�������
					while(rs.next()) {
						//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
						Make make=new Make(rs.getInt("make_id"),rs.getString("fre_number"),
								rs.getString("make_time"));
						//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
						makeList.add(make);
					}
				} catch (Exception e) {
					System.out.println("��ѯʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return makeList;
	}
	@Override
	public int getMake() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from make;";
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
	public List<Driver> query_driver(String dr_address) {
		//��һ������ȡ���ݿ����Ӷ���
				conn = jdbc.getConnection();
				
				try {
					//�ڶ�������������������
					st = conn.createStatement();
					//����������֯sql���
					String sql="select dr_number from driver where dr_vin='����'  and dr_address LIKE '%"+dr_address+"%'";
					//���Ĳ���ִ��sql��ѯ����
					rs = st.executeQuery(sql);
					//���岽��ʹ��whileѭ���ӽ����������ȡ������
					while(rs.next()) {//�ж��Ƿ�ȡ������
						//ʵ��������ѧ������
						Driver driver = new Driver();
						driver.setDr_number(rs.getString(1));
						//��ӵ����϶�����
						driverList.add(driver);
					}
				} catch (Exception e) {
					System.out.println("��ѯ���ݿ�ʧ�ܣ�");
					e.printStackTrace();
				} finally {
					//���������ر����ݿ�
					jdbc.closeConnection(conn, st, null, rs);
				}
				return driverList;
	}
	@Override
	public List<Bill> QueryBill(int page, int pageSize) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select * from bill limit "+pageNo+","+pageSize+"";
		//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Bill> billList=new ArrayList<Bill>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs=st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Bill bill=new Bill(rs.getInt("bi_id"),rs.getString("bi_number"),
						rs.getString("bi_date"),rs.getString("state"));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				billList.add(bill);
			}
		} catch (Exception e) {
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return billList;
	}
	@Override
	public int getBill() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from bill;";
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
	public int add_Bill(Bill bill) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into bill(bi_number,bi_date,bi_state,bi_driver,make_cargo,distribute,state) value(?,?,?,?,?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, bill.getBi_number());//���˱��
			pst.setString(2, bill.getBi_date());//��д����
			pst.setString(3, bill.getBi_state());//��Ʊʱ��
			pst.setString(4, bill.getBi_driver());//��Ʊ��
			pst.setString(5, bill.getMake_cargo());//�ӻ���
			pst.setString(6, bill.getDistribute());//�ַ���
			pst.setString(7, bill.getState());//״̬
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
	public int update_bill(String fre_number) {
		int result =0;
		//��ȡ���ݿ�����
		conn = jdbc.getConnection();
		//��֯sql���
		String sql="update make set state='���䳵' where fre_number='"+fre_number+"'";
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
	public int update_driver(String dr_number) {
		int result =0;
		//��ȡ���ݿ�����
		conn = jdbc.getConnection();
		//��֯sql���
		String sql="update driver set dr_vin='������' where dr_number='"+dr_number+"'";
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
	public List<Bill> pageQueryBill(int page, int pageSize, String number) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from bill where bi_number='"+number+"' limit "+pageNo+","+pageSize+"";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Bill> billList=new ArrayList<Bill>();
				try {
					//��������������
					st=conn.createStatement();
					//ִ��sql��� ��ѯ���� ���ý��������
					rs=st.executeQuery(sql);
					//ͨ��whileѭ���ó����ݿ�������
					while(rs.next()) {
						//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
						Bill bill=new Bill(rs.getInt("bi_id"),rs.getString("bi_number"),
								rs.getString("bi_date"),rs.getString("state"));
						//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
						billList.add(bill);
					}
				} catch (Exception e) {
					System.out.println("��ѯʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return billList;
	}
}
