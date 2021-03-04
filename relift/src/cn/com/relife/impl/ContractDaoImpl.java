package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.ContractDao;
import cn.com.relife.entity.Bill;
import cn.com.relife.entity.Contract;
import cn.com.relife.entity.Driver;
import cn.com.relife.entity.Make;
import cn.com.relife.entity.Place;
import cn.com.relife.util.JDBCUtil;
/**
 * @remark 配车单实现类
 * @author 随便
 * @createTime 10点11分
 * @version 1.0
 */
public class ContractDaoImpl implements ContractDao{
	private Connection conn=null;//连接对象
	private PreparedStatement pst=null;//预编译对象
	private Statement st=null;//编译对象
	private ResultSet rs=null;//结果集对象
	//实例化创建连接池工具
	JDBCUtil jdbc=new JDBCUtil();
	List<Bill> billList = new ArrayList<Bill>();
	
	@Override
	public List<Bill> query_bill() {
		//第一步、获取数据库连接对象
		conn = jdbc.getConnection();
		
		try {
			//第二步、创建编译语句对象
			st = conn.createStatement();
			//第三步、组织sql语句
			String sql="select bi_number from bill";
			//第四步、执行sql查询操作
			rs = st.executeQuery(sql);
			//第五步、使用while循环从结果集对象中取出数据
			while(rs.next()) {//判断是否取到数据
				//实例化创建学生对象
				Bill bill = new Bill();
				bill.setBi_number(rs.getString(1));
				//添加到集合对象中
				billList.add(bill);
			}
		} catch (Exception e) {
			System.out.println("查询数据库失败！");
			e.printStackTrace();
		} finally {
			//第六步、关闭数据库
			jdbc.closeConnection(conn, st, null, rs);
		}
		return billList;
	}

	@Override
	public Make query_make(String fre_number) {
		Make make = new Make();
		//第一步、获取数据库连接
		conn =jdbc.getConnection();
		//第二步、组织sql语句
		String sql="select make_receipt,make,take_Name,take_phone,take_site,make_time,remark,moneystate,make_freight  from make where fre_number='"+fre_number+"';";
		try {
			//第三步、创建编译语句对象
			st = conn.createStatement();
			//第四步、执行sql查询,将执行查询结果赋值给结果集对象
			rs = st.executeQuery(sql);
			//第五步、使用循环取出数据
			while(rs.next()) {
				make.setMake(rs.getString("make"));
				make.setMake_receipt(rs.getString("make_receipt"));
				make.setTake_Name(rs.getString("take_Name"));
				make.setTake_phone(rs.getString("take_phone"));
				make.setTake_site(rs.getString("take_site"));
				make.setMake_time(rs.getString("make_time"));
				make.setRemark(rs.getString("remark"));
				make.setMoneystate(rs.getString("moneystate"));
				make.setMake_freight(rs.getString("make_freight"));
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
	public int add_edit(Contract contract) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into contract(fre_number,make_receipt,make,bi_state,take_Name,\r\n" + 
				"take_phone,take_site,con_close,con_remark,dr_number,con_time,con_freight,con_receipt\r\n" + 
				") values(?,?,?,?,?,?,?,?,?,?,?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,contract.getFre_number());
			pst.setString(2,contract.getMake_receipt());
			pst.setString(3,contract.getMake());
			pst.setString(4,contract.getBi_state());
			pst.setString(5,contract.getTake_Name());
			pst.setString(6,contract.getTake_phone());
			pst.setString(7,contract.getTake_site());
			pst.setString(8,contract.getCon_close());
			pst.setString(9,contract.getCon_remark());
			pst.setString(10,contract.getDr_number());
			pst.setString(11,contract.getCon_time());
			pst.setString(12,contract.getCon_freight());
			pst.setString(13,contract.getCon_receipt());
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
	public Bill query_Bill(String number) {
		Bill bill = new Bill();
		//第一步、获取数据库连接
		conn =jdbc.getConnection();
		//第二步、组织sql语句
		String sql="select bi_driver from bill where bi_number='"+number+"'";
		try {
			//第三步、创建编译语句对象
			st = conn.createStatement();
			//第四步、执行sql查询,将执行查询结果赋值给结果集对象
			rs = st.executeQuery(sql);
			//第五步、使用循环取出数据
			while(rs.next()) {
				bill.setBi_driver(rs.getString("bi_driver"));
			}
			if(bill!=null) {
				System.out.println("查询成功！");
			}
		} catch (Exception e) {
			System.out.println("查询失败！");
			e.printStackTrace();
		} finally {
			//第六步、关闭数据库
			jdbc.closeConnection(conn, st, null, rs);
		}
		return bill;
	}

	@Override
	public List<Contract> pageQueryContract(int page, int pageSize) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select * from contract limit "+pageNo+","+pageSize+"";
		//创建学生集合对象  用来存储查询到的数据库信息
		List<Contract> contractList=new ArrayList<Contract>();
		try {
			//创建编译编译对象
			st=conn.createStatement();
			//执行sql语句 查询操作 并用结果集接收
			rs=st.executeQuery(sql);
			//通过while循环拿出数据库中数据
			while(rs.next()) {
				//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
				Contract contract=new Contract(rs.getInt("con_id"),rs.getString("fre_number"),rs.getString("con_receipt"),rs.getString("take_Name"));
				//通过集合方法 将学生信息存入集合对象、
				contractList.add(contract);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return contractList;
	}

	@Override
	public int getContract() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from contract;";
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
	public Contract query_Contract(String number) {
		Contract contract = new Contract();
		//第一步、获取数据库连接
		conn =jdbc.getConnection();
		//第二步、组织sql语句
		String sql="select * from contract where fre_number='"+number+"'";
		try {
			//第三步、创建编译语句对象
			st = conn.createStatement();
			//第四步、执行sql查询,将执行查询结果赋值给结果集对象
			rs = st.executeQuery(sql);
			//第五步、使用循环取出数据
			while(rs.next()) {
				contract.setFre_number(rs.getString("fre_number"));
				contract.setMake_receipt(rs.getString("make_receipt"));
				contract.setMake(rs.getString("make"));
				contract.setBi_state(rs.getString("bi_state"));
				contract.setTake_Name(rs.getString("take_Name"));
				contract.setTake_phone(rs.getString("take_phone"));
				contract.setTake_site(rs.getString("take_site"));
				contract.setCon_close(rs.getString("con_close"));
				contract.setCon_remark(rs.getString("con_remark"));
				contract.setDr_number(rs.getString("dr_number"));
				contract.setCon_time(rs.getString("con_time"));
				contract.setCon_freight(rs.getString("con_freight"));
				contract.setCon_receipt(rs.getString("con_receipt"));
			}
			if(contract!=null) {
				System.out.println("查询成功！");
			}
		} catch (Exception e) {
			System.out.println("查询失败！");
			e.printStackTrace();
		} finally {
			//第六步、关闭数据库
			jdbc.closeConnection(conn, st, null, rs);
		}
		return contract;
	}

	@Override
	public int update(String number) {
		int result =0;
		//获取数据库连接
		conn = jdbc.getConnection();
		//组织sql语句
		String sql="update place set state='待配车' where number='"+number+"';";
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
	public int update_alter(String number, String loadStation, String dealGoodsStation, String allCarriage) {
		int result =0;
		//获取数据库连接
		conn = jdbc.getConnection();
		//组织sql语句
		String sql="update contract set con_freight='"+allCarriage+"',make_receipt='"+dealGoodsStation+"',make='"+loadStation+"' where fre_number='"+number+"';";
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
	public List<Contract> pageQueryContract(int page, int pageSize, String number) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from contract where fre_number='"+number+"' limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Contract> contractList=new ArrayList<Contract>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 (id、编号、状态、姓名)
						Contract contract=new Contract(rs.getInt("con_id"),rs.getString("fre_number"),rs.getString("con_receipt"),rs.getString("take_Name"));
						//通过集合方法 将学生信息存入集合对象、
						contractList.add(contract);
					}
				} catch (Exception e) {
					System.out.println("查询失败");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return contractList;
	}

	

}
