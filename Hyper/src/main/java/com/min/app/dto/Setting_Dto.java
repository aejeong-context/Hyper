package com.min.app.dto;

import java.io.Serializable;

public class Setting_Dto implements Serializable {

	private static final long serialVersionUID = 8564496534137339220L;

	private int user_seq;
	private String setting_msg;
	private String setting_nck;
	private String setting_theme;
	private int image_seq;
	private String ori_image_name;
	private String sto_image_name;
	private int image_size;

	public Setting_Dto() {
	}

	public Setting_Dto(int user_seq, String setting_msg, String setting_nck, String setting_theme, int image_seq,
			String ori_image_name, String sto_image_name, int image_size) {
		super();
		this.user_seq = user_seq;
		this.setting_msg = setting_msg;
		this.setting_nck = setting_nck;
		this.setting_theme = setting_theme;
		this.image_seq = image_seq;
		this.ori_image_name = ori_image_name;
		this.sto_image_name = sto_image_name;
		this.image_size = image_size;
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

	public int getImage_seq() {
		return image_seq;
	}

	public void setImage_seq(int image_seq) {
		this.image_seq = image_seq;
	}

	public String getOri_image_name() {
		return ori_image_name;
	}

	public void setOri_image_name(String ori_image_name) {
		this.ori_image_name = ori_image_name;
	}

	public String getSto_image_name() {
		return sto_image_name;
	}

	public void setSto_image_name(String sto_image_name) {
		this.sto_image_name = sto_image_name;
	}

	public int getImage_size() {
		return image_size;
	}

	public void setImage_size(int image_size) {
		this.image_size = image_size;
	}

	@Override
	public String toString() {
		return "Setting_Dto [user_seq=" + user_seq + ", setting_msg=" + setting_msg + ", setting_nck=" + setting_nck
				+ ", setting_theme=" + setting_theme + ", image_seq=" + image_seq + ", ori_image_name=" + ori_image_name
				+ ", sto_image_name=" + sto_image_name + ", image_size=" + image_size + "]";
	}

	
}
