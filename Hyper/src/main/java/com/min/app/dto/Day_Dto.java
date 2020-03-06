package com.min.app.dto;

import java.io.Serializable;

public class Day_Dto implements Serializable{

	private static final long serialVersionUID = -7785140416981500871L;

	private int user_seq;
	private String day_title;
	private String day_date;
	private int day_seq;
	
	public Day_Dto() {
	}

	public Day_Dto(int user_seq, String day_title, String day_date, int day_seq) {
		super();
		this.user_seq = user_seq;
		this.day_title = day_title;
		this.day_date = day_date;
		this.day_seq = day_seq;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getDay_title() {
		return day_title;
	}

	public void setDay_title(String day_title) {
		this.day_title = day_title;
	}

	public String getDay_date() {
		return day_date;
	}

	public void setDay_date(String day_date) {
		this.day_date = day_date;
	}

	public int getDay_seq() {
		return day_seq;
	}

	public void setDay_seq(int day_seq) {
		this.day_seq = day_seq;
	}

	@Override
	public String toString() {
		return "Day_Dto [user_seq=" + user_seq + ", day_title=" + day_title + ", day_date=" + day_date
				+ ", day_seq=" + day_seq + "]";
	}
	
}
