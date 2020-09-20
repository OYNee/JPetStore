package com.example.jpetstore.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.AccountDao;
import com.example.jpetstore.dao.mybatis.mapper.AccountMapper;
import com.example.jpetstore.dao.mybatis.mapper.BlackListMapper;
import com.example.jpetstore.domain.Account;

/**
 * @author Juergen Hoeller
 * @author Colin Sampaleanu
 */
@Repository
public class MybatisAccountDao implements AccountDao {

	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private BlackListMapper blackListMapper;
	
	public Account getAccount(String username) throws DataAccessException {
		return accountMapper.getAccountByUsername(username);
	}

	public Account getAccount(String username, String password) 
			throws DataAccessException {
		return accountMapper.getAccountByUsernameAndPassword(username, password);
	}

	public void insertAccount(Account account) throws DataAccessException {
		accountMapper.insertAccount(account);
		accountMapper.insertProfile(account);
		accountMapper.insertSignon(account);
	}

	public void updateAccount(Account account) throws DataAccessException {
		accountMapper.updateAccount(account);
		accountMapper.updateProfile(account);
		if (account.getPassword() != null && account.getPassword().length() > 0) 
		{
			accountMapper.updateSignon(account);
		}
	}
 
	public List<String> getUsernameList() throws DataAccessException {
		return accountMapper.getUsernameList();
	}

	//�߰�
	@Override
	public void updateBlackList(String username, int status) throws DataAccessException {
		accountMapper.updateBlackList(username, status);
		blackListMapper.removeDetail(username);
		
	}

	@Override
	public List<String> getUserOnBlackList() throws DataAccessException {
		return accountMapper.getUserOnBlackList();
	}

	@Override
	public void updateMileage(String userid, int amount) throws DataAccessException {
		accountMapper.updateMileage(userid, amount);
	}
}