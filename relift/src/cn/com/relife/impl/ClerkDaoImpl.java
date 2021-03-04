package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.ClerkDao;
import cn.com.relife.entity.Clerk;
import cn.com.relife.util.JDBCUtil;
/**
 * @remark ְԱ�ӿ�ʵ����
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public class ClerkDaoImpl implements ClerkDao{
	Connection conn=null;//���Ӷ���
	PreparedStatement pst=null;//Ԥ�������
	Statement st=null;//�������
	ResultSet rs=null;//���������
	//ʵ�����������ӳع���
	JDBCUtil jdbc=new JDBCUtil();
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	@Override
	public List<Clerk> pageQueryTra(int page, int pageSize) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select * from clerk limit "+pageNo+","+pageSize+"";
		//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Clerk> cleList=new ArrayList<Clerk>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs=st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Clerk cle=new Clerk(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				cleList.add(cle);
			}
		} catch (Exception e) {
			System.out.println("��ѯȫ��ְԱʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return cleList;
	}
	public List<Clerk> pageQueryTra(int page, int pageSize,String number) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select * from clerk where cl_number='"+number+"' limit "+pageNo+","+pageSize+"";
		//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Clerk> cleList=new ArrayList<Clerk>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs=st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Clerk cle=new Clerk(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				cleList.add(cle);
			}
		} catch (Exception e) {
			System.out.println("��ѯȫ��ְԱʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return cleList;
	}
	@Override
	public int getTotalCount() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from clerk;";
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
	public int addClerk(Clerk clerk) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "insert into clerk(cl_name,cl_number,cl_section,cl_sex,cl_time) values(?,?,?,?,?);";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, clerk.getCl_name());
			pst.setString(2, clerk.getCl_number());
			pst.setString(3, clerk.getCl_section());
			pst.setString(4, clerk.getCl_sex());
			pst.setString(5, clerk.getCl_time());
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("jdbc:����ְԱ��Ϣ�ɹ���");
			}
		} catch (SQLException e) {
			System.out.println("����ְԱ��Ϣ�쳣��");
			e.printStackTrace();
		} finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return result;
	}

	@Override
	public int delClerk(int id) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "delete from clerk where cl_id="+id+";";
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("jdbc:ɾ����Ϣ�ɹ���");
			}
		} catch (SQLException e) {
			System.out.println("ɾ����Ϣ�쳣��");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Clerk queryOne(int id) {
		Clerk clerk = null;
		conn = jdbc.getConnection();
		String sql = "select * from clerk where cl_id="+id+";";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			 clerk = new Clerk(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("��ѯ����ְԱ��Ϣ�쳣");
			e.printStackTrace();
		}
		return clerk;
	}

	@Override
	public int updaClerk(Clerk clerk) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "update clerk set cl_name='"+clerk.getCl_name()+"',cl_section='"+clerk.getCl_section()+"',cl_sex='"+clerk.getCl_sex()+"',cl_time='"+clerk.getCl_time()+"' where cl_id="+clerk.getCl_id()+";";
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
