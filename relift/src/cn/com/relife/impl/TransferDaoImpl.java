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
	private Connection conn=null;//连接对象
	private PreparedStatement pst=null;//预编译对象
	private Statement st=null;//编译对象
	private ResultSet rs=null;//结果集对象
	//实例化创建连接池工具
	JDBCUtil jdbc=new JDBCUtil();
	
	
	public List<Transfer> pageQueryTra(int page, int pageSize) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from transfer limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Transfer> stuList=new ArrayList<Transfer>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
						Transfer stu=new Transfer(rs.getInt(1), rs.getString(2), rs.getString(3),
								rs.getString(4),rs.getString(5),rs.getString(6));
						//通过集合方法 将学生信息存入集合对象、
						stuList.add(stu);
					}
				} catch (Exception e) {
					System.out.println("新增失败");
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
				System.out.println("新增成功");
			}
		} catch (SQLException e) {
			System.out.println("新增失败");
			e.printStackTrace();
		} finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return count;
	}

	@Override
	public List<Transfer> pageQueryTra() {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		String sql="select * from transfer ";
		//创建学生集合对象  用来存储查询到的数据库信息
		List<Transfer> stuList=new ArrayList<Transfer>();
		try {
			//创建编译编译对象
			st=conn.createStatement();
			//执行sql语句 查询操作 并用结果集接收
			rs=st.executeQuery(sql);
			//通过while循环拿出数据库中数据
			while(rs.next()) {
				//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
				Transfer stu=new Transfer(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6));
				//通过集合方法 将学生信息存入集合对象、
				stuList.add(stu);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return stuList;
	}
	
}
