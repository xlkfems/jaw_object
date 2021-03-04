package cn.com.relife.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.RoadmapaddDao;
import cn.com.relife.entity.Client;
import cn.com.relife.entity.Roadmapadd;
import cn.com.relife.util.JDBCUtil;

/**
 * @remark ·�߽ӿ�ʵ����
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public class RoadmapaddDaoImpl implements RoadmapaddDao{
	Connection conn = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JDBCUtil jdbc = new JDBCUtil();
	
	@Override
	public List<Roadmapadd> pageRoadmapaddAll(int page, int pageSize) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select * from roadmapadd limit "+pageNo+","+pageSize+"";
		//����·�߼��϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Roadmapadd> roadList = new ArrayList<Roadmapadd>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs=st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Roadmapadd roadmapadd = new Roadmapadd(rs.getInt(1), rs.getString(2),rs.getString(3));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				roadList.add(roadmapadd);
			}
		} catch (Exception e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return roadList;
	}

	@Override
	public int getTotalCount() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from roadmapadd;";
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
	/**
	 * ��ѯ������Ϣ
	 */
	@Override
	public Roadmapadd queryOne(int path_id) {
		Roadmapadd roadmapadd = null;
		conn = jdbc.getConnection();
		String sql = "select * from roadmapadd where path_id="+path_id+";";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				roadmapadd = new Roadmapadd(rs.getInt(1), rs.getString(2),rs.getString(3));
			}
		
		} catch (SQLException e) {
			System.out.println("��ѯ������Ϣ�쳣��");
			e.printStackTrace();
		}
		return roadmapadd;
	}
	/**
	 * ��������
	 */
	@Override
	public int addRoad(Roadmapadd road) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "insert into roadmapadd(path_city,path_scope) values('"+road.getPath_city()+"','"+road.getPath_scope()+"');";
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("jdbc:������Ϣ�ɹ���");
			}
		} catch (SQLException e) {
			System.out.println("������Ϣ�쳣��");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delRoad(int path_id) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "delete from roadmapadd where path_id="+path_id+";";
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("jdbc:ɾ��������Ϣ�ɹ���");
			}
		} catch (SQLException e) {
			System.out.println("ɾ���쳣��");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updRoad(Roadmapadd road) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "update roadmapadd set path_city='"+road.getPath_city()+"',path_scope='"+road.getPath_scope()+"' where path_id="+road.getPath_id()+";";
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("�޸���Ϣ�ɹ�");
			}
		} catch (SQLException e) {
			System.out.println("�޸���Ϣ�쳣��");
			e.printStackTrace();
		}		
		return result;
	}

	
	
}
