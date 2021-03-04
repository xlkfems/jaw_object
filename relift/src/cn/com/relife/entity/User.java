package cn.com.relife.entity;
/**
 * 
 * @author jjjjf
 * @remark 用户实体类
 * @createTime 10.52
 * @version 1.0
 */
public class User {
	private String email;//邮箱
	private String pwd;//密码
	public User() {}
	public User(String email,String pwd) {
		this.email=email;
		this.pwd=pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
