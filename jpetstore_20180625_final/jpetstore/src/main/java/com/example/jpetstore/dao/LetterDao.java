package com.example.jpetstore.dao;

import java.util.List;
import java.util.Map;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Letter;

public interface LetterDao {
	public List<Letter> selectLetterByPage(String loginID, int pageNo, int rowsPerPage);
	public int countAllLetter(String loginID);
	public List<Letter> selectBySearchWord(Map<String, String> parameters);
	public int insertLetter(Letter letter);
	public List<Account> findListById(String loginID);
  
}
