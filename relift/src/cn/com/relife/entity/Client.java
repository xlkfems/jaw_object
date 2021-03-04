package cn.com.relife.entity;
/**
 * @remark �ͻ�ʵ�����
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public class Client {
	private int id;
	private String number;//�ͻ����
	private String name;//�ͻ�����
	private String phone;//�ͻ��绰
	private String fax;//�ͻ�����
	private String postcode;//�ͻ��ʱ�
	private String address;//�ͻ���ַ
	private String contact;//��ϵ��
	private String conphone;//��ϵ���ֻ�
	private String usertype;//�ͻ�����
	private String enterprise;//��ҵ����
	private String scale;//��ҵ��ģ
	private String email;//�����ʼ�
	
	public Client() {}
	
	public Client(int id,String number,String name, String phone, String fax, String postcode, String address, String contact,
			String conphone, String usertype, String enterprise, String scale, String email) {
		super();
		this.number = number;
		this.name = name;
		this.phone = phone;
		this.fax = fax;
		this.postcode = postcode;
		this.address = address;
		this.contact = contact;
		this.conphone = conphone;
		this.usertype = usertype;
		this.enterprise = enterprise;
		this.scale = scale;
		this.email = email;
		this.id = id;
	}
	public Client(String name, String phone, String fax, String postcode, String address, String contact,
			String conphone, String usertype, String enterprise, String scale, String email,int id) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.fax = fax;
		this.postcode = postcode;
		this.address = address;
		this.contact = contact;
		this.conphone = conphone;
		this.usertype = usertype;
		this.enterprise = enterprise;
		this.scale = scale;
		this.email = email;
	}
	public Client(String number,String name, String phone, String fax, String postcode, String address, String contact,
			String conphone, String usertype, String enterprise, String scale, String email) {
		super();
		this.number = number;
		this.name = name;
		this.phone = phone;
		this.fax = fax;
		this.postcode = postcode;
		this.address = address;
		this.contact = contact;
		this.conphone = conphone;
		this.usertype = usertype;
		this.enterprise = enterprise;
		this.scale = scale;
		this.email = email;
	}
	
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getConphone() {
		return conphone;
	}
	public void setConphone(String conphone) {
		this.conphone = conphone;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
