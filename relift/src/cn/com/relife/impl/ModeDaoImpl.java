package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.ModeDao;
import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Clerk;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Transfer;
import cn.com.relife.util.JDBCUtil;

public class ModeDaoImpl implements ModeDao{
	private Connection conn=null;//���Ӷ���
	private PreparedStatement pst=null;//Ԥ�������
	private Statement st=null;//�������
	private ResultSet rs=null;//���������
	//ʵ�����������ӳع���
	JDBCUtil jdbc=new JDBCUtil();
	
	@Override
	public int add_mode(Mode mode) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into transit(fre_number,dr_number,make_receipt,make,con_receipt,location) values(?,?,?,?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,mode.getFre_number());
			pst.setString(2,mode.getDr_number());
			pst.setString(3,mode.getMake_receipt());
			pst.setString(4,mode.getMake());
			pst.setString(5,mode.getCon_receipt());
			pst.setString(6,mode.getLocation());
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
	public List<Mode> pageQueryMode(int page, int pageSize) {
		//�������ݿ�
		conn=jdbc.getConnection();
		//��֯sql��� ��ѯ
		int pageNo=(page-1)*pageSize;
		String sql="select * from transit limit "+pageNo+","+pageSize+"";
		//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
		List<Mode> modeList=new ArrayList<Mode>();
		try {
			//��������������
			st=conn.createStatement();
			//ִ��sql��� ��ѯ���� ���ý��������
			rs=st.executeQuery(sql);
			//ͨ��whileѭ���ó����ݿ�������
			while(rs.next()) {
				//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
				Mode mode=new Mode(rs.getInt("id"),rs.getString("fre_number"),
						rs.getString("dr_number"),rs.getString("make_receipt"),rs.getString("make")
						,rs.getString("con_receipt"),rs.getString("location"));
				//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
				modeList.add(mode);
			}
		} catch (Exception e) {
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return modeList;
	}

	@Override
	public int getMode() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from transit;";
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
	public int update_mode(String city, String number) {
		int result =0;
		//��ȡ���ݿ�����
		conn = jdbc.getConnection();
		//��֯sql���
		String sql="update transit set location='"+number+"' where fre_number='"+city+"';";
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
	public Mode query_mode(String number) {
		Mode mode = null;
		conn = jdbc.getConnection();
		String sql = "select * from transit where fre_number='"+number+"';";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				mode = new Mode(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
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
	public List<Mode> QueryMode(int page, int pageSize) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from transit where location!=make and location!=make_receipt and con_receipt='������'  limit "+pageNo+","+pageSize+"";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Mode> modeList=new ArrayList<Mode>();
				try {
					//��������������
					st=conn.createStatement();
					//ִ��sql��� ��ѯ���� ���ý��������
					rs=st.executeQuery(sql);
					//ͨ��whileѭ���ó����ݿ�������
					while(rs.next()) {
						//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
						Mode mode=new Mode(rs.getInt("id"),rs.getString("fre_number"),
								rs.getString("dr_number"),rs.getString("make_receipt"),rs.getString("make")
								,rs.getString("con_receipt"),rs.getString("location"));
						//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
						modeList.add(mode);
					}
				} catch (Exception e) {
					System.out.println("��ѯʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return modeList;
	}
	public List<Mode> QueryMode(int page, int pageSize,String number) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from transit where location!=make and location!=make_receipt and con_receipt='������'  and fre_number='"+number+"' limit "+pageNo+","+pageSize+"";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Mode> modeList=new ArrayList<Mode>();
				try {
					//��������������
					st=conn.createStatement();
					//ִ��sql��� ��ѯ���� ���ý��������
					rs=st.executeQuery(sql);
					//ͨ��whileѭ���ó����ݿ�������
					while(rs.next()) {
						//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
						Mode mode=new Mode(rs.getInt("id"),rs.getString("fre_number"),
								rs.getString("dr_number"),rs.getString("make_receipt"),rs.getString("make")
								,rs.getString("con_receipt"),rs.getString("location"));
						//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
						modeList.add(mode);
					}
				} catch (Exception e) {
					System.out.println("��ѯʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return modeList;
	}
	@Override
	public int getQuery() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from transit where location!=make and location!=make_receipt;";
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
	public List<Transfer> Query_Transfer(String tr_city) {
		//�������ݿ�
				conn=jdbc.getConnection();
				String sql="select * from transfer where tr_city='"+tr_city+"';";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Transfer> trabsList=new ArrayList<Transfer>();
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
						trabsList.add(stu);
					}
				} catch (Exception e) {
					System.out.println("��ѯʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return trabsList;
	}

	@Override
	public Transfer query_Tra(String tr_name) {
		Transfer tra = null;
		conn = jdbc.getConnection();
		String sql = "select * from transfer where tr_name='"+tr_name+"';";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				tra = new Transfer(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("��ѯ�����쳣");
			e.printStackTrace();
		}finally {
			//�ر����ݿ�
			jdbc.closeConnection(conn, null, pst, rs);
		}
		return tra;
	}

	@Override
	public int update_mod(String fre_number, String con_receipt) {
		int result =0;
		//��ȡ���ݿ�����
		conn = jdbc.getConnection();
		//��֯sql���
		String sql="update transit set con_receipt='"+con_receipt+"' where fre_number='"+fre_number+"';";
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
	public List<Mode> pageQueryMode(int page, int pageSize, String number) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from transit where fre_number='"+number+"' limit "+pageNo+","+pageSize+"";
				//����ѧ�����϶���  �����洢��ѯ�������ݿ���Ϣ
				List<Mode> modeList=new ArrayList<Mode>();
				try {
					//��������������
					st=conn.createStatement();
					//ִ��sql��� ��ѯ���� ���ý��������
					rs=st.executeQuery(sql);
					//ͨ��whileѭ���ó����ݿ�������
					while(rs.next()) {
						//ʵ��������ѧ������ ��ͨ�����췽����ֵ ����Ŵ����ݿ����ѯ������ֵ��
						Mode mode=new Mode(rs.getInt("id"),rs.getString("fre_number"),
								rs.getString("dr_number"),rs.getString("make_receipt"),rs.getString("make")
								,rs.getString("con_receipt"),rs.getString("location"));
						//ͨ�����Ϸ��� ��ѧ����Ϣ���뼯�϶���
						modeList.add(mode);
					}
				} catch (Exception e) {
					System.out.println("��ѯʧ��");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return modeList;
	}

}
