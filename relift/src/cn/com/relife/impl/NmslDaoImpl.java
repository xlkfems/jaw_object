package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.com.relife.dao.NmslDao;
import cn.com.relife.entity.Clerk;
import cn.com.relife.entity.Nmsl;
import cn.com.relife.util.JDBCUtil;

public class NmslDaoImpl implements NmslDao{
	Connection conn=null;//连接对象
	PreparedStatement pst=null;//预编译对象
	Statement st=null;//编译对象
	ResultSet rs=null;//结果集对象
	//实例化创建连接池工具
	JDBCUtil jdbc=new JDBCUtil();
	
	@Override
	public Nmsl query(int id) {
		Nmsl nmsl = null;
		conn = jdbc.getConnection();
		String sql = "select * from nmsl where id=1;";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				nmsl = new Nmsl(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getDouble(4),rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("查询单个职员信息异常");
			e.printStackTrace();
		} finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return nmsl;
	}

	@Override
	public int update(Nmsl nmsl) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "update nmsl set location='"+nmsl.getLocation()+"',longitude='"+nmsl.getLongitude()+"',latitude='"+nmsl.getLatitude()+"',reveal='"+nmsl.getReveal()+"' where id=1;";
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
