package cn.com.relife.entity;
/**
 * @remark �ͻ���Ϣʵ�����
 * @author ���
 * @createTime 10��21��
 * @version 1.0
 */
public class UserInfo {
	private int client_id;//����������û�
	private String number;//�ͻ���� ��cl��ͷ��Ϊ6λ�����
	private String liaisons;//��ϵ������
	private String phone;//��ϵ�ֻ���
	private String company;//��˾����
	private String site;//��ַ��Ϣ
	private String detail;//��ϸ��ַ
	private String dawk;//��������
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
