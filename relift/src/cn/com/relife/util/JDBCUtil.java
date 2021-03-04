package cn.com.relife.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCUtil {
	public Connection getConnection() {
		Connection conn = null;
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/orange");
			conn = ds.getConnection();
			if(conn!=null) {
				System.out.println("连接成功！");
			}
		} catch (NamingException e) {
			System.out.println("失败");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return conn;
		
	}
	public void closeConnection(Connection conn,Statement st,PreparedStatement pst,ResultSet rs) {
		try {
		if(conn!=null) {conn.close();}
		if(st!=null) {st.close();}
		if(pst!=null){pst.close();}
		if(rs!=null) {rs.close();}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
