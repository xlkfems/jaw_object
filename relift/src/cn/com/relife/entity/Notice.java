package cn.com.relife.entity;

public class Notice {
	public int id;
	public String title;
	public String content;
	public String date_time;
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	public Notice(int id, String title, String content, String date_time) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date_time = date_time;
	}
	public Notice(String title, String content, String date_time) {
		this.title = title;
		this.content = content;
		this.date_time = date_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
}
