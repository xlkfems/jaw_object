package cn.com.relife.entity;

import java.util.Date;

public class Message {
	private int id;
	private String number;
	private String title;
	private String content;
	private String name;
	private String time;
	
	public Message() {
		
	}

	public Message(String number,String title, String content, String name, String time) {
		super();
		this.title = title;
		this.content = content;
		this.name = name;
		this.time = time;
		this.number=number;
	}
	public Message(String title, String content, String name) {
		super();
		this.title = title;
		this.content = content;
		this.name = name;
	}
	public Message(String title) {
		super();
		this.title = title;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
