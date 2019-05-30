package com.fcs.dao;

import java.util.List;

import com.fcs.bean.Information;
import com.fcs.bean.InformationLike;
import com.fcs.bean.InformationList;
import com.fcs.bean.Type;

public interface InformationMapper {

	// ��ѯ��Ѷ�б�
	List<InformationList> selectByTime();

	// ��ѯ��Ѷ����
	Information selectById(String informationId);
	
	// ����ֲ�ͼ
	List<InformationLike> selectByLikeNum();
	
	// ���ʦ����
	List<Type> selectByType();

}
