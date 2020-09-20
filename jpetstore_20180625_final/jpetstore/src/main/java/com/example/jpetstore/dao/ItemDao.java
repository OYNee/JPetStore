package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.MySales;
import com.example.jpetstore.domain.Order;

public interface ItemDao {

  public void updateQuantity(Order order) throws DataAccessException, Exception;

  int isItemInStock(String itemId) throws DataAccessException;

  List<Item> getItemListByProduct(String productId) throws DataAccessException;

  Item getItem(String itemId) throws DataAccessException;
  
  //180523 占쌩곤옙
  List<MySales> getItemListByUserid(String userid) throws DataAccessException;
  
  void updateAdStatus(String itmeId, String adStatus) throws DataAccessException;

  List<Item> searchItemList(String keywords, String array, int priceMax, int priceMin, String option) throws DataAccessException;

  //�븘�씠�뀥 寃쎈ℓ �뿬遺� �솗�씤
  int isAuctionByItem(String itemId) throws DataAccessException;
 
  void updateItemStatus(String itemId, String status) throws DataAccessException;
  
  void updateItemPrice(int price) throws DataAccessException;
  
//0624
  void deleteItemFromTable(String itemId);
  void deleteInventoryFromTable(String itemId);
  void deleteQuestionFromTable(String itemId);
  void deleteAuctionFromTable(String auctionId);
  void deleteBidFromTable(String auctionId);
  
}
