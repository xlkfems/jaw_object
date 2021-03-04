package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.CentreDao;
import cn.com.relife.entity.Centre;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Place;
import cn.com.relife.util.JDBCUtil;

public class CentreDaoImpl implements CentreDao{
	private Connection conn=null;//连接对象
	private PreparedStatement pst=null;//预编译对象
	private Statement st=null;//编译对象
	private ResultSet rs=null;//结果集对象
	//实例化创建连接池工具
	JDBCUtil jdbc=new JDBCUtil();
	
	@Override
	public int add_Centre(Centre centre) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into centre(fre_number,location,dr_number,reception_time,tr_name,tr_address,tr_phone) values(?,?,?,?,?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,centre.getFre_number());
			pst.setString(2,centre.getLocation());
			pst.setString(3,centre.getDr_number());
			pst.setString(4,centre.getReception_time());
			pst.setString(5,centre.getTr_name());
			pst.setString(6,centre.getTr_address());
			pst.setString(7,centre.getTr_phone());
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
	public List<Centre> pageQueryCentre(int page, int pageSize) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from centre limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Centre> centreList=new ArrayList<Centre>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
						Centre centre=new Centre(rs.getInt("id"),rs.getString("fre_number"),
								rs.getString("location"),rs.getString("dr_number"),rs.getString("reception_time")
								,rs.getString("tr_name"),rs.getString("tr_address"),rs.getString("tr_phone"));
						//通过集合方法 将学生信息存入集合对象、
						centreList.add(centre);
					}
				} catch (Exception e) {
					System.out.println("查询失败");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return centreList;
	}
	
	public List<Centre> pageQueryCentre(int page, int pageSize,String number) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from centre where fre_number='"+number+"' limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Centre> centreList=new ArrayList<Centre>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
						Centre centre=new Centre(rs.getInt("id"),rs.getString("fre_number"),
								rs.getString("location"),rs.getString("dr_number"),rs.getString("reception_time")
								,rs.getString("tr_name"),rs.getString("tr_address"),rs.getString("tr_phone"));
						//通过集合方法 将学生信息存入集合对象、
						centreList.add(centre);
					}
				} catch (Exception e) {
					System.out.println("查询失败");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return centreList;
	}
	
	@Override
	public int getCentre() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from centre;";
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
	public List<Place> pageQueryPlace(int page, int pageSize) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select * from place where state='已送达'  limit "+pageNo+","+pageSize+"";
		//创建学生集合对象  用来存储查询到的数据库信息
		List<Place> placeList=new ArrayList<Place>();
		try {
			//创建编译编译对象
			st=conn.createStatement();
			//执行sql语句 查询操作 并用结果集接收
			rs=st.executeQuery(sql);
			//通过while循环拿出数据库中数据
			while(rs.next()) {
				//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
				Place place=new Place(rs.getInt("id"),rs.getString("number"),
						rs.getString("pick"),rs.getString("money"));
				//通过集合方法 将学生信息存入集合对象、
				placeList.add(place);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return placeList;
	}
	
	public List<Place> pageQueryPlace(int page, int pageSize,String number) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select * from place where state='已送达'  and number='"+number+"' limit "+pageNo+","+pageSize+"";
		//创建学生集合对象  用来存储查询到的数据库信息
		List<Place> placeList=new ArrayList<Place>();
		try {
			//创建编译编译对象
			st=conn.createStatement();
			//执行sql语句 查询操作 并用结果集接收
			rs=st.executeQuery(sql);
			//通过while循环拿出数据库中数据
			while(rs.next()) {
				//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
				Place place=new Place(rs.getInt("id"),rs.getString("number"),
						rs.getString("pick"),rs.getString("money"));
				//通过集合方法 将学生信息存入集合对象、
				placeList.add(place);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return placeList;
	}
	
	@Override
	public int getPlace() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from place;";
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
