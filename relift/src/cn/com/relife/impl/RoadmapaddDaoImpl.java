package cn.com.relife.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.RoadmapaddDao;
import cn.com.relife.entity.Client;
import cn.com.relife.entity.Roadmapadd;
import cn.com.relife.util.JDBCUtil;

/**
 * @remark 路线接口实现类
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public class RoadmapaddDaoImpl implements RoadmapaddDao{
	Connection conn = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JDBCUtil jdbc = new JDBCUtil();
	
	@Override
	public List<Roadmapadd> pageRoadmapaddAll(int page, int pageSize) {
		//连接数据库
		conn=jdbc.getConnection();
		//组织sql语句 查询
		int pageNo=(page-1)*pageSize;
		String sql="select * from roadmapadd limit "+pageNo+","+pageSize+"";
		//创建路线集合对象  用来存储查询到的数据库信息
		List<Roadmapadd> roadList = new ArrayList<Roadmapadd>();
		try {
			//创建编译编译对象
			st=conn.createStatement();
			//执行sql语句 查询操作 并用结果集接收
			rs=st.executeQuery(sql);
			//通过while循环拿出数据库中数据
			while(rs.next()) {
				//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
				Roadmapadd roadmapadd = new Roadmapadd(rs.getInt(1), rs.getString(2),rs.getString(3));
				//通过集合方法 将学生信息存入集合对象
				roadList.add(roadmapadd);
			}
		} catch (Exception e) {
			System.out.println("新增失败");
			e.printStackTrace();
		}finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return roadList;
	}

	@Override
	public int getTotalCount() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from roadmapadd;";
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
	/**
	 * 查询单个信息
	 */
	@Override
	public Roadmapadd queryOne(int path_id) {
		Roadmapadd roadmapadd = null;
		conn = jdbc.getConnection();
		String sql = "select * from roadmapadd where path_id="+path_id+";";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				roadmapadd = new Roadmapadd(rs.getInt(1), rs.getString(2),rs.getString(3));
			}
		
		} catch (SQLException e) {
			System.out.println("查询单个信息异常！");
			e.printStackTrace();
		}
		return roadmapadd;
	}
	/**
	 * 新增方法
	 */
	@Override
	public int addRoad(Roadmapadd road) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "insert into roadmapadd(path_city,path_scope) values('"+road.getPath_city()+"','"+road.getPath_scope()+"');";
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("jdbc:新增信息成功！");
			}
		} catch (SQLException e) {
			System.out.println("新增信息异常！");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delRoad(int path_id) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "delete from roadmapadd where path_id="+path_id+";";
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("jdbc:删除该条信息成功！");
			}
		} catch (SQLException e) {
			System.out.println("删除异常！");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updRoad(Roadmapadd road) {
		int result = 0;
		conn = jdbc.getConnection();
		String sql = "update roadmapadd set path_city='"+road.getPath_city()+"',path_scope='"+road.getPath_scope()+"' where path_id="+road.getPath_id()+";";
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
