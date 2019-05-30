package com.fcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcs.bean.Information;
import com.fcs.bean.InformationLike;
import com.fcs.bean.InformationList;
import com.fcs.bean.Type;
import com.fcs.dao.InformationMapper;

@Service
public class InformationService {

	@Autowired
	InformationMapper informationMapper;

	// 查询资讯信息，并以时间进行排序
	public List<InformationList> queryInformationByTime() {
		return informationMapper.selectByTime();
	}

	// 查询资讯详情
	public Information selectById(String informationId) {
		return informationMapper.selectById(informationId);
	}

	// 获得轮播图
	public List<InformationLike> selectByLikeNum() {
		return informationMapper.selectByLikeNum();
	}

	// 设计师分类
	public List<Type> selectByType() {
		return informationMapper.selectByType();
	}

}
