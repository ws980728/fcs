package com.fcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fcs.bean.Information;
import com.fcs.bean.InformationLike;
import com.fcs.bean.InformationList;
import com.fcs.bean.Type;
import com.fcs.service.InformationService;
import com.fcs.utils.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@Controller
@RequestMapping("/information")
public class InformationController {

	@Autowired
	InformationService informationService;

	// ��ѯ��Ѷ�б�,����ʱ���������
	@PostMapping
	@ResponseBody
	@RequestMapping("/queryInformationByTime")
	public Msg queryInformationByTime(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 2);
		List<InformationList> informations = informationService.queryInformationByTime();
		for (int i = 0; i < informations.size(); i++) {
			String strContent = informations.get(i).getInformationContent();
			strContent = strContent.substring(0, 12);
			informations.get(i).setInformationContent(strContent + "....");
		}
		PageInfo<InformationList> pageInfo = new PageInfo<>(informations);
		List<InformationList> returnList = pageInfo.getList();
		return Msg.success().add("list", returnList);
	}

	// �鿴��Ѷ�б�����
	@GetMapping
	@ResponseBody
	@RequestMapping("/informationDetail")
	public Msg informationDetail(@RequestParam(value = "informationId") String informationId) {
		Information informationDetail = informationService.selectById(informationId);
		return Msg.success().add("informationDetail", informationDetail);
	}

	// ����ֲ�ͼ
	// һ���ڵ�������ߵ�������Ѷ��Ϣ
	@PostMapping
	@ResponseBody
	@RequestMapping("/shufflingImg")
	public Msg shufflingImg() {
		List<InformationLike> informationLikes = informationService.selectByLikeNum();
		return Msg.success().add("informationLikes", informationLikes);
	}

	// ���ʦ����
	@PostMapping
	@ResponseBody
	@RequestMapping("/queryType")
	public Msg queryType() {
		List<Type> types = informationService.selectByType();
		return Msg.success().add("types", types);
	}

}
