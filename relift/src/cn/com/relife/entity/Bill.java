package cn.com.relife.entity;
/**
 * @remark Ʊ��ʵ�����
 * @author ���
 * @createTime 10��21��
 * @version 1.0
 */

public class Bill {
	private int bi_id;//Ʊ��id
	private String bi_number;//���˱��
	private String bi_date;//��д����
	private String bi_state;//��Ʊʱ��
	private String bi_driver;//��Ʊ��
	private String make_cargo;//�ӻ���
	private String distribute;//�ַ���
	private String state;//״̬
	
	
	public Bill() {
	}
	public Bill(int bi_id, String bi_number, String bi_date, String state) {
		super();
		this.bi_id = bi_id;
		this.bi_number = bi_number;
		this.bi_date = bi_date;
		this.state = state;
	}
	public Bill( String bi_number, String bi_date, String bi_state, String bi_driver, String make_cargo,
			String distribute,String state) {
		this.bi_number = bi_number;
		this.bi_date = bi_date;
		this.bi_state = bi_state;
		this.bi_driver = bi_driver;
		this.make_cargo = make_cargo;
		this.distribute = distribute;
		this.state=state;
	}
	public Bill(int bi_id, String bi_number, String bi_date, String bi_state, String bi_driver, String make_cargo,
			String distribute, String state) {
		super();
		this.bi_id = bi_id;
		this.bi_number = bi_number;
		this.bi_date = bi_date;
		this.bi_state = bi_state;
		this.bi_driver = bi_driver;
		this.make_cargo = make_cargo;
		this.distribute = distribute;
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getBi_id() {
		return bi_id;
	}
	public void setBi_id(int bi_id) {
		this.bi_id = bi_id;
	}
	public String getBi_number() {
		return bi_number;
	}
	public void setBi_number(String bi_number) {
		this.bi_number = bi_number;
	}
	public String getBi_date() {
		return bi_date;
	}
	public void setBi_date(String bi_date) {
		this.bi_date = bi_date;
	}
	public String getBi_state() {
		return bi_state;
	}
	public void setBi_state(String bi_state) {
		this.bi_state = bi_state;
	}
	public String getBi_driver() {
		return bi_driver;
	}
	public void setBi_driver(String bi_driver) {
		this.bi_driver = bi_driver;
	}
	public String getMake_cargo() {
		return make_cargo;
	}
	public void setMake_cargo(String make_cargo) {
		this.make_cargo = make_cargo;
	}
	public String getDistribute() {
		return distribute;
	}
	public void setDistribute(String distribute) {
		this.distribute = distribute;
	}
}
