package com.fcs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fcs.bean.UserAccount;
import com.fcs.service.UserService;
import com.fcs.utils.MD5Util;
import com.fcs.utils.Msg;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// �û�ע��
	@PostMapping
	@ResponseBody
	@RequestMapping("/register")
	public Msg register(UserAccount userAccount) {
		//�������MD5����
		userAccount.setUserPassword(MD5Util.MD5(userAccount.getUserPassword()));
		//����ע������
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String userRegtime= sdf.format(date);
		userAccount.setUserRegtime(userRegtime);
		userAccount.setUserStatus(0);
		//��������
		userService.insertUserAccount(userAccount);
		String UUID=userAccount.getUserId();
		return Msg.success().add("UUID", UUID);
	}

}
