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
	private Connection conn=null;//连接对象
	private PreparedStatement pst=null;//预编译对象
	private Statement st=null;//编译对象
	private ResultSet rs=null;//结果集对象
	//实例化创建连接池工具
	JDBCUtil jdbc=new JDBCUtil();
	
	public List<Make> pageQueryMake(int page, int pageSize) {
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
				Make make=new Make(rs.getInt("make_id"),rs.getString("fre_number"), rs.getString("state"), rs.getString("remark"),
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
	//新增收货单
	public int addMake(Make make) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into make(make_date,moneystate,make_state,make_people,make_time,make_address,make_money,make_freight,remark,make_receipt,make,liaisons,phone,site,take_Name\r\n" + 
				",take_phone,take_site,fre_number,piece,bulk,support,clerk,state) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?\r\n" + 
				",?,?,?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, make.getMake_date());//发货日期
			pst.setString(2,make.getMoneystate());//付款方式
			pst.setString(3,make.getMake_state());//取货方式
			pst.setString(4,make.getMake_people());//填票人
			pst.setString(5,make.getMake_time());//填票日期
			pst.setString(6,make.getMake_address());//中转站
			pst.setString(7,make.getMake_money());//中转费
			pst.setString(8,make.getMake_freight());//运费
			pst.setString(9,make.getRemark());//备注
			pst.setString(10,make.getMake_receipt());//收货点
			pst.setString(11,make.getMake());//发货点
			pst.setString(12,make.getLiaisons());//用户姓名
			pst.setString(13,make.getPhone());//用户手机号
			pst.setString(14,make.getSite());//用户地址
			pst.setString(15,make.getTake_Name());//收货姓名
			pst.setString(16,make.getTake_phone());//收货手机号
			pst.setString(17,make.getTake_site());//收货地址
			pst.setString(18,make.getFre_number());//货运编号
			pst.setString(19,make.getPiece() );//件数
			pst.setString(20, make.getBulk());//体积
			pst.setString(21, make.getSupport());//保价费
			pst.setString(22, make.getClerk());//职员编号
			pst.setString(23, make.getState());//状态
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
	//查询单个订单客户信息
	public Place query_userInfo(String number) {//查询在已下单状态的
		Place place = new Place();
		//第一步、获取数据库连接
		conn =jdbc.getConnection();
		//第二步、组织sql语句
		String sql="select m_name,m_phone,m_address_block,a_name,a_phone,a_address_block,number,piece,insuredPrice,weight,state,pick,pl_money,remark  from place where number='"+number+"'";
		try {
			//第三步、创建编译语句对象
			st = conn.createStatement();
			//第四步、执行sql查询,将执行查询结果赋值给结果集对象
			rs = st.executeQuery(sql);
			//第五步、使用循环取出数据
			while(rs.next()) {
				place.setM_name(rs.getString("m_name"));
				place.setM_phone(rs.getString("m_phone"));
				place.setM_address_block(rs.getString("m_address_block"));
				place.setA_name(rs.getString("a_name"));
				place.setA_phone(rs.getString("a_phone"));
				place.setA_address_block(rs.getString("a_address_block"));
				place.setNumber(rs.getString("number"));
				place.setPiece(rs.getString("piece"));//件数
				place.setWeight(rs.getString("weight"));//体积
				place.setInsuredPrice(rs.getString("insuredPrice"));//保价
				place.setState(rs.getString("state"));
				place.setPick(rs.getString("pick"));
				place.setPl_money(rs.getString("pl_money"));
				place.setRemark(rs.getString("remark"));
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
	
	public List<Place> query_userInfo() {
		List<Place> placeList = new ArrayList<Place>();
		//第一步、获取数据库连接对象
				conn = jdbc.getConnection();
				try {
					//第二步、创建编译语句对象
					st = conn.createStatement();
					//第三步、组织sql语句
					String sql="select number from place where state='待交运';";
					//第四步、执行sql查询操作
					rs = st.executeQuery(sql);
					//第五步、使用while循环从结果集对象中取出数据
					while(rs.next()) {//判断是否取到数据
						//实例化创建学生对象
						Place place = new Place();
						place.setNumber(rs.getString(1));
						//添加到集合对象中
						placeList.add(place);
					}
				} catch (Exception e) {
					System.out.println("查询数据库失败！");
					e.printStackTrace();
				} finally {
					//第六步、关闭数据库
					jdbc.closeConnection(conn, st, null, rs);
				}
				return placeList;
	}

	@Override
	public Place query_refer(String number) {
		Place place = new Place();
		//第一步、获取数据库连接
		conn =jdbc.getConnection();
		//第二步、组织sql语句
		String sql="select cost,piece,weight  from place where number='"+number+"'";
		try {
			//第三步、创建编译语句对象
			st = conn.createStatement();
			//第四步、执行sql查询,将执行查询结果赋值给结果集对象
			rs = st.executeQuery(sql);
			//第五步、使用循环取出数据
			while(rs.next()) {
				place.setInsuredPrice(rs.getString("cost"));
				place.setPiece(rs.getString("piece"));
				place.setWeight(rs.getString("weight"));
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
	public int updatePlace(String number) {
		int result =0;
		//获取数据库连接
		conn = jdbc.getConnection();
		//组织sql语句
		String sql="update place set state='待发' where number='"+number+"';";
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
	public Make queryMake(String number) {
		Make make = new Make();
		//第一步、获取数据库连接
		conn =jdbc.getConnection();
		//第二步、组织sql语句
		String sql="select make_date,moneystate,make_state,make_people,make_time,make_address,make_money,make_freight,remark,make_receipt,make,liaisons,phone,site,take_Name,take_phone,\r\n" + 
				"take_site,fre_number,piece,bulk,support,clerk,state\r\n" + 
				" from make where fre_number='"+number+"'";
		try {
			//第三步、创建编译语句对象
			st = conn.createStatement();
			//第四步、执行sql查询,将执行查询结果赋值给结果集对象
			rs = st.executeQuery(sql);
			//第五步、使用循环取出数据
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
				System.out.println("查询成功！");
			}
		} catch (Exception e) {
			System.out.println("查询失败！");
			e.printStackTrace();
		} finally {
			//第六步、关闭数据库
			jdbc.closeConnection(conn, st, null, rs);
		}
		return make;
	}

	@Override
	public int update_Make(String number, String make, String make_receipt, String make_freight) {
		int result =0;
		//获取数据库连接
		conn = jdbc.getConnection();
		//组织sql语句
		String sql="update make set make='"+make+"',make_receipt='"+make_receipt+"',make_freight='"+make_freight+"' where fre_number='"+number+"';";
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
	public List<Make> pageQueryMake(int page, int pageSize, String number) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from make where state='待发'  and fre_number='"+number+"' limit "+pageNo+","+pageSize+"";
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
						Make make=new Make(rs.getInt("make_id"),rs.getString("fre_number"), rs.getString("state"), rs.getString("remark"),
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

}
