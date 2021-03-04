package cn.com.relife.entity;
/**
 * @remark 客户实体对象
 * @author 随便
 * @createTime 09点55分
 * @version 1.0
 */

public class Account {
	private int lsid;//客户id
	private String email;//邮箱
	private String password;//密码
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
