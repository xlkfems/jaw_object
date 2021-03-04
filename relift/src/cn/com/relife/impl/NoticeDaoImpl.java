package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.NoticeDao;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Notice;
import cn.com.relife.util.JDBCUtil;

public class NoticeDaoImpl implements NoticeDao{
	private Connection conn=null;//���Ӷ���
	private PreparedStatement pst=null;//Ԥ�������
	private Statement st=null;//�������
	private ResultSet rs=null;//���������
	//ʵ�����������ӳع���
	JDBCUtil jdbc=new JDBCUtil();
	
	@Override
	public List<Notice> pageQueryMode(int page, int pageSize) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from notice limit "+pageNo+","+pageSize+"";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Notice> noticeList=new ArrayList<Notice>();
				try {
					//��������������
					st=conn.createStatement();
					//ִ��sql��� ��ѯ���� ���ý��������
					rs=st.executeQuery(sql);
					//ͨ��whileѭ���ó����ݿ�������
					while(rs.next()) {
						//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
						Notice notice=new Notice(rs.getInt("id"),rs.getString("title"),
								rs.getString("content"),rs.getString("date_time"));
						//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
						noticeList.add(notice);
					}
				} catch (Exception e) {
					System.out.println("��ѯʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return noticeList;
	}
	
	@Override
	public int getNotice() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from notice;";
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
	public Notice query(String number) {
		Notice mode = null;
		conn = jdbc.getConnection();
		String sql = "select * from notice where title='"+number+"';";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				mode = new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("��ѯ�����쳣");
			e.printStackTrace();
		}finally {
			//�ر����ݿ�
			jdbc.closeConnection(conn, null, pst, rs);
		}
		return mode;
	}

	@Override
	public int add(Notice notice) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into notice(title,content,date_time)values(?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,notice.getTitle());
			pst.setString(2,notice.getContent());
			pst.setString(3,notice.getDate_time());
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
	public int delete(String id) {
		int result =0;
		//��ȡ���ݿ�����
		conn = jdbc.getConnection();
		//��֯sql���
		String sql="delete from notice where id='"+id+"'";
		try {
			//����Ԥ�������
			pst = conn.prepareStatement(sql);
			//ִ��sql�޸Ĳ���
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("ɾ���ɹ���");
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
	public int query_hunan() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from transit where make LIKE '%����ʡ%'";
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
