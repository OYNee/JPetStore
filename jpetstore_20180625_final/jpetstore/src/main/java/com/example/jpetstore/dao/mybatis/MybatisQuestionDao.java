package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.QuestionDao;
import com.example.jpetstore.dao.mybatis.mapper.QuestionMapper;
import com.example.jpetstore.domain.Question;

@Repository
public class MybatisQuestionDao implements QuestionDao{

	@Autowired
	private QuestionMapper questionMapper;
	
	@Override
	public List<Question> getListQuestion(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return questionMapper.getListQuestion(itemId);
	}

	@Override
	public Question getQuestion(String questionId) {
		// TODO Auto-generated method stub
		return questionMapper.getQuestion(questionId);
	}
	
	public void insertQuestion(Question question){
		questionMapper.insertQuestion(question);
	}

}
