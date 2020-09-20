package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.QAndA;

public interface QAndADao {
	
	List<QAndA> getQuestionByUsername(String username) throws DataAccessException;
	
	List<QAndA> getAnswerByUsername(String username) throws DataAccessException;
	
}
