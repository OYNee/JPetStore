package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import com.example.jpetstore.domain.QAndA;

public interface QAndAMapper {
	
	List<QAndA> getQuestionByUsername(String username);
	
	List<QAndA> getAnswerByUsername(String username);
	
}
