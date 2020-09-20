package com.example.jpetstore.dao.mybatis.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.jpetstore.domain.BlackList;

public interface BlackListMapper {

	BlackList getDetail(String username);
	void removeDetail(String userId);
	
	int getPageComplainCountByUser(@Param("page") String page, @Param("userId") String userId);
	
	//블라인드
	int pageComplainCount(String page);
	
	List<BlackList> getReasonByPage(String page);
	
	//�ö� �κ�
	BlackList getBlack(String blackId);

	void insertBlackList(BlackList black);
}
