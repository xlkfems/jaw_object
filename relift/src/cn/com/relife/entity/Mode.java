package cn.com.relife.entity;

public class Mode {
	private int id;
	private String fre_number;
	private String dr_number;
	private String make_receipt;
	private String make;
	private String con_receipt;
	private String location;
	public Mode() {
		// TODO Auto-generated constructor stub
	}
	public Mode(String fre_number, String dr_number, String make_receipt, String make, String con_receipt,
			String location) {
		this.fre_number = fre_number;
		this.dr_number = dr_number;
		this.make_receipt = make_receipt;
		this.make = make;
		this.con_receipt = con_receipt;
		this.location = location;
	}
	public Mode(int id, String fre_number, String dr_number, String make_receipt, String make, String con_receipt,
			String location) {
		super();
		this.id = id;
		this.fre_number = fre_number;
		this.dr_number = dr_number;
		this.make_receipt = make_receipt;
		this.make = make;
		this.con_receipt = con_receipt;
		this.location = location;
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
	public String getDr_number() {
		return dr_number;
	}
	public void setDr_number(String dr_number) {
		this.dr_number = dr_number;
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
	public String getCon_receipt() {
		return con_receipt;
	}
	public void setCon_receipt(String con_receipt) {
		this.con_receipt = con_receipt;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
