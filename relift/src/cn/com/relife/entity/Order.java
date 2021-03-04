package cn.com.relife.entity;
/**
 * 
 * @author jjjjf
 * @remark 用户实体类
 * @createTime 10.52
 * @version 1.0
 */
public class Order {
	private String jname;//寄件人姓名
	private String jphone;//寄件人电话
	private String jaddress1 ;// 寄件地址省
	private String jaddress2 ;// 寄件地址市
	private String jaddress3 ;// 寄件地址县/区
	private String jaddress4 ;// 寄件地址街道
	private String sname;//收件人姓名
	private String sphone;//收件人电话
	private String saddress1 ;// 收件地址省
	private String saddress2 ;// 收件地址市
	private String saddress3 ;// 收件地址县/区
	private String saddress4 ;// 收件地址街道
	private String hname;//货件名称
	private String weight;//货件重量
	private String type;//运输类型
	private String days;//上门日期
	private String time;//上门时间段
	private String pick;//提货方式
	private String money;//付款方式
	private String remark;//备注
	private String id;//订单编号
	public Order() {}
	public Order(String jname, String jphone, String jaddress1, String jaddress2, String jaddress3, String jaddress4,
			String sname, String sphone, String saddress1, String saddress2, String saddress3, String saddress4,
			String hname, String weight, String type, String days, String time, String pick, String money,
			String remark, String id) {
		this.jname = jname;
		this.jphone = jphone;
		this.jaddress1 = jaddress1;
		this.jaddress2 = jaddress2;
		this.jaddress3 = jaddress3;
		this.jaddress4 = jaddress4;
		this.sname = sname;
		this.sphone = sphone;
		this.saddress1 = saddress1;
		this.saddress2 = saddress2;
		this.saddress3 = saddress3;
		this.saddress4 = saddress4;
		this.hname = hname;
		this.weight = weight;
		this.type = type;
		this.days = days;
		this.time = time;
		this.pick = pick;
		this.money = money;
		this.remark = remark;
		this.id = id;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getJphone() {
		return jphone;
	}
	public void setJphone(String jphone) {
		this.jphone = jphone;
	}
	public String getJaddress1() {
		return jaddress1;
	}
	public void setJaddress1(String jaddress1) {
		this.jaddress1 = jaddress1;
	}
	public String getJaddress2() {
		return jaddress2;
	}
	public void setJaddress2(String jaddress2) {
		this.jaddress2 = jaddress2;
	}
	public String getJaddress3() {
		return jaddress3;
	}
	public void setJaddress3(String jaddress3) {
		this.jaddress3 = jaddress3;
	}
	public String getJaddress4() {
		return jaddress4;
	}
	public void setJaddress4(String jaddress4) {
		this.jaddress4 = jaddress4;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSaddress1() {
		return saddress1;
	}
	public void setSaddress1(String saddress1) {
		this.saddress1 = saddress1;
	}
	public String getSaddress2() {
		return saddress2;
	}
	public void setSaddress2(String saddress2) {
		this.saddress2 = saddress2;
	}
	public String getSaddress3() {
		return saddress3;
	}
	public void setSaddress3(String saddress3) {
		this.saddress3 = saddress3;
	}
	public String getSaddress4() {
		return saddress4;
	}
	public void setSaddress4(String saddress4) {
		this.saddress4 = saddress4;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPick() {
		return pick;
	}
	public void setPick(String pick) {
		this.pick = pick;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
