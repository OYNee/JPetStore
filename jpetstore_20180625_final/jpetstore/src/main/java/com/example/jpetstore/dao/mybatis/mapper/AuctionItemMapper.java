package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.Bid;
import com.example.jpetstore.domain.Inventory;

public interface AuctionItemMapper {
	public void insertAuctionItem(AuctionItem autionItem);
	public void insertQuantity(Inventory inventory);
//	public void insertQuantity(AuctionItem auctionItem); //180623
	public void insertAuction(AuctionItem auctionItem);
	AuctionItem getAuctionItem(String itemId);
	List<Bid> getBidByAuctionId(String auctionId);
	void updateBid(@Param("bidder") String bidder, @Param("price") int price);
	void insertBid(Bid bid);
	void deleteBid(@Param("bidder") String bidder, @Param("auctionId") String auctionId);
	void endAuctionBySeller(String auctionId);
	Bid getHighestBidder(String auctionId);
	
	//------------180623
		public void updateAuctionItem(AuctionItem autionItem);
		public void updateQuantity(AuctionItem autionItem);
		public void updateAuctionInfo(AuctionItem autionItem);
	
}
