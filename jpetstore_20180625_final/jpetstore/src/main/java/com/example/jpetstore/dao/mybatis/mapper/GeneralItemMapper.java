package com.example.jpetstore.dao.mybatis.mapper;
//�ö�
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.jpetstore.domain.GeneralItem;
import com.example.jpetstore.domain.Inventory;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Product;

public interface GeneralItemMapper {
	
	public void insertGeneralItem(GeneralItem generalItem);
	public void insertQuantity(Inventory inventory);
	GeneralItem getGeneralItem(String sitemId);

//	int getItemID();

	//0623
//		public void insertQuantity(GeneralItem generalItem);
		
		public void updateGeneralItem(GeneralItem generalItem);
		public void updateQuantity(GeneralItem generalItem);
}
