package cn.com.relife.entity;
/**
 * @remark 司机实体对象
 * @author 随便
 * @createTime 10点21分
 * @version 1.0
 */

public class Driver {
	private int dr_id;//司机id
	private String dr_number;//司机编号
	private String dr_name;//司机姓名
	private String dr_identity;//司机身份证
	private String dr_phone;//司机电话
	private String dr_sex;//司机性别
	private String dr_hoday;//司机生日
	private String dr_car;//车号
	private String dr_state;//车型
	private String dr_volume;//准载体积
	private String dr_load;//准载重量
	private String dr_address;//住址
	private String dr_long;//车辆长度
	private String dr_width;//车辆宽度
	private String dr_length;//载物高度
	private String dr_licence;//驾驶证
	private String dr_xing;//行驶证
	private String dr_run;//运营证
	private String dr_vin;//车辆状态
	private String dr_unit;//车属单位
	private String unit_phone;//单位号码
	private String dr_company;//公司车
	private String dr_remark;//备注
	
	public Driver() {
		// TODO Auto-generated constructor stub
	}
	public Driver(String dr_number) {
		this.dr_number=dr_number;
	}
	public Driver(String dr_number,String dr_name, String dr_identity, String dr_phone, String dr_sex, String dr_hoday, String dr_car,
			String dr_state, String dr_volume, String dr_load, String dr_address, String dr_long, String dr_width,
			String dr_length, String dr_licence, String dr_xing, String dr_run, String dr_vin, String dr_unit,
			String unit_phone, String dr_company, String dr_remark) {
		super();
		this.dr_number=dr_number;
		this.dr_name = dr_name;
		this.dr_identity = dr_identity;
		this.dr_phone = dr_phone;
		this.dr_sex = dr_sex;
		this.dr_hoday = dr_hoday;
		this.dr_car = dr_car;
		this.dr_state = dr_state;
		this.dr_volume = dr_volume;
		this.dr_load = dr_load;
		this.dr_address = dr_address;
		this.dr_long = dr_long;
		this.dr_width = dr_width;
		this.dr_length = dr_length;
		this.dr_licence = dr_licence;
		this.dr_xing = dr_xing;
		this.dr_run = dr_run;
		this.dr_vin = dr_vin;
		this.dr_unit = dr_unit;
		this.unit_phone = unit_phone;
		this.dr_company = dr_company;
		this.dr_remark = dr_remark;
	}
	public Driver(String dr_name, String dr_identity, String dr_phone, String dr_sex, String dr_hoday,
			String dr_car, String dr_state, String dr_volume, String dr_load, String dr_address, String dr_long,
			String dr_width, String dr_length, String dr_licence, String dr_xing, String dr_run, String dr_vin,
			String dr_unit, String unit_phone, String dr_company, String dr_remark,int dr_id) {
		super();
		this.dr_id = dr_id;
		this.dr_name = dr_name;
		this.dr_identity = dr_identity;
		this.dr_phone = dr_phone;
		this.dr_sex = dr_sex;
		this.dr_hoday = dr_hoday;
		this.dr_car = dr_car;
		this.dr_state = dr_state;
		this.dr_volume = dr_volume;
		this.dr_load = dr_load;
		this.dr_address = dr_address;
		this.dr_long = dr_long;
		this.dr_width = dr_width;
		this.dr_length = dr_length;
		this.dr_licence = dr_licence;
		this.dr_xing = dr_xing;
		this.dr_run = dr_run;
		this.dr_vin = dr_vin;
		this.dr_unit = dr_unit;
		this.unit_phone = unit_phone;
		this.dr_company = dr_company;
		this.dr_remark = dr_remark;
	}
	public Driver(int dr_id,String dr_number,String dr_name, String dr_identity, String dr_phone, String dr_sex, String dr_hoday,
			String dr_car, String dr_state, String dr_volume, String dr_load, String dr_address, String dr_long,
			String dr_width, String dr_length, String dr_licence, String dr_xing, String dr_run, String dr_vin,
			String dr_unit, String unit_phone, String dr_company, String dr_remark) {
		super();
		this.dr_number=dr_number;
		this.dr_id = dr_id;
		this.dr_name = dr_name;
		this.dr_identity = dr_identity;
		this.dr_phone = dr_phone;
		this.dr_sex = dr_sex;
		this.dr_hoday = dr_hoday;
		this.dr_car = dr_car;
		this.dr_state = dr_state;
		this.dr_volume = dr_volume;
		this.dr_load = dr_load;
		this.dr_address = dr_address;
		this.dr_long = dr_long;
		this.dr_width = dr_width;
		this.dr_length = dr_length;
		this.dr_licence = dr_licence;
		this.dr_xing = dr_xing;
		this.dr_run = dr_run;
		this.dr_vin = dr_vin;
		this.dr_unit = dr_unit;
		this.unit_phone = unit_phone;
		this.dr_company = dr_company;
		this.dr_remark = dr_remark;
	}
	
	public String getDr_number() {
		return dr_number;
	}
	public void setDr_number(String dr_number) {
		this.dr_number = dr_number;
	}
	public int getDr_id() {
		return dr_id;
	}
	public void setDr_id(int dr_id) {
		this.dr_id = dr_id;
	}
	public String getDr_name() {
		return dr_name;
	}
	public void setDr_name(String dr_name) {
		this.dr_name = dr_name;
	}
	public String getDr_identity() {
		return dr_identity;
	}
	public void setDr_identity(String dr_identity) {
		this.dr_identity = dr_identity;
	}
	public String getDr_phone() {
		return dr_phone;
	}
	public void setDr_phone(String dr_phone) {
		this.dr_phone = dr_phone;
	}
	public String getDr_sex() {
		return dr_sex;
	}
	public void setDr_sex(String dr_sex) {
		this.dr_sex = dr_sex;
	}
	public String getDr_hoday() {
		return dr_hoday;
	}
	public void setDr_hoday(String dr_hoday) {
		this.dr_hoday = dr_hoday;
	}
	public String getDr_car() {
		return dr_car;
	}
	public void setDr_car(String dr_car) {
		this.dr_car = dr_car;
	}
	public String getDr_state() {
		return dr_state;
	}
	public void setDr_state(String dr_state) {
		this.dr_state = dr_state;
	}
	public String getDr_volume() {
		return dr_volume;
	}
	public void setDr_volume(String dr_volume) {
		this.dr_volume = dr_volume;
	}
	public String getDr_load() {
		return dr_load;
	}
	public void setDr_load(String dr_load) {
		this.dr_load = dr_load;
	}
	public String getDr_address() {
		return dr_address;
	}
	public void setDr_address(String dr_address) {
		this.dr_address = dr_address;
	}
	public String getDr_long() {
		return dr_long;
	}
	public void setDr_long(String dr_long) {
		this.dr_long = dr_long;
	}
	public String getDr_width() {
		return dr_width;
	}
	public void setDr_width(String dr_width) {
		this.dr_width = dr_width;
	}
	public String getDr_length() {
		return dr_length;
	}
	public void setDr_length(String dr_length) {
		this.dr_length = dr_length;
	}
	public String getDr_licence() {
		return dr_licence;
	}
	public void setDr_licence(String dr_licence) {
		this.dr_licence = dr_licence;
	}
	public String getDr_xing() {
		return dr_xing;
	}
	public void setDr_xing(String dr_xing) {
		this.dr_xing = dr_xing;
	}
	public String getDr_run() {
		return dr_run;
	}
	public void setDr_run(String dr_run) {
		this.dr_run = dr_run;
	}
	public String getDr_vin() {
		return dr_vin;
	}
	public void setDr_vin(String dr_vin) {
		this.dr_vin = dr_vin;
	}
	public String getDr_unit() {
		return dr_unit;
	}
	public void setDr_unit(String dr_unit) {
		this.dr_unit = dr_unit;
	}
	public String getUnit_phone() {
		return unit_phone;
	}
	public void setUnit_phone(String unit_phone) {
		this.unit_phone = unit_phone;
	}
	public String getDr_company() {
		return dr_company;
	}
	public void setDr_company(String dr_company) {
		this.dr_company = dr_company;
	}
	public String getDr_remark() {
		return dr_remark;
	}
	public void setDr_remark(String dr_remark) {
		this.dr_remark = dr_remark;
	}
	
}
