package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.relife.dao.NoticeDao;
import cn.com.relife.entity.Mode;
import cn.com.relife.entity.Notice;
import cn.com.relife.util.JDBCUtil;

public class NoticeDaoImpl implements NoticeDao{
	private Connection conn=null;//连接对象
	private PreparedStatement pst=null;//预编译对象
	private Statement st=null;//编译对象
	private ResultSet rs=null;//结果集对象
	//实例化创建连接池工具
	JDBCUtil jdbc=new JDBCUtil();
	
	@Override
	public List<Notice> pageQueryMode(int page, int pageSize) {
		//连接数据库
				conn=jdbc.getConnection();
				//组织sql语句 查询
				int pageNo=(page-1)*pageSize;
				String sql="select * from notice limit "+pageNo+","+pageSize+"";
				//创建学生集合对象  用来存储查询到的数据库信息
				List<Notice> noticeList=new ArrayList<Notice>();
				try {
					//创建编译编译对象
					st=conn.createStatement();
					//执行sql语句 查询操作 并用结果集接收
					rs=st.executeQuery(sql);
					//通过while循环拿出数据库中数据
					while(rs.next()) {
						//实例化创建学生对象 并通过构造方法赋值 （存放从数据库里查询出来的值）
						Notice notice=new Notice(rs.getInt("id"),rs.getString("title"),
								rs.getString("content"),rs.getString("date_time"));
						//通过集合方法 将学生信息存入集合对象、
						noticeList.add(notice);
					}
				} catch (Exception e) {
					System.out.println("查询失败");
					e.printStackTrace();
				}finally {
					jdbc.closeConnection(conn, st, pst, rs);
				}
				return noticeList;
	}
	
	@Override
	public int getNotice() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from notice;";
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
	public Notice query(String number) {
		Notice mode = null;
		conn = jdbc.getConnection();
		String sql = "select * from notice where title='"+number+"';";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				mode = new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4));
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
	public int add(Notice notice) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into notice(title,content,date_time)values(?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,notice.getTitle());
			pst.setString(2,notice.getContent());
			pst.setString(3,notice.getDate_time());
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
	public int delete(String id) {
		int result =0;
		//获取数据库连接
		conn = jdbc.getConnection();
		//组织sql语句
		String sql="delete from notice where id='"+id+"'";
		try {
			//构建预编译对象
			pst = conn.prepareStatement(sql);
			//执行sql修改操作
			result = pst.executeUpdate();
			if(result>0) {
				System.out.println("删除成功！");
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
	public int query_hunan() {
		int count=0;
		conn=jdbc.getConnection();
		String sql="select count(*) from transit where make LIKE '%湖南省%'";
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
