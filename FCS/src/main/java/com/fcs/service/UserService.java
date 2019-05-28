package com.fcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcs.bean.UserAccount;
import com.fcs.dao.UserAccountMapper;

@Service
public class UserService {

	@Autowired
	private UserAccountMapper userAccountMapper;

	// 新增用户
	public int insertUserAccount(UserAccount userAccount) {
		//userAccountMapper.insertSelective(userAccount);
		return userAccountMapper.insertUserAccount(userAccount);
	}

}
