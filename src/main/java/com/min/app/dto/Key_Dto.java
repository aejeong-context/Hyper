package com.min.app.dto;

import java.io.Serializable;

public class Key_Dto implements Serializable {

	private static final long serialVersionUID = -284156306374803384L;

	private int user_seq;
	private String link_key;
	private String link_url;
	private String link_icon;
	private int link_order;

	public Key_Dto() {
	}

	public Key_Dto(int user_seq, String link_key, String link_url, String link_icon, int link_order) {
		super();
		this.user_seq = user_seq;
		this.link_key = link_key;
		this.link_url = link_url;
		this.link_icon = link_icon;
		this.link_order = link_order;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getLink_key() {
		return link_key;
	}

	public void setLink_key(String link_key) {
		this.link_key = link_key;
	}

	public String getLink_url() {
		return link_url;
	}

	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}

	public String getLink_icon() {
		return link_icon;
	}

	public void setLink_icon(String link_icon) {
		this.link_icon = link_icon;
	}

	public int getLink_order() {
		return link_order;
	}

	public void setLink_order(int link_order) {
		this.link_order = link_order;
	}

	@Override
	public String toString() {
		return "Key_Dto [user_seq=" + user_seq + ", link_key=" + link_key + ", link_url=" + link_url + ", link_icon="
				+ link_icon + ", link_order=" + link_order + "]";
	}
	
}
