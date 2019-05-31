package com.fcs.utils;

public class TokenInfo {

	private String token;
	private boolean isOverdue;

	public TokenInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TokenInfo(String token, boolean isOverdue) {
		super();
		this.token = token;
		this.isOverdue = isOverdue;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isOverdue() {
		return isOverdue;
	}

	public void setOverdue(boolean isOverdue) {
		this.isOverdue = isOverdue;
	}
}
