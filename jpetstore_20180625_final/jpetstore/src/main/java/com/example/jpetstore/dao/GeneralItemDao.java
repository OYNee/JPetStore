package com.example.jpetstore.dao;
//�ö�
import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.GeneralItem;
import com.example.jpetstore.domain.Inventory;

public interface GeneralItemDao {
	
	public void insertGeneralItem(GeneralItem generalItem);
	
	GeneralItem getGeneralItem(String sitemId);
	
	//ITEM TABLE ���� ���� 
//	int getItemID();
	//180623 �닔�젙--------------------------
//		public void insertQuantity(GeneralItem generalItem);
		public void insertQuantity(Inventory inventory);
		
		//�뾽�뜲�씠�듃
		public void updateGeneralItem(GeneralItem generalItem);
		public void updateQuantity(GeneralItem generalItem);
}
