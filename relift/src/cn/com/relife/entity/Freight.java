package cn.com.relife.entity;
/**
 * @remark 货运单实体对象
 * @author 随便
 * @createTime 10点21分
 * @version 1.0
 */

public class Freight {
	private int client_id;//发货人id,外键连接用户
	private int take_id;//收货人id,外键
	private int pa_id;//货物id，外键
	private int fre_id;//货运id
	private String fre_number;//货运单编号
	private String send_name;//发货人姓名
	private String put_name;//收货人姓名
	private String send;//发货地
	private String put;//收货地
	private String state;//货物状态
	public Freight() {
	}
	public Freight(int client_id, int take_id, int pa_id, int fre_id, String fre_number, String send_name,
			String put_name, String send, String put, String state) {
		super();
		this.client_id = client_id;
		this.take_id = take_id;
		this.pa_id = pa_id;
		this.fre_id = fre_id;
		this.fre_number = fre_number;
		this.send_name = send_name;
		this.put_name = put_name;
		this.send = send;
		this.put = put;
		this.state = state;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getTake_id() {
		return take_id;
	}
	public void setTake_id(int take_id) {
		this.take_id = take_id;
	}
	public int getPa_id() {
		return pa_id;
	}
	public void setPa_id(int pa_id) {
		this.pa_id = pa_id;
	}
	public int getFre_id() {
		return fre_id;
	}
	public void setFre_id(int fre_id) {
		this.fre_id = fre_id;
	}
	public String getFre_number() {
		return fre_number;
	}
	public void setFre_number(String fre_number) {
		this.fre_number = fre_number;
	}
	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}
	public String getPut_name() {
		return put_name;
	}
	public void setPut_name(String put_name) {
		this.put_name = put_name;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getPut() {
		return put;
	}
	public void setPut(String put) {
		this.put = put;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
