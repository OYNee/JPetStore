package com.example.jpetstore.dao;

import java.util.List;

import com.example.jpetstore.domain.Answer;

public interface AnswerDao {
	
	 List<Answer> getAnswer(String questionId);
	void insertAnswer(Answer answer);
}
