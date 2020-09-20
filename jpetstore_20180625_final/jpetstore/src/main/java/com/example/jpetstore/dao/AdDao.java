package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Advertisement;

public interface AdDao {
	
	public void insertAd(Advertisement Ad) throws DataAccessException;

	public List<Advertisement> advertise(String today) throws DataAccessException;

	List<Advertisement> favAdvertise(String favcategory, String today) throws DataAccessException;

	List<Advertisement> getApprovalList() throws DataAccessException;
	
	void deleteAdByItemId(String itemId) throws DataAccessException;
}
