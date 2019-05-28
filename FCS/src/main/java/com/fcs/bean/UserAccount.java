package com.fcs.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserAccount {
	@NotEmpty
    private String userId;

	@NotEmpty
    private String userAccount;

	@NotEmpty
    private String userPassword;

	@NotNull
    private Integer userType;

	@NotEmpty
    private String userRegtime;

	@NotNull
    private Integer userStatus;

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