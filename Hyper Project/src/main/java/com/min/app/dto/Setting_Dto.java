package com.min.app.dto;

import java.io.Serializable;

public class Setting_Dto implements Serializable {

	private static final long serialVersionUID = 8564496534137339220L;

	private int user_seq;
	private String setting_msg;
	private String setting_nck;
	private String setting_theme;

	public Setting_Dto() {
	}

	public Setting_Dto(int user_seq, String setting_msg, String setting_nck, String setting_theme) {
		super();
		this.user_seq = user_seq;
		this.setting_msg = setting_msg;
		this.setting_nck = setting_nck;
		this.setting_theme = setting_theme;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getSetting_msg() {
		return setting_msg;
	}

	public void setSetting_msg(String setting_msg) {
		this.setting_msg = setting_msg;
	}

	public String getSetting_nck() {
		return setting_nck;
	}

	public void setSetting_nck(String setting_nck) {
		this.setting_nck = setting_nck;
	}

	public String getSetting_theme() {
		return setting_theme;
	}

	public void setSetting_theme(String setting_theme) {
		this.setting_theme = setting_theme;
	}

	@Override
	public String toString() {
		return "Setting_Dto [user_seq=" + user_seq + ", setting_msg=" + setting_msg + ", setting_nck=" + setting_nck
				+ ", setting_theme=" + setting_theme + "]";
	}

}
