package cn.com.relife.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.com.relife.dao.MessageDao;
import cn.com.relife.entity.Message;
import cn.com.relife.util.JDBCUtil;

public class MessageDaoImpl implements MessageDao{
	private Connection conn=null;//���Ӷ���
	private PreparedStatement pst=null;//Ԥ�������
	private Statement st=null;//�������
	private ResultSet rs=null;//���������
	//ʵ�����������ӳع���
	JDBCUtil jdbc=new JDBCUtil();
	
	@Override
	public int add_message(Message message) {
		int count=0;
		conn=jdbc.getConnection();
		String sql="insert into message(number,title,content,name,time) values(?,?,?,?,?);";	
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,message.getNumber());
			pst.setString(2,message.getTitle());
			pst.setString(3,message.getContent());
			pst.setString(4,message.getName());
			pst.setString(5,message.getTime());
			count=pst.executeUpdate();
			if(count>1) {
				System.out.println("�����ɹ�");
			}
		} catch (SQLException e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		} finally {
			jdbc.closeConnection(conn, st, pst, rs);
		}
		return count;
	}

}
