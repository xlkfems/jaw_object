package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.CentreDao;
import cn.com.relife.entity.Centre;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Place;
import cn.com.relife.util.JDBCUtil;

public class CentreDaoImpl implements CentreDao{
	private Connection conn=null;//���Ӷ���
	private PreparedStatement pst=null;//Ԥ�������
	private Statement st=null;//�������
	private ResultSet rs=null;//���������
	//ʵ�����������ӳع���
	JDBCUtil jdbc=new JDBCUtil();
	
	@Override
	public int add_Centre(Centre centre) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into centre(fre_number,location,dr_number,reception_time,tr_name,tr_address,tr_phone) values(?,?,?,?,?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,centre.getFre_number());
			pst.setString(2,centre.getLocation());
			pst.setString(3,centre.getDr_number());
			pst.setString(4,centre.getReception_time());
			pst.setString(5,centre.getTr_name());
			pst.setString(6,centre.getTr_address());
			pst.setString(7,centre.getTr_phone());
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
	public List<Centre> pageQueryCentre(int page, int pageSize) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from centre limit "+pageNo+","+pageSize+"";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Centre> centreList=new ArrayList<Centre>();
				try {
					//��������������
					st=conn.createStatement();
					//ִ��sql��� ��ѯ���� ���ý��������
					rs=st.executeQuery(sql);
					//ͨ��whileѭ���ó����ݿ�������
					while(rs.next()) {
						//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
						Centre centre=new Centre(rs.getInt("id"),rs.getString("fre_number"),
								rs.getString("location"),rs.getString("dr_number"),rs.getString("reception_time")
								,rs.getString("tr_name"),rs.getString("tr_address"),rs.getString("tr_phone"));
						//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
						centreList.add(centre);
					}
				} catch (Exception e) {
					System.out.println("��ѯʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return centreList;
	}
	
	public List<Centre> pageQueryCentre(int page, int pageSize,String number) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from centre where fre_number='"+number+"' limit "+pageNo+","+pageSize+"";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Centre> centreList=new ArrayList<Centre>();
				try {
					//��������������
					st=conn.createStatement();
					//ִ��sql��� ��ѯ���� ���ý��������
					rs=st.executeQuery(sql);
					//ͨ��whileѭ���ó����ݿ�������
					while(rs.next()) {
						//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
						Centre centre=new Centre(rs.getInt("id"),rs.getString("fre_number"),
								rs.getString("location"),rs.getString("dr_number"),rs.getString("reception_time")
								,rs.getString("tr_name"),rs.getString("tr_address"),rs.getString("tr_phone"));
						//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
						centreList.add(centre);
					}
				} catch (Exception e) {
					System.out.println("��ѯʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return centreList;
	}
	
	@Override
	public int getCentre() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from centre;";
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
	public List<Place> pageQueryPlace(int page, int pageSize) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select * from place where state='���ʹ�'  limit "+pageNo+","+pageSize+"";
		//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Place> placeList=new ArrayList<Place>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs=st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Place place=new Place(rs.getInt("id"),rs.getString("number"),
						rs.getString("pick"),rs.getString("money"));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				placeList.add(place);
			}
		} catch (Exception e) {
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return placeList;
	}
	
	public List<Place> pageQueryPlace(int page, int pageSize,String number) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select * from place where state='���ʹ�'  and number='"+number+"' limit "+pageNo+","+pageSize+"";
		//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Place> placeList=new ArrayList<Place>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs=st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Place place=new Place(rs.getInt("id"),rs.getString("number"),
						rs.getString("pick"),rs.getString("money"));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				placeList.add(place);
			}
		} catch (Exception e) {
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return placeList;
	}
	
	@Override
	public int getPlace() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from place;";
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

}
