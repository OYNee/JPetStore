package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.AnswerDao;
import com.example.jpetstore.dao.mybatis.mapper.AnswerMapper;
import com.example.jpetstore.domain.Answer;

@Repository
public class MybatisAnswerDao implements AnswerDao {
	
	@Autowired
	private AnswerMapper answerMapper;

	@Override
	public List<Answer> getAnswer(String questionId) {
		// TODO Auto-generated method stub
		return answerMapper.getAnswer(questionId);
	}
	
	public void insertAnswer(Answer answer) {
		answerMapper.insertAnswer(answer);
	}

}
