package cn.com.relife.entity;
/**
 * @remark 路线信息实体对象
 * @author 随便
 * @createTime 10点21分
 * @version 1.0
 */

public class Way {
	private int way_id;//路线信息id
	private String way_come;//出发地
	private String way_reach;//到达地
	private String way_mileage;//里程
	private String way_time;//耗时
	private String way_pass;//经过站点
	public Way() {
		// TODO Auto-generated constructor stub
	}
	public Way(int way_id, String way_come, String way_reach, String way_mileage, String way_time, String way_pass) {
		super();
		this.way_id = way_id;
		this.way_come = way_come;
		this.way_reach = way_reach;
		this.way_mileage = way_mileage;
		this.way_time = way_time;
		this.way_pass = way_pass;
	}
	public int getWay_id() {
		return way_id;
	}
	public void setWay_id(int way_id) {
		this.way_id = way_id;
	}
	public String getWay_come() {
		return way_come;
	}
	public void setWay_come(String way_come) {
		this.way_come = way_come;
	}
	public String getWay_reach() {
		return way_reach;
	}
	public void setWay_reach(String way_reach) {
		this.way_reach = way_reach;
	}
	public String getWay_mileage() {
		return way_mileage;
	}
	public void setWay_mileage(String way_mileage) {
		this.way_mileage = way_mileage;
	}
	public String getWay_time() {
		return way_time;
	}
	public void setWay_time(String way_time) {
		this.way_time = way_time;
	}
	public String getWay_pass() {
		return way_pass;
	}
	public void setWay_pass(String way_pass) {
		this.way_pass = way_pass;
	}
	
}
