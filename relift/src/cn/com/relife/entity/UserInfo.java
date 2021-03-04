package cn.com.relife.entity;
/**
 * @remark 客户信息实体对象
 * @author 随便
 * @createTime 10点21分
 * @version 1.0
 */
public class UserInfo {
	private int client_id;//外键，连接用户
	private String number;//客户编号 由cl开头后方为6位随机数
	private String liaisons;//联系人姓名
	private String phone;//联系手机号
	private String company;//公司名称
	private String site;//地址信息
	private String detail;//详细地址
	private String dawk;//邮政编码
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String number, String liaisons, String phone, String company, String site,
			String detail, String dawk) {
		this.number = number;
		this.liaisons = liaisons;
		this.phone = phone;
		this.company = company;
		this.site = site;
		this.detail = detail;
		this.dawk = dawk;
	}
	public UserInfo(int client_id, String number, String liaisons, String phone, String company, String site,
			String detail, String dawk) {
		super();
		this.client_id = client_id;
		this.number = number;
		this.liaisons = liaisons;
		this.phone = phone;
		this.company = company;
		this.site = site;
		this.detail = detail;
		this.dawk = dawk;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getLiaisons() {
		return liaisons;
	}
	public void setLiaisons(String liaisons) {
		this.liaisons = liaisons;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getDawk() {
		return dawk;
	}
	public void setDawk(String dawk) {
		this.dawk = dawk;
	}
	
}
