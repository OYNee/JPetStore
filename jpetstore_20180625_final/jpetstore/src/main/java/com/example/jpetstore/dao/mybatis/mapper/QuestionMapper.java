package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import com.example.jpetstore.domain.Question;

public interface QuestionMapper {
	
	List<Question> getListQuestion(String itemId);

	Question getQuestion(String itemId);
	
	//Question getQuestion(String questionId);
	public void insertQuestion(Question question);

}
