package cn.com.relife.entity;
/**
 * @remark �ַ�Ʊ��ʵ�����
 * @author ���
 * @createTime 10��21��
 * @version 1.0
 */
public class Distribute {
	private int fre_id;//����id,���
	private String dis_name;//�ַ���
	private String neck_name;//��Ʊ��
	private String neck_date;//��Ʊʱ��
	private String Jaddress;//�ӻ���
	public Distribute() {
	}
	public Distribute(String dis_name, String neck_name, String neck_date, String jaddress) {
		this.dis_name = dis_name;
		this.neck_name = neck_name;
		this.neck_date = neck_date;
		Jaddress = jaddress;
	}
	public Distribute(int fre_id, String dis_name, String neck_name, String neck_date, String jaddress) {
		this.fre_id = fre_id;
		this.dis_name = dis_name;
		this.neck_name = neck_name;
		this.neck_date = neck_date;
		Jaddress = jaddress;
	}
	public int getFre_id() {
		return fre_id;
	}
	public void setFre_id(int fre_id) {
		this.fre_id = fre_id;
	}
	public String getDis_name() {
		return dis_name;
	}
	public void setDis_name(String dis_name) {
		this.dis_name = dis_name;
	}
	public String getNeck_name() {
		return neck_name;
	}
	public void setNeck_name(String neck_name) {
		this.neck_name = neck_name;
	}
	public String getNeck_date() {
		return neck_date;
	}
	public void setNeck_date(String neck_date) {
		this.neck_date = neck_date;
	}
	public String getJaddress() {
		return Jaddress;
	}
	public void setJaddress(String jaddress) {
		Jaddress = jaddress;
	}
	
}
