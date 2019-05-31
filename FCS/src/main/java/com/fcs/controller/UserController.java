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

	// ��ȡע����֤��,������ͷ����token
	@RequestMapping("/kaptcha")
	public void getkaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");

		String capText = kaptchaProducer.createText();// ������֤��
		String token = UUID.randomUUID().toString();// ����token
		response.setHeader("Token", token);
		jedisClient.set(token, capText);// ��token����redis
		jedisClient.expire(token, 1800);// ���������ӹ���ʱ��
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

	// �û�ע��
	@PostMapping
	@ResponseBody
	@RequestMapping("/register")
	public Msg register(UserAccount userAccount,@RequestParam("kaptcha") String kaptcha,HttpServletRequest request) {
		//System.out.println("���յ�����֤�룺"+kaptcha);
		//��֤��У��
		String token = request.getHeader("Token");
		if(jedisClient.get(token) ==null || jedisClient.get(token)!=kaptcha) {
			//System.out.println("��ȷ�ĵ���֤�룺"+jedisClient.get(token));
			return Msg.fail().add("info", "��֤�����");
		}
		
		// �������MD5����
		userAccount.setUserPassword(MD5Util.MD5(userAccount.getUserPassword()));
		// ����ע������
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String userRegtime = sdf.format(date);
		userAccount.setUserRegtime(userRegtime);
		userAccount.setUserStatus(0);
		// ��������
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
