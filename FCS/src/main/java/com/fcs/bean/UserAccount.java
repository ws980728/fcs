package com.fcs.bean;

public class UserAccount {
	private String userId;

	private String userAccount;

	private String userPassword;

	private Integer userType;

	private String userRegtime;

	private Integer userStatus;

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccount(String userId, String userAccount, String userPassword, Integer userType, String userRegtime,
			Integer userStatus) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userRegtime = userRegtime;
		this.userStatus = userStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount == null ? null : userAccount.trim();
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword == null ? null : userPassword.trim();
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserRegtime() {
		return userRegtime;
	}

	public void setUserRegtime(String userRegtime) {
		this.userRegtime = userRegtime == null ? null : userRegtime.trim();
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
}