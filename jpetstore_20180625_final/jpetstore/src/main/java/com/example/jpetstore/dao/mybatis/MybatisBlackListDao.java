package com.example.jpetstore.dao.mybatis;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpetstore.dao.BlackListDao;
import com.example.jpetstore.dao.mybatis.mapper.AccountMapper;
import com.example.jpetstore.dao.mybatis.mapper.BlackListMapper;
import com.example.jpetstore.domain.BlackList;

@Repository
public class MybatisBlackListDao implements BlackListDao {
	
	@Autowired
	private BlackListMapper blackListMapper;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public BlackList getDetail(String username) throws DataAccessException {
		return blackListMapper.getDetail(username);
	}


	
	@Override
	public List<BlackList> getReasonByPage(String page) throws DataAccessException {
		
		return blackListMapper.getReasonByPage(page);
	}
	

	@Override
	public BlackList getBlack(String blackId) throws DataAccessException {
		// TODO Auto-generated method stub
		return blackListMapper.getBlack(blackId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=(Exception.class))
	public void insertBlackList(BlackList black) {
		// TODO Auto-generated method stub
		blackListMapper.insertBlackList(black);
		BlackList blackList = blackListMapper.getDetail(black.getBlackId());
		System.out.println();
		if(blackList != null) {
			accountMapper.updateBlackList(black.getBlackId(), 1);
			System.out.println("Aa");
		}
	}



	@Override
	public int getPageComplainCountByUser(String page, String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return blackListMapper.getPageComplainCountByUser(page, userId);
	}



	@Override
	public int pageComplainCount(String page) throws DataAccessException {
		// TODO Auto-generated method stub
		return blackListMapper.pageComplainCount(page);
	}




}
