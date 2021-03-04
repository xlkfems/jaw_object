package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.TransferDao;
import cn.com.relife.entity.Transfer;
import cn.com.relife.util.JDBCUtil;

public class TransferDaoImpl implements TransferDao{
	private Connection conn=null;//���Ӷ���
	private PreparedStatement pst=null;//Ԥ�������
	private Statement st=null;//�������
	private ResultSet rs=null;//���������
	//ʵ�����������ӳع���
	JDBCUtil jdbc=new JDBCUtil();
	
	
	public List<Transfer> pageQueryTra(int page, int pageSize) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from transfer limit "+pageNo+","+pageSize+"";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Transfer> stuList=new ArrayList<Transfer>();
				try {
					//��������������
					st=conn.createStatement();
					//ִ��sql��� ��ѯ���� ���ý��������
					rs=st.executeQuery(sql);
					//ͨ��whileѭ���ó����ݿ�������
					while(rs.next()) {
						//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
						Transfer stu=new Transfer(rs.getInt(1), rs.getString(2), rs.getString(3),
								rs.getString(4),rs.getString(5),rs.getString(6));
						//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
						stuList.add(stu);
					}
				} catch (Exception e) {
					System.out.println("����ʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return stuList;
	}

	public int getTotalCount() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from transfer;";
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

	public int addTtansfer(Transfer transfer) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into transfer(tr_city,tr_name,tr_phone,tr_address,tr_longitude) values(?,?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, transfer.getTr_city());
			pst.setString(2, transfer.getTr_name());
			pst.setString(3, transfer.getTr_phone());
			pst.setString(4, transfer.getTr_address());
			pst.setString(5, transfer.getTr_longitude());
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
	public List<Transfer> pageQueryTra() {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		String sql="select * from transfer ";
		//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Transfer> stuList=new ArrayList<Transfer>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs=st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Transfer stu=new Transfer(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				stuList.add(stu);
			}
		} catch (Exception e) {
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return stuList;
	}
	
}
