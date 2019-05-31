package com.fcs.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcs.bean.UserAccount;
import com.fcs.dao.JedisClient;
import com.fcs.dao.UserAccountMapper;
import com.fcs.utils.Msg;

@Service
public class UserService {

	@Autowired
	private UserAccountMapper userAccountMapper;
	
	@Autowired
	private JedisClient jedisClient;

	// 新增用户
	public int insertUserAccount(UserAccount userAccount) {
		//userAccountMapper.insertSelective(userAccount);
		return userAccountMapper.insertUserAccount(userAccount);
	}
	
	public void userLogin(String username,String password) {
		
		//生成token
		String token=UUID.randomUUID().toString();
		
		jedisClient.set(token,username);
		jedisClient.expire(token, 20);
		
	}

}
