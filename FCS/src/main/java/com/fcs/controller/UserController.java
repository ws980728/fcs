package com.fcs.controller;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fcs.bean.UserAccount;
import com.fcs.dao.JedisClient;
import com.fcs.service.UserService;
import com.fcs.utils.MD5Util;
import com.fcs.utils.Msg;
import com.fcs.utils.TokenInfo;
import com.google.code.kaptcha.Producer;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private Producer kaptchaProducer;

	@Autowired
	private JedisClient jedisClient;

	// 获取注册验证码,在请求头返回token
	@RequestMapping("/kaptcha")
	public void getkaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");

		String capText = kaptchaProducer.createText();// 生成验证码
		String token = UUID.randomUUID().toString();// 生成token
		response.setHeader("Token", token);
		jedisClient.set(token, capText);// 将token存入redis
		jedisClient.expire(token, 1800);// 设置两分钟过期时间
		TokenInfo tokenInfo = new TokenInfo(token, false);
		BufferedImage bi = kaptchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}

	// 用户注册
	@PostMapping
	@ResponseBody
	@RequestMapping("/register")
	public Msg register(UserAccount userAccount,@RequestParam("kaptcha") String kaptcha,HttpServletRequest request) {
		//System.out.println("接收到的验证码："+kaptcha);
		//验证码校验
		String token = request.getHeader("Token");
		if(jedisClient.get(token) ==null || jedisClient.get(token)!=kaptcha) {
			//System.out.println("正确的的验证码："+jedisClient.get(token));
			return Msg.fail().add("info", "验证码错误");
		}
		
		// 密码进行MD5加密
		userAccount.setUserPassword(MD5Util.MD5(userAccount.getUserPassword()));
		// 创建注册日期
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String userRegtime = sdf.format(date);
		userAccount.setUserRegtime(userRegtime);
		userAccount.setUserStatus(0);
		// 新增数据
		userService.insertUserAccount(userAccount);
		String UUID = userAccount.getUserId();
		return Msg.success().add("UUID", UUID);
	}

	@ResponseBody
	@RequestMapping("/login")
	public Msg login(String username, String password) {
		userService.userLogin(username, password);
		return Msg.success();
	}

}
