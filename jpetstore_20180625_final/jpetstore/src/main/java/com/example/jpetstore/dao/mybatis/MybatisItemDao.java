package com.example.jpetstore.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpetstore.dao.ItemDao;
import com.example.jpetstore.dao.mybatis.mapper.ItemMapper;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.LineItem;
import com.example.jpetstore.domain.MySales;
import com.example.jpetstore.domain.Order;

@Repository
@Transactional
public class MybatisItemDao implements ItemDao {
	@Autowired
	private ItemMapper itemMapper;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=(Exception.class))
	public void updateQuantity(Order order) throws DataAccessException, Exception {
		for (int i = 0; i < order.getLineItems().size(); i++) {
			LineItem lineItem = (LineItem) order.getLineItems().get(i);
			String itemId = lineItem.getItemId();
			Integer increment = new Integer(lineItem.getQuantity());
			Map<String, Object> param = new HashMap<String, Object>(2);
			param.put("itemId", itemId);
			param.put("increment", increment);
			
			try {
				itemMapper.updateInventoryQuantity(param);
				if(itemMapper.getInventoryQuantity(itemId)<0) {
					
					System.out.println(itemMapper.getInventoryQuantity(itemId));
					throw new Exception();
				}
			}
			finally {
				System.out.println("finally");
			}
			
		}
	}

	public int isItemInStock(String itemId) throws DataAccessException {
		return itemMapper.getInventoryQuantity(itemId);
	}

	public List<Item> getItemListByProduct(String productId) 
			throws DataAccessException {
		return itemMapper.getItemListByProduct(productId);
	}

	public Item getItem(String itemId) throws DataAccessException {
		return itemMapper.getItem(itemId);
	}
	
	//180523 占쌩곤옙
	public List<MySales> getItemListByUserid(String userid) throws DataAccessException {
		return itemMapper.getItemListByUserid(userid);
	}
	
	public void updateAdStatus(String itmeId, String adStatus) throws DataAccessException {
		itemMapper.updateAdStatus(itmeId, adStatus);
	}
	

	public List<Item> searchItemList(String keywords, String array, int priceMax, int priceMin, String option) 
			throws DataAccessException {
	    return itemMapper.searchItemList(
	    	"%" + keywords.toLowerCase() + "%", array, priceMax, priceMin, option);
	}
	
	public void updateItemPrice(int price) {
		itemMapper.updateItemPrice(price);
	}
	
	//�븘�씠�뀥 寃쎈ℓ �뿬遺� �솗�씤
	  public int isAuctionByItem(String itemId) throws DataAccessException{
		  return itemMapper.isAuctionByItem(itemId);
	  }

	@Override
	public void updateItemStatus(String itemId, String status) throws DataAccessException{
		// TODO Auto-generated method stub
		itemMapper.updateItemStatus(itemId, status);
	}
	
	//0624
		public void deleteItemFromTable(String itemId) throws DataAccessException {
			 itemMapper.deleteItemFromTable(itemId);
		 }
		public void deleteInventoryFromTable(String itemId) throws DataAccessException{
			  itemMapper.deleteInventoryFromTable(itemId);
		  }
		public void deleteQuestionFromTable(String itemId) throws DataAccessException{
			  itemMapper.deleteQuestionFromTable(itemId);
		  }
		public void deleteAuctionFromTable(String auctionId) throws DataAccessException{
			  itemMapper.deleteAuctionFromTable(auctionId);
		  }
		public void deleteBidFromTable(String auctionId) throws DataAccessException{
			  itemMapper.deleteBidFromTable(auctionId);
		  }

}
