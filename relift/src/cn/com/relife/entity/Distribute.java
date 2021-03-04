package cn.com.relife.entity;
/**
 * @remark 分发票据实体对象
 * @author 随便
 * @createTime 10点21分
 * @version 1.0
 */
public class Distribute {
	private int fre_id;//货运id,外键
	private String dis_name;//分发人
	private String neck_name;//领票人
	private String neck_date;//领票时间
	private String Jaddress;//接货点
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
