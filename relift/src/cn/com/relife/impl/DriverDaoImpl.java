package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.DriverDao;
import cn.com.relife.entity.Driver;
import cn.com.relife.util.JDBCUtil;
/**
 * @remark ˾���ӿ�ʵ����
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public class DriverDaoImpl implements DriverDao{
	Connection conn = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JDBCUtil jdbc = new JDBCUtil();
	@Override
	public List<Driver> pageDriverAll(int page, int pageSize) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select * from driver limit "+pageNo+","+pageSize+"";
		//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Driver> driverList=new ArrayList<Driver>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs = st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������˾������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Driver dri = new Driver(rs.getInt(1), rs.getString(2), rs.getString(3)
						, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
						, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)
						,rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17)
						,rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				driverList.add(dri);
			}
		} catch (Exception e) {
			System.out.println("jdbc:����ʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return driverList;
	}
	public List<Driver> pageDriverAll(int page, int pageSize,String number) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select * from driver where dr_number='"+number+"' limit "+pageNo+","+pageSize+"";
		//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Driver> driverList=new ArrayList<Driver>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs = st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������˾������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Driver dri = new Driver(rs.getInt(1), rs.getString(2), rs.getString(3)
						, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
						, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)
						,rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17)
						,rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				driverList.add(dri);
			}
		} catch (Exception e) {
			System.out.println("jdbc:����ʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return driverList;
	}
	@Override
	public int getTotalCount() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from driver;";
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
	public Driver queryOne(int id) {
		Driver driver = null;
		conn = jdbc.getConnection();
		String sql = "select * from driver where dr_id="+id+";";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				driver = new Driver(rs.getInt(1), rs.getString(2), rs.getString(3)
						, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
						, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)
						,rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17)
						,rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23));
			}
		} catch (SQLException e) {
			System.out.println("��ѯ�����쳣");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return driver;
	}
	
	/**
	 * ����˾����Ϣ����
	 */
	@Override
	public int addDriver(Driver driver) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "insert into driver(dr_number,dr_name,dr_identity,dr_phone,dr_sex,dr_hoday,dr_car,dr_state,dr_volume,dr_load,dr_address,dr_long,dr_width,dr_length,dr_licence,dr_xing,dr_run,dr_vin,dr_unit,unit_phone,dr_company,dr_remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, driver.getDr_number());
			pst.setString(2, driver.getDr_name());
			pst.setString(3, driver.getDr_identity());
			pst.setString(4, driver.getDr_phone());
			pst.setString(5, driver.getDr_sex());
			pst.setString(6, driver.getDr_hoday());
			pst.setString(7, driver.getDr_car());
			pst.setString(8, driver.getDr_state());
			pst.setString(9, driver.getDr_volume());
			pst.setString(10, driver.getDr_load());
			pst.setString(11, driver.getDr_address());
			pst.setString(12, driver.getDr_long());
			pst.setString(13, driver.getDr_width());
			pst.setString(14, driver.getDr_length());
			pst.setString(15, driver.getDr_licence());
			pst.setString(16, driver.getDr_xing());
			pst.setString(17, driver.getDr_run());
			pst.setString(18, driver.getDr_vin());
			pst.setString(19, driver.getDr_unit());
			pst.setString(20, driver.getUnit_phone());
			pst.setString(21, driver.getDr_company());
			pst.setString(22, driver.getDr_remark());
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("jdbc:����˾����Ϣ�ɹ���");
			}
		} catch (SQLException e) {
			System.out.println("����˾����Ϣʧ��!");
			e.printStackTrace();
		} finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return result;
	}

	@Override
	public int delDriver(int id) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "delete from driver where dr_id="+id+";";
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("jdbc:ɾ��������Ϣ�ɹ���");
			}
		} catch (SQLException e) {
			System.out.println("ɾ���쳣��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return result;
	}

	@Override
	public int updDriver(Driver driver) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "update driver set dr_name='"+driver.getDr_name()+"',dr_identity='"+driver.getDr_identity()+"',dr_phone='"+driver.getDr_phone()+"',dr_sex='"+driver.getDr_sex()+"',dr_hoday='"+driver.getDr_hoday()+"',dr_car='"+driver.getDr_car()+"',dr_state='"+driver.getDr_state()+"',dr_volume='"+driver.getDr_volume()+"',dr_load='"+driver.getDr_load()+"',dr_address='"+driver.getDr_address()+"',dr_long='"+driver.getDr_long()+"',dr_width='"+driver.getDr_width()+"',dr_length='"+driver.getDr_length()+"',dr_licence='"+driver.getDr_licence()+"',dr_xing='"+driver.getDr_xing()+"',dr_run='"+driver.getDr_run()+"',dr_vin='"+driver.getDr_vin()+"',dr_unit='"+driver.getDr_unit()+"',unit_phone='"+driver.getUnit_phone()+"',dr_company='"+driver.getDr_company()+"',dr_remark='"+driver.getDr_remark()+"' where dr_id="+driver.getDr_id()+";";
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("�޸���Ϣ�ɹ�");
			}
		} catch (SQLException e) {
			System.out.println("�޸���Ϣ�쳣��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return result;
	}

}
