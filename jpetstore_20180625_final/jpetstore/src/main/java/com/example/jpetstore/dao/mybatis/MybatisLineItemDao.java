package com.example.jpetstore.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpetstore.dao.LineItemDao;
import com.example.jpetstore.dao.mybatis.mapper.LineItemMapper;

@Repository
@Transactional
public class MybatisLineItemDao implements LineItemDao {
	
	@Autowired
	private LineItemMapper lineItemMapper;
	
	@Override
	public int getLineItemByItemId(String itemId) {
		
		return lineItemMapper.getLineItemByItemId(itemId);
	}

}
