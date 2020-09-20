package com.example.jpetstore.dao;

import java.util.List;

import com.example.jpetstore.domain.Bid;

public interface AuctionDao {
	List<Bid> getAuctionItemsByUsername(String username);
	int getHighestBidPrice(String auctionId);
	Integer getBidPriceByUsername(String bidder, String auctionId);
	
	//0624
	List<Bid> bidValuesForChart(String auctionId);
	List<Bid> getBidByAuctionIdASC (String auctionId);
}
