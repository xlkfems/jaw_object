package cn.com.relife.entity;
/**
 * @remark ·��ʵ�����
 * @author ���
 * @createTime 10��21��
 * @version 1.0
 */
public class Roadmapadd {
	private int path_id;//·��id
	private String path_city;//��Ҫ����
	private String path_scope;//���з�Χ
	public Roadmapadd() {
	}
	public Roadmapadd( String path_city, String path_scope) {
		this.path_city = path_city;
		this.path_scope = path_scope;
	}
	public Roadmapadd(int path_id, String path_city, String path_scope) {
		super();
		this.path_id = path_id;
		this.path_city = path_city;
		this.path_scope = path_scope;
	}
	public Roadmapadd(String path_city, String path_scope,int path_id ) {
		super();
		this.path_id = path_id;
		this.path_city = path_city;
		this.path_scope = path_scope;
	}
	public int getPath_id() {
		return path_id;
	}
	public void setPath_id(int path_id) {
		this.path_id = path_id;
	}
	public String getPath_city() {
		return path_city;
	}
	public void setPath_city(String path_city) {
		this.path_city = path_city;
	}
	public String getPath_scope() {
		return path_scope;
	}
	public void setPath_scope(String path_scope) {
		this.path_scope = path_scope;
	}
	
}
