package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.jpetstore.domain.Bid;


public interface AuctionMapper {
	List<Bid> getAuctionItemsByUsername(String bidder);
	int getHighestBidPrice(String auctionId);
	Integer getBidPriceByUsername(@Param("bidder") String bidder, @Param("auctionId") String auctionId);
	//0624
		List<Bid> bidValuesForChart(String auctionId);
		List<Bid> getBidByAuctionIdASC (String auctionId);
}
