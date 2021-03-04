package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.PlaceDao;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.Place;
import cn.com.relife.util.JDBCUtil;

public class PlaneDaoImpl implements PlaceDao{
	private Connection conn=null;//���Ӷ���
	private PreparedStatement pst=null;//Ԥ�������
	private Statement st=null;//�������
	private ResultSet rs=null;//���������
	//ʵ�����������ӳع���
	JDBCUtil jdbc=new JDBCUtil();
	
	public List<Place> pageQueryPla(int page, int pageSize) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select id,number,state from place limit "+pageNo+","+pageSize+"";
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
						Place place=new Place(rs.getInt(1),rs.getString(2), rs.getString(3));
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

	public Place query_place(String number) {
		Place place = new Place();
		//��һ������ȡ���ݿ�����
		conn =jdbc.getConnection();
		//�ڶ�������֯sql���
		String sql="select number,m_name,m_phone,m_address_block,a_name,a_phone,a_address_block,cargo,weight," + 
				"type,insuredPrice,days,pick,money,remark,state,piece,pl_money from place where number='"+number+"'";
		try {
			//����������������������
			st = conn.createStatement();
			//���Ĳ���ִ��sql��ѯ,��ִ�в�ѯ�����ֵ�����������
			rs = st.executeQuery(sql);
			//���岽��ʹ��ѭ��ȡ������
			while(rs.next()) {
				place.setNumber(rs.getString("number"));
				place.setM_name(rs.getString("m_name"));
				place.setM_phone(rs.getString("m_phone"));
				place.setM_address_block(rs.getString("m_address_block"));
				place.setA_name(rs.getString("a_name"));
				place.setA_phone(rs.getString("a_phone"));
				place.setA_address_block(rs.getString("a_address_block"));
				place.setCargo(rs.getString("cargo"));
				place.setWeight(rs.getString("weight"));
				place.setType(rs.getString("type"));
				place.setInsuredPrice(rs.getString("insuredPrice"));
				place.setDays(rs.getString("days"));
				place.setPick(rs.getString("pick"));
				place.setMoney(rs.getString("money"));
				place.setState(rs.getString("state"));
				place.setRemark(rs.getString("remark"));
				place.setPiece(rs.getString("piece"));
				place.setPl_money(rs.getString("pl_money"));
			}
			if(place!=null) {
				System.out.println("��ѯ�ɹ���");
			}
		} catch (Exception e) {
			System.out.println("��ѯʧ�ܣ�");
			e.printStackTrace();
		} finally {
			//���������ر����ݿ�
			jdbc.closeConnection(conn, st, null, rs);
		}
		return place;
	}

	@Override
	public int update_place(String number, String state) {
		int result =0;
		//��ȡ���ݿ�����
		conn = jdbc.getConnection();
		//��֯sql���
		String sql="update place set state='"+state+"' where number='"+number+"';";
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
	public List<Place> pageQueryPlace(int page, int pageSize) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select id,number,state,pick,pl_money,type from place where state='�ѽ���'  limit "+pageNo+","+pageSize+"";
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
				Place place=new Place(rs.getInt("id"),rs.getString("number"), rs.getString("pick"),rs.getString("pl_money"),rs.getString("type"));
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
		String sql="select id,number,state,pick,pl_money,type from place where state='�ѽ���'  and number='"+number+"'  limit "+pageNo+","+pageSize+"";
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
				Place place=new Place(rs.getInt("id"),rs.getString("number"), rs.getString("pick"),rs.getString("pl_money"),rs.getString("type"));
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
	public List<Place> pageQueryReport(int page, int pageSize) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select id,number,m_name,m_address_block,a_name,a_address_block from place limit "+pageNo+","+pageSize+"";
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
				Place place=new Place(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
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
	public List<Place> pageQueryPla(int page, int pageSize, String number) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select id,number,state from place where number='"+number+"' limit "+pageNo+","+pageSize+"";
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
				Place place=new Place(rs.getInt(1),rs.getString(2), rs.getString(3));
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

}
