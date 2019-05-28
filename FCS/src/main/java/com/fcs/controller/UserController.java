package com.fcs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fcs.bean.UserAccount;
import com.fcs.service.UserService;
import com.fcs.utils.Msg;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 用户注册
	@ResponseBody
	@RequestMapping("/register")
	public Msg register(@Valid UserAccount userAccount, BindingResult result) {
		if (result.hasErrors()) {// 后端校验失败
			return Msg.fail().add("error", "后端校验失败");
		} else {
			userService.insertUserAccount(userAccount);
			return Msg.success();
		}
	}

}
