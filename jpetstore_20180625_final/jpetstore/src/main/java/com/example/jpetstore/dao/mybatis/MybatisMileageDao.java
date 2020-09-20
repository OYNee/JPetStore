package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.MileageDao;
import com.example.jpetstore.dao.mybatis.mapper.MileageMapper;
import com.example.jpetstore.domain.Mileage;

@Repository
public class MybatisMileageDao implements MileageDao {
	
	@Autowired
	private MileageMapper mileageMapper;
	
	public List<Mileage> getMileageListByUsername(String username) throws DataAccessException {
		return mileageMapper.getMileageListByUsername(username);
	}

	@Override
	public void insertMileageHistory(Mileage mileage) throws DataAccessException {
		mileageMapper.insertMileageHistory(mileage);
		
	}
}
