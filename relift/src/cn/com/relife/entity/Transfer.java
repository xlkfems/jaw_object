package cn.com.relife.entity;
/**
 * @remark ��תվ��ʵ�����
 * @author ���
 * @createTime 23��20��
 * @version 1.0
 */
public class Transfer {
	private int tr_id;//id
	private String tr_city;//����
	private String tr_name;//վ������
	private String tr_phone;//��ϵ�绰
	private String tr_address;//��ϸ��ַ
	private String tr_longitude;//��γ��
	public Transfer() {
		// TODO Auto-generated constructor stub
	}
	
	public Transfer(String tr_city, String tr_name, String tr_phone, String tr_address,
			String tr_longitude) {
		this.tr_city = tr_city;
		this.tr_name = tr_name;
		this.tr_phone = tr_phone;
		this.tr_address = tr_address;
		this.tr_longitude = tr_longitude;
	}
	
	public Transfer(int tr_id, String tr_city, String tr_name, String tr_phone, String tr_address,
			String tr_longitude) {
		super();
		this.tr_id = tr_id;
		this.tr_city = tr_city;
		this.tr_name = tr_name;
		this.tr_phone = tr_phone;
		this.tr_address = tr_address;
		this.tr_longitude = tr_longitude;
	}

	public int getTr_id() {
		return tr_id;
	}
	public void setTr_id(int tr_id) {
		this.tr_id = tr_id;
	}
	public String getTr_city() {
		return tr_city;
	}
	public void setTr_city(String tr_city) {
		this.tr_city = tr_city;
	}
	public String getTr_name() {
		return tr_name;
	}
	public void setTr_name(String tr_name) {
		this.tr_name = tr_name;
	}
	public String getTr_phone() {
		return tr_phone;
	}
	public void setTr_phone(String tr_phone) {
		this.tr_phone = tr_phone;
	}
	public String getTr_address() {
		return tr_address;
	}
	public void setTr_address(String tr_address) {
		this.tr_address = tr_address;
	}

	public String getTr_longitude() {
		return tr_longitude;
	}

	public void setTr_longitude(String tr_longitude) {
		this.tr_longitude = tr_longitude;
	}
	
}
