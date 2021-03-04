package cn.com.relife.entity;

public class Nmsl {
	private int id;
	private String location;
	private Double longitude;
	private Double latitude;
	private String reveal;
	public Nmsl() {
		// TODO Auto-generated constructor stub
	}
	public Nmsl(String location, Double longitude, Double latitude, String reveal) {

		this.location = location;
		this.longitude = longitude;
		this.latitude = latitude;
		this.reveal = reveal;
	}
	public Nmsl(int id, String location, Double longitude, Double latitude, String reveal) {
		super();
		this.id = id;
		this.location = location;
		this.longitude = longitude;
		this.latitude = latitude;
		this.reveal = reveal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getReveal() {
		return reveal;
	}
	public void setReveal(String reveal) {
		this.reveal = reveal;
	}
	
}
