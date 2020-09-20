package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import com.example.jpetstore.domain.Answer;

public interface AnswerMapper {
	
	List<Answer> getAnswer(String questionId);

	void insertAnswer(Answer answer);
}
