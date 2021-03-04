package cn.com.relife.entity;
/**
 * @remark ������ʵ�����
 * @author ���
 * @createTime 09��10��
 * @version 1.0
 */
public class Parcel {
	private int pa_id;//����id
	private String pa_name;//��������
	private int pa_number;//����
	private String pa_type;//����
	private String pa_weight;//����
	private String pa_bulk;//���
	public Parcel() {
	}
	public Parcel(String pa_name, int pa_number, String pa_type, String pa_weight, String pa_bulk) {
		this.pa_name = pa_name;
		this.pa_number = pa_number;
		this.pa_type = pa_type;
		this.pa_weight = pa_weight;
		this.pa_bulk = pa_bulk;
	}
	public Parcel(int pa_id, String pa_name, int pa_number, String pa_type, String pa_weight, String pa_bulk) {
		super();
		this.pa_id = pa_id;
		this.pa_name = pa_name;
		this.pa_number = pa_number;
		this.pa_type = pa_type;
		this.pa_weight = pa_weight;
		this.pa_bulk = pa_bulk;
	}
	public int getPa_id() {
		return pa_id;
	}
	public void setPa_id(int pa_id) {
		this.pa_id = pa_id;
	}
	public String getPa_name() {
		return pa_name;
	}
	public void setPa_name(String pa_name) {
		this.pa_name = pa_name;
	}
	public int getPa_number() {
		return pa_number;
	}
	public void setPa_number(int pa_number) {
		this.pa_number = pa_number;
	}
	public String getPa_type() {
		return pa_type;
	}
	public void setPa_type(String pa_type) {
		this.pa_type = pa_type;
	}
	public String getPa_weight() {
		return pa_weight;
	}
	public void setPa_weight(String pa_weight) {
		this.pa_weight = pa_weight;
	}
	public String getPa_bulk() {
		return pa_bulk;
	}
	public void setPa_bulk(String pa_bulk) {
		this.pa_bulk = pa_bulk;
	}
	
}
