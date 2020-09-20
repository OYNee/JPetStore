package com.example.jpetstore.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.jpetstore.domain.Account;

public interface AccountDao {

  Account getAccount(String username) throws DataAccessException;

  Account getAccount(String username, String password) throws DataAccessException;

  void insertAccount(Account account) throws DataAccessException;

  void updateAccount(Account account) throws DataAccessException;

  List<String> getUsernameList() throws DataAccessException;
  
  //�߰�
  void updateBlackList(String username, int status) throws DataAccessException;
  
  List<String> getUserOnBlackList() throws DataAccessException;

  void updateMileage(String userid, int amount) throws DataAccessException;
}
