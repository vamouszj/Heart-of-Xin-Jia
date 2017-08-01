package com.bean;

public class RegisterBean {
	private int R_id;
	private String user_name;
	private String user_passwd;
	private String register_phone_num;
	private String register_mailbox;
	public int getR_id() {
		return R_id;
	}
	public void setR_id(int r_id) {
		R_id = r_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public String getRegister_phone_num() {
		return register_phone_num;
	}
	public void setRegister_phone_num(String register_phone_num) {
		this.register_phone_num = register_phone_num;
	}
	public String getRegister_mailbox() {
		return register_mailbox;
	}
	public void setRegister_mailbox(String register_mailbox) {
		this.register_mailbox = register_mailbox;
	}
	
}
