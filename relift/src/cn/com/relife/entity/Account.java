package cn.com.relife.entity;
/**
 * @remark �ͻ�ʵ�����
 * @author ���
 * @createTime 09��55��
 * @version 1.0
 */

public class Account {
	private int lsid;//�ͻ�id
	private String email;//����
	private String password;//����
	public Account() {
	}
	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public Account(int lsid, String email, String password) {
		super();
		this.lsid = lsid;
		this.email = email;
		this.password = password;
	}
	public int getLsid() {
		return lsid;
	}
	public void setLsid(int lsid) {
		this.lsid = lsid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
