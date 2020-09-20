package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.AdDao;
import com.example.jpetstore.dao.mybatis.mapper.AdMapper;
import com.example.jpetstore.domain.Advertisement;

@Repository
public class MybatisAdDao implements AdDao{
	@Autowired
	private AdMapper admapper;
	
	@Override
	public void insertAd(Advertisement Ad) throws DataAccessException {
		admapper.insertAd(Ad);
	}

	@Override
	public List<Advertisement> advertise(String today) throws DataAccessException {
		return admapper.advertise(today);
	}

	@Override
	public List<Advertisement> favAdvertise(String favcategory, String today)
			throws DataAccessException {
		
		return admapper.favAdvertise(favcategory, today);
	}

	@Override
	public List<Advertisement> getApprovalList() throws DataAccessException {
		
		return admapper.getApprovalList();
	}

	@Override
	public void deleteAdByItemId(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		admapper.deleteAdByItemId(itemId);
	}

}
