package com.example.jpetstore.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpetstore.dao.LetterDao;
import com.example.jpetstore.dao.mybatis.mapper.LetterMapper;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Letter;

@Repository
@Transactional
public class MybatisLetterDao implements LetterDao {
	private static final Logger logger = LoggerFactory.getLogger(MybatisLetterDao.class);

	@Autowired
	private LetterMapper letterMapper;

	@Override
	public List<Letter> selectLetterByPage(String loginID, int pageNo, int rowsPerPage) {
		List<Letter> letterList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("endNum", pageNo * rowsPerPage);
		map.put("startNum", (pageNo - 1) * rowsPerPage);
		map.put("loginID", loginID);
		System.out.println(map.toString());
		letterList = letterMapper.selectLetterByPage(map);
		return letterList;
	}

	@Override
	public int countAllLetter(String loginID) {
		return letterMapper.countAllLetter(loginID);
	}


	@Override
	public int insertLetter(Letter letter) {
		return  letterMapper.insertLetter(letter);	
	}

	@Override
	public List<Letter> selectBySearchWord(Map<String, String> parameters) {
		return letterMapper.selectBySearchWord(parameters);
	}

	@Override
	public List<Account> findListById(String loginID) {
		return letterMapper.findListById(loginID);
	}
	


}
