package cn.com.relife.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.ClientDao;
import cn.com.relife.entity.Clerk;
import cn.com.relife.entity.Client;
import cn.com.relife.util.JDBCUtil;

/**
 * @remark 客户接口实现类
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public class ClientDaoImpl implements ClientDao{
	Connection conn = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JDBCUtil jdbc = new JDBCUtil();
	
	
	@Override
	public List<Client> pageClientAll(int page, int pageSize) {
			//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from client limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Client> cliList=new ArrayList<Client>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
						Client client = new Client(rs.getInt(1), rs.getString(2), rs.getString(3)
								, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
								, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)
								,rs.getString(12),rs.getString(13));
						//通过集合方法 将学生信息存入集合对象
						cliList.add(client);
					}
				} catch (Exception e) {
					System.out.println("新增失败");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return cliList;
	}
	public List<Client> pageClientAll(int page, int pageSize,String number) {
		//连接数据库
			conn=jdbc.getConnection();
			//组织sql语句 查询
			int pageNo=(page-1)*pageSize;
			String sql="select * from client where cli_number='"+number+"' limit "+pageNo+","+pageSize+"";
			//创建学生集合对象  用来存储查询到的数据库信息
			List<Client> cliList=new ArrayList<Client>();
			try {
				//创建编译编译对象
				st=conn.createStatement();
				//执行sql语句 查询操作 并用结果集接收
				rs=st.executeQuery(sql);
				//通过while循环拿出数据库中数据
				while(rs.next()) {
					//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
					Client client = new Client(rs.getInt(1), rs.getString(2), rs.getString(3)
							, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
							, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)
							,rs.getString(12),rs.getString(13));
					//通过集合方法 将学生信息存入集合对象
					cliList.add(client);
				}
			} catch (Exception e) {
				System.out.println("新增失败");
				e.printStackTrace();
			}finally {
				jdbc.closeConnection(conn, st, pst, rs);
			}
			return cliList;
}

	@Override
	public int getTotalCount() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from client;";
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
	 * 增加客户信息方法
	 */
	@Override
	public int addClient(Client client) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "insert into client(cli_number,cli_name,cli_phone,cli_fax,cli_postcode,cli_address,cli_contact,cli_conphone,cli_usertype,cli_enterprise,cli_scale,cli_email) values(?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, client.getNumber());
			pst.setString(2, client.getName());
			pst.setString(3, client.getPhone());
			pst.setString(4, client.getFax());
			pst.setString(5, client.getPostcode());
			pst.setString(6, client.getAddress());
			pst.setString(7, client.getContact());
			pst.setString(8, client.getConphone());
			pst.setString(9, client.getUsertype());
			pst.setString(10, client.getEnterprise());
			pst.setString(11, client.getScale());
			pst.setString(12, client.getEmail());
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("jdbc:新增用户信息成功！");
			}
		} catch (SQLException e) {
			System.out.println("新增用户信息失败!");
			e.printStackTrace();
		} finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return result;
	}

	@Override
	public Client queryOne(int id) {
		Client client = null;
		conn = jdbc.getConnection();
		String sql = "select * from client where cli_id="+id+";";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				client = new Client(rs.getInt(1), rs.getString(2), rs.getString(3)
						, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
						, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)
						,rs.getString(12),rs.getString(13));
			}
		
		} catch (SQLException e) {
			System.out.println("查询单个信息异常！");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return client;
	}

	@Override
	public int delClient(int id) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "delete from client where cli_id="+id+";";
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("jdbc:删除信息成功！");
			}
		} catch (SQLException e) {
			System.out.println("删除信息异常！");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		
		return result;
	}

	@Override
	public int updClient(Client client) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "update client set cli_name='"+client.getName()+"',cli_phone='"+client.getPhone()+"',cli_fax='"+client.getFax()+"'"
				+ ",cli_postcode='"+client.getPostcode()+"',cli_address='"+client.getAddress()+"',cli_contact='"+client.getContact()+"',cli_conphone='"+client.getConphone()+"'"
				+ ",cli_usertype='"+client.getUsertype()+"',cli_enterprise='"+client.getEnterprise()+"',cli_scale='"+client.getScale()+"',cli_email='"+client.getEmail()+"' where cli_id='"+client.getId()+"';";
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("修改信息成功");
			}
		} catch (SQLException e) {
			System.out.println("修改信息异常！");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}		
		return result;
	}

	

}
