package com.fcs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import com.fcs.utils.GenConfirmCodeUtil;
import com.fcs.utils.MD5Util;
import com.fcs.utils.Msg;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/changeCode")
    public void getVerify(HttpServletRequest request, HttpServletResponse response,HttpSession session){
        response.setContentType("image/jpeg");//������Ӧ����,������������������ΪͼƬ
        response.setHeader("Pragma", "No-cache");//������Ӧͷ��Ϣ�������������Ҫ���������
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        GenConfirmCodeUtil codeUtil=new GenConfirmCodeUtil();
        try {
            codeUtil.getRandcode(request, response);//�����֤��ͼƬ����
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(session.toString());
    }

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
