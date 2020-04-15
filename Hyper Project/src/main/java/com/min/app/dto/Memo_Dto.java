package com.min.app.dto;

import java.io.Serializable;

public class Memo_Dto implements Serializable{
	
	private static final long serialVersionUID = -3394832755757405725L;
	
	private int user_seq;
	private int memo_seq;
	private String memo_con;
	
	public Memo_Dto() {
	}
	public Memo_Dto(int user_seq, int memo_seq, String memo_con) {
		super();
		this.user_seq = user_seq;
		this.memo_seq = memo_seq;
		this.memo_con = memo_con;
	}
	public int getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}
	public int getMemo_seq() {
		return memo_seq;
	}
	public void setMemo_seq(int memo_seq) {
		this.memo_seq = memo_seq;
	}
	public String getMemo_con() {
		return memo_con;
	}
	public void setMemo_con(String memo_con) {
		this.memo_con = memo_con;
	}
	@Override
	public String toString() {
		return "Memo_Dto [user_seq=" + user_seq + ", memo_seq=" + memo_seq + ", memo_con=" + memo_con + "]";
	}
	
}
