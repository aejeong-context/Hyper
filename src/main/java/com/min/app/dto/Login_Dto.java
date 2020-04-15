package com.min.app.dto;

import java.io.Serializable;


public class Login_Dto implements Serializable{

	private static final long serialVersionUID = -2862688828267750056L;

	private User_Dto user_dto;
	private boolean result;
	
	public Login_Dto() {
	}

	public Login_Dto(User_Dto user_dto, boolean result) {
		super();
		this.user_dto = user_dto;
		this.result = result;
	}

	public User_Dto getUser_dto() {
		return user_dto;
	}

	public void setUser_dto(User_Dto user_dto) {
		this.user_dto = user_dto;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Login_Dto [user_dto=" + user_dto + ", result=" + result + "]";
	}
	
}
