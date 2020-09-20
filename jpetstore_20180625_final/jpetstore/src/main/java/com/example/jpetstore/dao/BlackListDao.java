package com.example.jpetstore.dao;


import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.BlackList;

public interface BlackListDao {
	
	BlackList getDetail(String username) throws DataAccessException;
	
	
	int getPageComplainCountByUser(String page, String userId) throws DataAccessException;
	
	int pageComplainCount(String page) throws DataAccessException;
	
	List<BlackList> getReasonByPage(String page) throws DataAccessException;
	
	//�떆�씪�뵪 遺�遺�
	BlackList getBlack(String blackId) throws DataAccessException;

	void insertBlackList(BlackList black) throws DataAccessException;
	

}
