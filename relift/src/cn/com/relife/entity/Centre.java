package cn.com.relife.entity;

public class Centre {
	private int id;
	private String fre_number;
	private String location;
	private String dr_number;
	private String reception_time;
	private String tr_name;
	private String tr_address;
	private String tr_phone;
	
	public Centre(String fre_number, String location, String dr_number, String reception_time, String tr_name,
			String tr_address, String tr_phone) {
		this.fre_number = fre_number;
		this.location = location;
		this.dr_number = dr_number;
		this.reception_time = reception_time;
		this.tr_name = tr_name;
		this.tr_address = tr_address;
		this.tr_phone = tr_phone;
	}
	public Centre(int id, String fre_number, String location, String dr_number, String reception_time, String tr_name,
			String tr_address, String tr_phone) {
		super();
		this.id = id;
		this.fre_number = fre_number;
		this.location = location;
		this.dr_number = dr_number;
		this.reception_time = reception_time;
		this.tr_name = tr_name;
		this.tr_address = tr_address;
		this.tr_phone = tr_phone;
	}
	public Centre() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFre_number() {
		return fre_number;
	}
	public void setFre_number(String fre_number) {
		this.fre_number = fre_number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDr_number() {
		return dr_number;
	}
	public void setDr_number(String dr_number) {
		this.dr_number = dr_number;
	}
	public String getReception_time() {
		return reception_time;
	}
	public void setReception_time(String reception_time) {
		this.reception_time = reception_time;
	}
	public String getTr_name() {
		return tr_name;
	}
	public void setTr_name(String tr_name) {
		this.tr_name = tr_name;
	}
	public String getTr_address() {
		return tr_address;
	}
	public void setTr_address(String tr_address) {
		this.tr_address = tr_address;
	}
	public String getTr_phone() {
		return tr_phone;
	}
	public void setTr_phone(String tr_phone) {
		this.tr_phone = tr_phone;
	}
	
}
