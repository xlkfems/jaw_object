package cn.com.relife.entity;
/**
 * @remark 运输合同实体对象
 * @author 随便
 * @createTime 09点53分
 * @version 1.0
 */
public class Contract {
	private int con_id;//id
	private String fre_number;//订单编号
	private String make_receipt;//收货地
	private String make;//发货地
	private String bi_state;//发货时间
	private String take_Name;//收货姓名
	private String take_phone;//收货手机号
	private String take_site;//收货地址
	private String con_close;//运费结算方式
	private String con_remark;//备注
	private String dr_number;//司机编号
	private String con_time;//签订时间
	private String con_freight;//总运费
	private String con_receipt;//回执单状态
	public Contract() {
		// TODO Auto-generated constructor stub
	}
	
	public Contract(String fre_number, String make_receipt, String make, String bi_state, String take_Name,
			String take_phone, String take_site, String con_close, String con_remark, String dr_number,
			 String con_time, String con_freight, String con_receipt) {
		this.fre_number = fre_number;
		this.make_receipt = make_receipt;
		this.make = make;
		this.bi_state = bi_state;
		this.take_Name = take_Name;
		this.take_phone = take_phone;
		this.take_site = take_site;
		this.con_close = con_close;
		this.con_remark = con_remark;
		this.dr_number = dr_number;
		this.con_time = con_time;
		this.con_freight = con_freight;
		this.con_receipt = con_receipt;
	}
	public Contract(int con_id, String fre_number, String make_receipt, String make, String bi_state, String take_Name,
			String take_phone, String take_site, String con_close, String con_remark, String dr_number,
			 String con_time, String con_freight, String con_receipt) {
		super();
		this.con_id = con_id;
		this.fre_number = fre_number;
		this.make_receipt = make_receipt;
		this.make = make;
		this.bi_state = bi_state;
		this.take_Name = take_Name;
		this.take_phone = take_phone;
		this.take_site = take_site;
		this.con_close = con_close;
		this.con_remark = con_remark;
		this.dr_number = dr_number;
		this.con_time = con_time;
		this.con_freight = con_freight;
		this.con_receipt = con_receipt;
	}
	public Contract(int con_id, String fre_number, String take_Name, String con_receipt) {
		this.con_id = con_id;
		this.fre_number = fre_number;
		this.take_Name = take_Name;
		this.con_receipt = con_receipt;
	}
	public int getCon_id() {
		return con_id;
	}
	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}
	public String getFre_number() {
		return fre_number;
	}
	public void setFre_number(String fre_number) {
		this.fre_number = fre_number;
	}
	public String getMake_receipt() {
		return make_receipt;
	}
	public void setMake_receipt(String make_receipt) {
		this.make_receipt = make_receipt;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getBi_state() {
		return bi_state;
	}
	public void setBi_state(String bi_state) {
		this.bi_state = bi_state;
	}
	public String getTake_Name() {
		return take_Name;
	}
	public void setTake_Name(String take_Name) {
		this.take_Name = take_Name;
	}
	public String getTake_phone() {
		return take_phone;
	}
	public void setTake_phone(String take_phone) {
		this.take_phone = take_phone;
	}
	public String getTake_site() {
		return take_site;
	}
	public void setTake_site(String take_site) {
		this.take_site = take_site;
	}
	public String getCon_close() {
		return con_close;
	}
	public void setCon_close(String con_close) {
		this.con_close = con_close;
	}
	public String getCon_remark() {
		return con_remark;
	}
	public void setCon_remark(String con_remark) {
		this.con_remark = con_remark;
	}
	public String getDr_number() {
		return dr_number;
	}
	public void setDr_number(String dr_number) {
		this.dr_number = dr_number;
	}
	public String getCon_time() {
		return con_time;
	}
	public void setCon_time(String con_time) {
		this.con_time = con_time;
	}
	public String getCon_freight() {
		return con_freight;
	}
	public void setCon_freight(String con_freight) {
		this.con_freight = con_freight;
	}
	public String getCon_receipt() {
		return con_receipt;
	}
	public void setCon_receipt(String con_receipt) {
		this.con_receipt = con_receipt;
	}
	
}
