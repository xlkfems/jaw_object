package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.BillDao;
import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.Place;
import cn.com.relife.util.JDBCUtil;

public class BillDaoImpl implements BillDao{
	private Connection conn=null;//连接对象
	private PreparedStatement pst=null;//预编译对象
	private Statement st=null;//编译对象
	private ResultSet rs=null;//结果集对象
	//实例化创建连接池工具
	JDBCUtil jdbc=new JDBCUtil();
	List<Driver> driverList = new ArrayList<Driver>();
	@Override
	public List<Make> pageQueryBill(int page, int pageSize) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from make where state='待发'  limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Make> makeList=new ArrayList<Make>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
						Make make=new Make(rs.getInt("make_id"),rs.getString("fre_number"),
								rs.getString("make_time"));
						//通过集合方法 将学生信息存入集合对象、
						makeList.add(make);
					}
				} catch (Exception e) {
					System.out.println("查询失败");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return makeList;
	}
	@Override
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
	@Override
	public List<Driver> query_driver(String dr_address) {
		//第一步、获取数据库连接对象
				conn = jdbc.getConnection();
				
				try {
					//第二步、创建编译语句对象
					st = conn.createStatement();
					//第三步、组织sql语句
					String sql="select dr_number from driver where dr_vin='空闲'  and dr_address LIKE '%"+dr_address+"%'";
					//第四步、执行sql查询操作
					rs = st.executeQuery(sql);
					//第五步、使用while循环从结果集对象中取出数据
					while(rs.next()) {//判断是否取到数据
						//实例化创建学生对象
						Driver driver = new Driver();
						driver.setDr_number(rs.getString(1));
						//添加到集合对象中
						driverList.add(driver);
					}
				} catch (Exception e) {
					System.out.println("查询数据库失败！");
					e.printStackTrace();
				} finally {
					//第六步、关闭数据库
					jdbc.closeConnection(conn, st, null, rs);
				}
				return driverList;
	}
	@Override
	public List<Bill> QueryBill(int page, int pageSize) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select * from bill limit "+pageNo+","+pageSize+"";
		//创建学生集合对象  用来存储查询到的数据库信息
		List<Bill> billList=new ArrayList<Bill>();
		try {
			//创建编译编译对象
			st=conn.createStatement();
			//执行sql语句 查询操作 并用结果集接收
			rs=st.executeQuery(sql);
			//通过while循环拿出数据库中数据
			while(rs.next()) {
				//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
				Bill bill=new Bill(rs.getInt("bi_id"),rs.getString("bi_number"),
						rs.getString("bi_date"),rs.getString("state"));
				//通过集合方法 将学生信息存入集合对象、
				billList.add(bill);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return billList;
	}
	@Override
	public int getBill() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from bill;";
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
	public int add_Bill(Bill bill) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into bill(bi_number,bi_date,bi_state,bi_driver,make_cargo,distribute,state) value(?,?,?,?,?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, bill.getBi_number());//货运编号
			pst.setString(2, bill.getBi_date());//填写日期
			pst.setString(3, bill.getBi_state());//领票时间
			pst.setString(4, bill.getBi_driver());//领票人
			pst.setString(5, bill.getMake_cargo());//接货点
			pst.setString(6, bill.getDistribute());//分发人
			pst.setString(7, bill.getState());//状态
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
	public int update_bill(String fre_number) {
		int result =0;
		//获取数据库连接
		conn = jdbc.getConnection();
		//组织sql语句
		String sql="update make set state='待配车' where fre_number='"+fre_number+"'";
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
	public int update_driver(String dr_number) {
		int result =0;
		//获取数据库连接
		conn = jdbc.getConnection();
		//组织sql语句
		String sql="update driver set dr_vin='运输中' where dr_number='"+dr_number+"'";
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
	public List<Bill> pageQueryBill(int page, int pageSize, String number) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from bill where bi_number='"+number+"' limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Bill> billList=new ArrayList<Bill>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
						Bill bill=new Bill(rs.getInt("bi_id"),rs.getString("bi_number"),
								rs.getString("bi_date"),rs.getString("state"));
						//通过集合方法 将学生信息存入集合对象、
						billList.add(bill);
					}
				} catch (Exception e) {
					System.out.println("查询失败");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return billList;
	}
}
