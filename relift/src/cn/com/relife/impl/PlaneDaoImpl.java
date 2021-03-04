package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.PlaceDao;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.Place;
import cn.com.relife.util.JDBCUtil;

public class PlaneDaoImpl implements PlaceDao{
	private Connection conn=null;//连接对象
	private PreparedStatement pst=null;//预编译对象
	private Statement st=null;//编译对象
	private ResultSet rs=null;//结果集对象
	//实例化创建连接池工具
	JDBCUtil jdbc=new JDBCUtil();
	
	public List<Place> pageQueryPla(int page, int pageSize) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select id,number,state from place limit "+pageNo+","+pageSize+"";
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
						Place place=new Place(rs.getInt(1),rs.getString(2), rs.getString(3));
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

	public Place query_place(String number) {
		Place place = new Place();
		//第一步、获取数据库连接
		conn =jdbc.getConnection();
		//第二步、组织sql语句
		String sql="select number,m_name,m_phone,m_address_block,a_name,a_phone,a_address_block,cargo,weight," + 
				"type,insuredPrice,days,pick,money,remark,state,piece,pl_money from place where number='"+number+"'";
		try {
			//第三步、创建编译语句对象
			st = conn.createStatement();
			//第四步、执行sql查询,将执行查询结果赋值给结果集对象
			rs = st.executeQuery(sql);
			//第五步、使用循环取出数据
			while(rs.next()) {
				place.setNumber(rs.getString("number"));
				place.setM_name(rs.getString("m_name"));
				place.setM_phone(rs.getString("m_phone"));
				place.setM_address_block(rs.getString("m_address_block"));
				place.setA_name(rs.getString("a_name"));
				place.setA_phone(rs.getString("a_phone"));
				place.setA_address_block(rs.getString("a_address_block"));
				place.setCargo(rs.getString("cargo"));
				place.setWeight(rs.getString("weight"));
				place.setType(rs.getString("type"));
				place.setInsuredPrice(rs.getString("insuredPrice"));
				place.setDays(rs.getString("days"));
				place.setPick(rs.getString("pick"));
				place.setMoney(rs.getString("money"));
				place.setState(rs.getString("state"));
				place.setRemark(rs.getString("remark"));
				place.setPiece(rs.getString("piece"));
				place.setPl_money(rs.getString("pl_money"));
			}
			if(place!=null) {
				System.out.println("查询成功！");
			}
		} catch (Exception e) {
			System.out.println("查询失败！");
			e.printStackTrace();
		} finally {
			//第六步、关闭数据库
			jdbc.closeConnection(conn, st, null, rs);
		}
		return place;
	}

	@Override
	public int update_place(String number, String state) {
		int result =0;
		//获取数据库连接
		conn = jdbc.getConnection();
		//组织sql语句
		String sql="update place set state='"+state+"' where number='"+number+"';";
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
	public List<Place> pageQueryPlace(int page, int pageSize) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select id,number,state,pick,pl_money,type from place where state='已结算'  limit "+pageNo+","+pageSize+"";
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
				Place place=new Place(rs.getInt("id"),rs.getString("number"), rs.getString("pick"),rs.getString("pl_money"),rs.getString("type"));
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
		String sql="select id,number,state,pick,pl_money,type from place where state='已结算'  and number='"+number+"'  limit "+pageNo+","+pageSize+"";
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
				Place place=new Place(rs.getInt("id"),rs.getString("number"), rs.getString("pick"),rs.getString("pl_money"),rs.getString("type"));
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
	public List<Place> pageQueryReport(int page, int pageSize) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select id,number,m_name,m_address_block,a_name,a_address_block from place limit "+pageNo+","+pageSize+"";
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
				Place place=new Place(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
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
	public List<Place> pageQueryPla(int page, int pageSize, String number) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select id,number,state from place where number='"+number+"' limit "+pageNo+","+pageSize+"";
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
				Place place=new Place(rs.getInt(1),rs.getString(2), rs.getString(3));
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

}
