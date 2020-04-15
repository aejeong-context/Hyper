package com.min.app.dto;

import java.io.Serializable;

public class File_Dto implements Serializable {
	
	private static final long serialVersionUID = 3462202037100883045L;
	
	private int user_seq;
	private int image_seq;
	private String ori_image_name;
	private String sto_image_name;
	private long image_size;
	
	public File_Dto() {
	}
	
	public File_Dto(int user_seq, int image_seq, String ori_image_name, String sto_image_name, long image_size) {
		super();
		this.user_seq = user_seq;
		this.image_seq = image_seq;
		this.ori_image_name = ori_image_name;
		this.sto_image_name = sto_image_name;
		this.image_size = image_size;
	}
	
	public File_Dto(int user_seq, String ori_image_name, String sto_image_name, long image_size) {
		super();
		this.user_seq = user_seq;
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
	public long getImage_size() {
		return image_size;
	}
	public void setImage_size(long image_size) {
		this.image_size = image_size;
	}
	@Override
	public String toString() {
		return "File_Dto [user_seq=" + user_seq + ", image_seq=" + image_seq + ", ori_image_name=" + ori_image_name
				+ ", sto_image_name=" + sto_image_name + ", image_size=" + image_size + "]";
	}
	
}
