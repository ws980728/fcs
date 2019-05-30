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

	// ��ѯ��Ѷ��Ϣ������ʱ���������
	public List<InformationList> queryInformationByTime() {
		return informationMapper.selectByTime();
	}

	// ��ѯ��Ѷ����
	public Information selectById(String informationId) {
		return informationMapper.selectById(informationId);
	}

	// ����ֲ�ͼ
	public List<InformationLike> selectByLikeNum() {
		return informationMapper.selectByLikeNum();
	}

	// ���ʦ����
	public List<Type> selectByType() {
		return informationMapper.selectByType();
	}

}
