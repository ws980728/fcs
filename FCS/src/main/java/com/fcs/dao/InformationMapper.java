package com.fcs.dao;

import java.util.List;

import com.fcs.bean.Information;
import com.fcs.bean.InformationLike;
import com.fcs.bean.InformationList;
import com.fcs.bean.Type;

public interface InformationMapper {

	// 查询资讯列表
	List<InformationList> selectByTime();

	// 查询资讯详情
	Information selectById(String informationId);
	
	// 获得轮播图
	List<InformationLike> selectByLikeNum();
	
	// 设计师分类
	List<Type> selectByType();

}
