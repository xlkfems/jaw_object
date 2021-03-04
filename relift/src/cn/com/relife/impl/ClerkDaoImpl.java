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
 * @remark 职员接口实现类
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public class ClerkDaoImpl implements ClerkDao{
	Connection conn=null;//连接对象
	PreparedStatement pst=null;//预编译对象
	Statement st=null;//编译对象
	ResultSet rs=null;//结果集对象
	//实例化创建连接池工具
	JDBCUtil jdbc=new JDBCUtil();
	/*
	 * 分页查询
	 * @param pageNo       当前页码
	 * @param pageSize   显示数
	 * @return 			 返回集合
	 * */
	@Override
	public List<Clerk> pageQueryTra(int page, int pageSize) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select * from clerk limit "+pageNo+","+pageSize+"";
		//创建学生集合对象  用来存储查询到的数据库信息
		List<Clerk> cleList=new ArrayList<Clerk>();
		try {
			//创建编译编译对象
			st=conn.createStatement();
			//执行sql语句 查询操作 并用结果集接收
			rs=st.executeQuery(sql);
			//通过while循环拿出数据库中数据
			while(rs.next()) {
				//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
				Clerk cle=new Clerk(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6));
				//通过集合方法 将学生信息存入集合对象、
				cleList.add(cle);
			}
		} catch (Exception e) {
			System.out.println("查询全部职员失败");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return cleList;
	}
	public List<Clerk> pageQueryTra(int page, int pageSize,String number) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select * from clerk where cl_number='"+number+"' limit "+pageNo+","+pageSize+"";
		//创建学生集合对象  用来存储查询到的数据库信息
		List<Clerk> cleList=new ArrayList<Clerk>();
		try {
			//创建编译编译对象
			st=conn.createStatement();
			//执行sql语句 查询操作 并用结果集接收
			rs=st.executeQuery(sql);
			//通过while循环拿出数据库中数据
			while(rs.next()) {
				//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
				Clerk cle=new Clerk(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6));
				//通过集合方法 将学生信息存入集合对象、
				cleList.add(cle);
			}
		} catch (Exception e) {
			System.out.println("查询全部职员失败");
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
				System.out.println("jdbc:新增职员信息成功！");
			}
		} catch (SQLException e) {
			System.out.println("新增职员信息异常！");
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
				System.out.println("jdbc:删除信息成功！");
			}
		} catch (SQLException e) {
			System.out.println("删除信息异常！");
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
			System.out.println("查询单个职员信息异常");
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
				System.out.println("修改信息成功");
			}
		} catch (SQLException e) {
			System.out.println("修改信息异常！");
			e.printStackTrace();
		}		
		return result;
	}

}
