package com.example.jpetstore.dao;

import java.util.List;

import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.Bid;
import com.example.jpetstore.domain.Inventory;

public interface AuctionItemDao {
	
	public void insertAuctionItem(AuctionItem autionItem);
	public void insertAuction(AuctionItem auctionItem);
	//180621 �߰�
	public void insertQuantity(Inventory inventory);
	AuctionItem getAuctionItem(String itemId);
	List<Bid> getBidByAuctionId(String auctionId);
	void updateBid(String bidder, int price);
	void insertBid(Bid bid);
	void deleteBid(String bidder, String auctionId);
	void endAuctionBySeller(String auctionId);
	Bid getHighestBidder(String auctionId);

	//180623
//		public void insertQuantity(AuctionItem auctionItem);
		
		public void updateAuctionItem(AuctionItem autionItem);
		public void updateQuantity(AuctionItem autionItem);
		public void updateAuctionInfo(AuctionItem autionItem);
}
