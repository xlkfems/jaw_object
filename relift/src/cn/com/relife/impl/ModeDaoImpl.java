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
	private Connection conn=null;//连接对象
	private PreparedStatement pst=null;//预编译对象
	private Statement st=null;//编译对象
	private ResultSet rs=null;//结果集对象
	//实例化创建连接池工具
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
	public List<Mode> pageQueryMode(int page, int pageSize) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select * from transit limit "+pageNo+","+pageSize+"";
		//创建学生集合对象  用来存储查询到的数据库信息
		List<Mode> modeList=new ArrayList<Mode>();
		try {
			//创建编译编译对象
			st=conn.createStatement();
			//执行sql语句 查询操作 并用结果集接收
			rs=st.executeQuery(sql);
			//通过while循环拿出数据库中数据
			while(rs.next()) {
				//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
				Mode mode=new Mode(rs.getInt("id"),rs.getString("fre_number"),
						rs.getString("dr_number"),rs.getString("make_receipt"),rs.getString("make")
						,rs.getString("con_receipt"),rs.getString("location"));
				//通过集合方法 将学生信息存入集合对象、
				modeList.add(mode);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
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
		//获取数据库连接
		conn = jdbc.getConnection();
		//组织sql语句
		String sql="update transit set location='"+number+"' where fre_number='"+city+"';";
		try {
			//构建预编译对象
			pst = conn.prepareStatement(sql);
			//执行sql修改操作
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("修改成功！");
			}
		} catch (Exception e) {
			System.out.println("修改失败！");
			e.printStackTrace();
		} finally {
			//关闭数据库
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
			System.out.println("查询单个异常");
			e.printStackTrace();
		}finally {
			//关闭数据库
			jdbc.closeConnection(conn, null, pst, rs);
		}
		return mode;
	}

	@Override
	public List<Mode> QueryMode(int page, int pageSize) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from transit where location!=make and location!=make_receipt and con_receipt='运输中'  limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Mode> modeList=new ArrayList<Mode>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
						Mode mode=new Mode(rs.getInt("id"),rs.getString("fre_number"),
								rs.getString("dr_number"),rs.getString("make_receipt"),rs.getString("make")
								,rs.getString("con_receipt"),rs.getString("location"));
						//通过集合方法 将学生信息存入集合对象、
						modeList.add(mode);
					}
				} catch (Exception e) {
					System.out.println("查询失败");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return modeList;
	}
	public List<Mode> QueryMode(int page, int pageSize,String number) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from transit where location!=make and location!=make_receipt and con_receipt='运输中'  and fre_number='"+number+"' limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Mode> modeList=new ArrayList<Mode>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
						Mode mode=new Mode(rs.getInt("id"),rs.getString("fre_number"),
								rs.getString("dr_number"),rs.getString("make_receipt"),rs.getString("make")
								,rs.getString("con_receipt"),rs.getString("location"));
						//通过集合方法 将学生信息存入集合对象、
						modeList.add(mode);
					}
				} catch (Exception e) {
					System.out.println("查询失败");
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
		//连接数据库
				conn=jdbc.getConnection();
				String sql="select * from transfer where tr_city='"+tr_city+"';";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Transfer> trabsList=new ArrayList<Transfer>();
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
						trabsList.add(stu);
					}
				} catch (Exception e) {
					System.out.println("查询失败");
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
			System.out.println("查询单个异常");
			e.printStackTrace();
		}finally {
			//关闭数据库
			jdbc.closeConnection(conn, null, pst, rs);
		}
		return tra;
	}

	@Override
	public int update_mod(String fre_number, String con_receipt) {
		int result =0;
		//获取数据库连接
		conn = jdbc.getConnection();
		//组织sql语句
		String sql="update transit set con_receipt='"+con_receipt+"' where fre_number='"+fre_number+"';";
		try {
			//构建预编译对象
			pst = conn.prepareStatement(sql);
			//执行sql修改操作
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("修改成功！");
			}
		} catch (Exception e) {
			System.out.println("修改失败！");
			e.printStackTrace();
		} finally {
			//关闭数据库
			jdbc.closeConnection(conn, null, pst, rs);
		}
		return result;
	}

	@Override
	public List<Mode> pageQueryMode(int page, int pageSize, String number) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from transit where fre_number='"+number+"' limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Mode> modeList=new ArrayList<Mode>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
						Mode mode=new Mode(rs.getInt("id"),rs.getString("fre_number"),
								rs.getString("dr_number"),rs.getString("make_receipt"),rs.getString("make")
								,rs.getString("con_receipt"),rs.getString("location"));
						//通过集合方法 将学生信息存入集合对象、
						modeList.add(mode);
					}
				} catch (Exception e) {
					System.out.println("查询失败");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return modeList;
	}

}
