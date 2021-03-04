package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.MakeDao;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.Place;
import cn.com.relife.util.JDBCUtil;

public class MakeDaoImpl implements MakeDao{
	private Connection conn=null;//���Ӷ���
	private PreparedStatement pst=null;//Ԥ�������
	private Statement st=null;//�������
	private ResultSet rs=null;//���������
	//ʵ�����������ӳع���
	JDBCUtil jdbc=new JDBCUtil();
	
	public List<Make> pageQueryMake(int page, int pageSize) {
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
				Make make=new Make(rs.getInt("make_id"),rs.getString("fre_number"), rs.getString("state"), rs.getString("remark"),
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
	//�����ջ���
	public int addMake(Make make) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into make(make_date,moneystate,make_state,make_people,make_time,make_address,make_money,make_freight,remark,make_receipt,make,liaisons,phone,site,take_Name\r\n" + 
				",take_phone,take_site,fre_number,piece,bulk,support,clerk,state) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?\r\n" + 
				",?,?,?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, make.getMake_date());//��������
			pst.setString(2,make.getMoneystate());//���ʽ
			pst.setString(3,make.getMake_state());//ȡ����ʽ
			pst.setString(4,make.getMake_people());//��Ʊ��
			pst.setString(5,make.getMake_time());//��Ʊ����
			pst.setString(6,make.getMake_address());//��תվ
			pst.setString(7,make.getMake_money());//��ת��
			pst.setString(8,make.getMake_freight());//�˷�
			pst.setString(9,make.getRemark());//��ע
			pst.setString(10,make.getMake_receipt());//�ջ���
			pst.setString(11,make.getMake());//������
			pst.setString(12,make.getLiaisons());//�û�����
			pst.setString(13,make.getPhone());//�û��ֻ���
			pst.setString(14,make.getSite());//�û���ַ
			pst.setString(15,make.getTake_Name());//�ջ�����
			pst.setString(16,make.getTake_phone());//�ջ��ֻ���
			pst.setString(17,make.getTake_site());//�ջ���ַ
			pst.setString(18,make.getFre_number());//���˱��
			pst.setString(19,make.getPiece() );//����
			pst.setString(20, make.getBulk());//���
			pst.setString(21, make.getSupport());//���۷�
			pst.setString(22, make.getClerk());//ְԱ���
			pst.setString(23, make.getState());//״̬
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
	//��ѯ���������ͻ���Ϣ
	public Place query_userInfo(String number) {//��ѯ�����µ�״̬��
		Place place = new Place();
		//��һ������ȡ���ݿ�����
		conn =jdbc.getConnection();
		//�ڶ�������֯sql���
		String sql="select m_name,m_phone,m_address_block,a_name,a_phone,a_address_block,number,piece,insuredPrice,weight,state,pick,pl_money,remark  from place where number='"+number+"'";
		try {
			//����������������������
			st = conn.createStatement();
			//���Ĳ���ִ��sql��ѯ,��ִ�в�ѯ�����ֵ�����������
			rs = st.executeQuery(sql);
			//���岽��ʹ��ѭ��ȡ������
			while(rs.next()) {
				place.setM_name(rs.getString("m_name"));
				place.setM_phone(rs.getString("m_phone"));
				place.setM_address_block(rs.getString("m_address_block"));
				place.setA_name(rs.getString("a_name"));
				place.setA_phone(rs.getString("a_phone"));
				place.setA_address_block(rs.getString("a_address_block"));
				place.setNumber(rs.getString("number"));
				place.setPiece(rs.getString("piece"));//����
				place.setWeight(rs.getString("weight"));//���
				place.setInsuredPrice(rs.getString("insuredPrice"));//����
				place.setState(rs.getString("state"));
				place.setPick(rs.getString("pick"));
				place.setPl_money(rs.getString("pl_money"));
				place.setRemark(rs.getString("remark"));
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
	
	public List<Place> query_userInfo() {
		List<Place> placeList = new ArrayList<Place>();
		//��һ������ȡ���ݿ����Ӷ���
				conn = jdbc.getConnection();
				try {
					//�ڶ�������������������
					st = conn.createStatement();
					//����������֯sql���
					String sql="select number from place where state='������';";
					//���Ĳ���ִ��sql��ѯ����
					rs = st.executeQuery(sql);
					//���岽��ʹ��whileѭ���ӽ����������ȡ������
					while(rs.next()) {//�ж��Ƿ�ȡ������
						//ʵ��������ѧ������
						Place place = new Place();
						place.setNumber(rs.getString(1));
						//��ӵ����϶�����
						placeList.add(place);
					}
				} catch (Exception e) {
					System.out.println("��ѯ���ݿ�ʧ�ܣ�");
					e.printStackTrace();
				} finally {
					//���������ر����ݿ�
					jdbc.closeConnection(conn, st, null, rs);
				}
				return placeList;
	}

	@Override
	public Place query_refer(String number) {
		Place place = new Place();
		//��һ������ȡ���ݿ�����
		conn =jdbc.getConnection();
		//�ڶ�������֯sql���
		String sql="select cost,piece,weight  from place where number='"+number+"'";
		try {
			//����������������������
			st = conn.createStatement();
			//���Ĳ���ִ��sql��ѯ,��ִ�в�ѯ�����ֵ�����������
			rs = st.executeQuery(sql);
			//���岽��ʹ��ѭ��ȡ������
			while(rs.next()) {
				place.setInsuredPrice(rs.getString("cost"));
				place.setPiece(rs.getString("piece"));
				place.setWeight(rs.getString("weight"));
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
	public int updatePlace(String number) {
		int result =0;
		//��ȡ���ݿ�����
		conn = jdbc.getConnection();
		//��֯sql���
		String sql="update place set state='����' where number='"+number+"';";
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
	public Make queryMake(String number) {
		Make make = new Make();
		//��һ������ȡ���ݿ�����
		conn =jdbc.getConnection();
		//�ڶ�������֯sql���
		String sql="select make_date,moneystate,make_state,make_people,make_time,make_address,make_money,make_freight,remark,make_receipt,make,liaisons,phone,site,take_Name,take_phone,\r\n" + 
				"take_site,fre_number,piece,bulk,support,clerk,state\r\n" + 
				" from make where fre_number='"+number+"'";
		try {
			//����������������������
			st = conn.createStatement();
			//���Ĳ���ִ��sql��ѯ,��ִ�в�ѯ�����ֵ�����������
			rs = st.executeQuery(sql);
			//���岽��ʹ��ѭ��ȡ������
			while(rs.next()) {
				make.setMake_date(rs.getString("make_date"));
				make.setMoneystate(rs.getString("moneystate"));
				make.setMake_state(rs.getString("make_state"));
				make.setMake_people(rs.getString("make_people"));
				make.setMake_time(rs.getString("make_time"));
				make.setMake_address(rs.getString("make_address"));
				make.setMake_money(rs.getString("make_money"));
				make.setMake_freight(rs.getString("make_freight"));
				make.setRemark(rs.getString("remark"));
				make.setMake_receipt(rs.getString("make_receipt"));
				make.setMake(rs.getString("make"));
				make.setLiaisons(rs.getString("liaisons"));
				make.setPhone(rs.getString("phone"));
				make.setSite(rs.getString("site"));
				make.setTake_Name(rs.getString("take_Name"));
				make.setTake_phone(rs.getString("take_phone"));
				make.setTake_site(rs.getString("take_site"));
				make.setFre_number(rs.getString("fre_number"));
				make.setPiece(rs.getString("piece"));
				make.setBulk(rs.getString("bulk"));
				make.setSupport(rs.getString("support"));
				make.setClerk(rs.getString("clerk"));
				make.setState(rs.getString("state"));
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
	public int update_Make(String number, String make, String make_receipt, String make_freight) {
		int result =0;
		//��ȡ���ݿ�����
		conn = jdbc.getConnection();
		//��֯sql���
		String sql="update make set make='"+make+"',make_receipt='"+make_receipt+"',make_freight='"+make_freight+"' where fre_number='"+number+"';";
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
	public List<Make> pageQueryMake(int page, int pageSize, String number) {
		//�������ݿ�
				conn=jdbc.getConnection();
				//��֯sql��� ��ѯ
				int pageNo=(page-1)*pageSize;
				String sql="select * from make where state='����'  and fre_number='"+number+"' limit "+pageNo+","+pageSize+"";
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
						Make make=new Make(rs.getInt("make_id"),rs.getString("fre_number"), rs.getString("state"), rs.getString("remark"),
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

}
