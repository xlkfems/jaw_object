package cn.com.relife.entity;
/**
 * @remark 接货单实体对象
 * @author 随便
 * @createTime 10点21分
 * @version 1.0
 */
import java.sql.Date;

public class Make {
	private int make_id;//接货单id
	private String make_date;//发货日期
	private String fre_number;//订单编号
	private String moneystate;//付款方式
	private String make_state;//取货方式
	private String make_people;//填票人
	private String make_time;//填票日期
	private String make_address;//中转站
	private String make_money;//中转费
	private String make_freight;//运费
	private String liaisons;//用户姓名
	private String phone;//用户手机号
	private String site;//用户地址
	private String remark;//备注
	private String make;//发货点
	private String make_receipt;//收货点
	private String take_Name;//收货姓名
	private String take_phone;//收货手机号
	private String take_site;//收货地址
	private String piece;//件数
	private String bulk;//体积
	private String support;//保价
	private String clerk;//职员编号
	private String state;
	public Make() {	
	}
	public Make(int make_id, String fre_number, String make_time) {
		this.make_id = make_id;
		this.fre_number = fre_number;
		this.make_time=make_time;
	}
	public Make(int make_id, String fre_number, String make_time, String remark,String state) {
		this.make_id = make_id;
		this.fre_number = fre_number;
		this.remark = remark;
		this.make_time=make_time;
		this.state=state;
	}
	public Make(int make_id, String make_date, String fre_number, String moneystate, String make_state,
			String make_people, String make_time, String make_address, String make_money, 
			String make_freight, String liaisons, String phone, String site, String remark, String make,
			String make_receipt, String take_Name, String take_phone, String take_site, String piece, String bulk,
			String support, String clerk,String state) {
		this.make_id = make_id;
		this.make_date = make_date;
		this.fre_number = fre_number;
		this.moneystate = moneystate;
		this.make_state = make_state;
		this.make_people = make_people;
		this.make_time = make_time;
		this.make_address = make_address;
		this.make_money = make_money;
		this.make_freight = make_freight;
		this.liaisons = liaisons;
		this.phone = phone;
		this.site = site;
		this.remark = remark;
		this.make = make;
		this.make_receipt = make_receipt;
		this.take_Name = take_Name;
		this.take_phone = take_phone;
		this.take_site = take_site;
		this.piece = piece;
		this.bulk = bulk;
		this.support = support;
		this.clerk = clerk;
		this.state=state;
	}
	public Make(String make_date, String moneystate, String make_state,
			String make_people, String make_time, String make_address, String make_money, 
			String make_freight,String remark,String make_receipt,  String make, String liaisons, String phone, String site, 
			String take_Name, String take_phone, String take_site, String fre_number, String piece, String bulk,
			String support, String clerk,String state) {
		this.make_date = make_date;
		this.fre_number = fre_number;
		this.moneystate = moneystate;
		this.make_state = make_state;
		this.make_people = make_people;
		this.make_time = make_time;
		this.make_address = make_address;
		this.make_money = make_money;
		this.make_freight = make_freight;
		this.liaisons = liaisons;
		this.phone = phone;
		this.site = site;
		this.remark = remark;
		this.make = make;
		this.make_receipt = make_receipt;
		this.take_Name = take_Name;
		this.take_phone = take_phone;
		this.take_site = take_site;
		this.piece = piece;
		this.bulk = bulk;
		this.support = support;
		this.clerk = clerk;
		this.state=state;
	}
	
	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public String getBulk() {
		return bulk;
	}

	public void setBulk(String bulk) {
		this.bulk = bulk;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public String getClerk() {
		return clerk;
	}

	public void setClerk(String clerk) {
		this.clerk = clerk;
	}

	public int getMake_id() {
		return make_id;
	}
	public void setMake_id(int make_id) {
		this.make_id = make_id;
	}
	public String getMake_date() {
		return make_date;
	}
	public void setMake_date(String make_date) {
		this.make_date = make_date;
	}
	public String getFre_number() {
		return fre_number;
	}
	public void setFre_number(String fre_number) {
		this.fre_number = fre_number;
	}
	public String getMoneystate() {
		return moneystate;
	}
	public void setMoneystate(String moneystate) {
		this.moneystate = moneystate;
	}
	public String getMake_state() {
		return make_state;
	}
	public void setMake_state(String make_state) {
		this.make_state = make_state;
	}
	public String getMake_people() {
		return make_people;
	}
	public void setMake_people(String make_people) {
		this.make_people = make_people;
	}
	public String getMake_time() {
		return make_time;
	}
	public void setMake_time(String make_time) {
		this.make_time = make_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMake_address() {
		return make_address;
	}
	public void setMake_address(String make_address) {
		this.make_address = make_address;
	}
	public String getMake_money() {
		return make_money;
	}
	public void setMake_money(String make_money) {
		this.make_money = make_money;
	}
	public String getMake_freight() {
		return make_freight;
	}
	public void setMake_freight(String make_freight) {
		this.make_freight = make_freight;
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
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getMake_receipt() {
		return make_receipt;
	}
	public void setMake_receipt(String make_receipt) {
		this.make_receipt = make_receipt;
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
	
}