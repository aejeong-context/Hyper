package com.min.app.dto;

import java.io.Serializable;

public class User_Dto implements Serializable {

	private static final long serialVersionUID = 7758803939744830818L;

	private int user_seq;
	private String user_email;
	private String user_pw;
	private String setting_nck;

	public User_Dto() {
	}

	public User_Dto(int user_seq, String user_email, String user_pw, String setting_nck) {
		super();
		this.user_seq = user_seq;
		this.user_email = user_email;
		this.user_pw = user_pw;
		this.setting_nck = setting_nck;
		
	}
	

	
	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getSetting_nck() {
		return setting_nck;
	}

	public void setSetting_nck(String setting_nck) {
		this.setting_nck = setting_nck;
	}

	@Override
	public String toString() {
		return "User_Dto [user_seq=" + user_seq + ", user_email=" + user_email + ", user_pw=" + user_pw
				+ ", setting_nck=" + setting_nck + "]";
	}


	
}
