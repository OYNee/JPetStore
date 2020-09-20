package com.example.jpetstore.dao;

import java.util.List;

import com.example.jpetstore.domain.Question;

public interface QuestionDao {
	
	List<Question> getListQuestion(String itemId);
	Question getQuestion(String questionId);
	public void insertQuestion(Question question);
}
