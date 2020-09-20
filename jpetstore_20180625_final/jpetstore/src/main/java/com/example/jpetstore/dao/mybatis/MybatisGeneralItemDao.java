package com.example.jpetstore.dao.mybatis;
//시라
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.GeneralItemDao;
import com.example.jpetstore.dao.mybatis.mapper.GeneralItemMapper;
import com.example.jpetstore.dao.mybatis.mapper.ItemMapper;
import com.example.jpetstore.domain.GeneralItem;
import com.example.jpetstore.domain.Inventory;
import com.example.jpetstore.domain.Product;

//service를 repository로 등록하여 bean class로 사용가능하게 함
@Repository
public class MybatisGeneralItemDao implements GeneralItemDao {
	

	@Autowired
	private GeneralItemMapper generalItemMapper;

	@Override
	public void insertGeneralItem(GeneralItem generalItem) throws DataAccessException {
		// TODO Auto-generated method stub
		//return generalItemMapper.insertGeneralItem(item);
		
		generalItemMapper.insertGeneralItem(generalItem);
				
	}
//
//	@Override
//	public int getItemID() {
//		// TODO Auto-generated method stub
//		return generalItemMapper.getItemID();
//	}

	//180623 수정
		//등록
		@Override
		public GeneralItem getGeneralItem(String itemId) throws DataAccessException {
			// TODO Auto-generated method stub
			return generalItemMapper.getGeneralItem(itemId);
		}
		
//		public void insertQuantity(GeneralItem generalItem) throws DataAccessException{
//			generalItemMapper.insertQuantity(generalItem);
//		}
		
		//업데이트
		public void updateGeneralItem(GeneralItem generalItem) throws DataAccessException{
			generalItemMapper.updateGeneralItem(generalItem);
		}
		public void updateQuantity(GeneralItem generalItem)throws DataAccessException{
			generalItemMapper.updateQuantity(generalItem);
		}

		@Override
		public void insertQuantity(Inventory inventory) {
			generalItemMapper.insertQuantity(inventory);
			
		}
		

}
