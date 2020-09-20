package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Letter;
import com.example.jpetstore.domain.MySales;

public interface LetterMapper {
	public List<Letter> selectLetterByPage(Map<String, Object> parameters);
	public int countAllLetter(String loginID);
	public List<Letter> selectBySearchWord(Map<String, String> parameters);
	public int insertLetter(Letter letter);
	public List<Account> findListById(String loginID);

}
