package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Mileage;

public interface MileageDao {
	
	List<Mileage> getMileageListByUsername(String username) throws DataAccessException;
	
	void insertMileageHistory(Mileage mileage) throws DataAccessException;
}
