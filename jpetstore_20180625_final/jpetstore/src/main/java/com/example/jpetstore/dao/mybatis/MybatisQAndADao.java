package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.QAndADao;
import com.example.jpetstore.dao.mybatis.mapper.QAndAMapper;
import com.example.jpetstore.domain.QAndA;

@Repository
public class MybatisQAndADao implements QAndADao {
	@Autowired
	private QAndAMapper QAndAMapper;
	
	public List<QAndA> getQuestionByUsername(String username) throws DataAccessException{
		return QAndAMapper.getQuestionByUsername(username);
	}
	
	public List<QAndA> getAnswerByUsername(String username) throws DataAccessException{
		return QAndAMapper.getAnswerByUsername(username);
	}
}
