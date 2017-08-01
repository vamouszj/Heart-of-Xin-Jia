package com.bean;

import java.sql.Date;

public class PourBean {
	private int pour_id;
	private String user_name;
	private String pour_out_time;
	private String pour_out_title;
	public int getPour_id() {
		return pour_id;
	}
	public void setPour_id(int pour_id) {
		this.pour_id = pour_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPour_out_time() {
		return pour_out_time;
	}
	public void setPour_out_time(String pour_out_time) {
		this.pour_out_time = pour_out_time;
	}
	public String getPour_out_title() {
		return pour_out_title;
	}
	public void setPour_out_title(String pour_out_title) {
		this.pour_out_title = pour_out_title;
	}
	
	
}
