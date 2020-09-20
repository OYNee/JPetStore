package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.AuctionDao;
import com.example.jpetstore.dao.mybatis.mapper.AuctionMapper;
import com.example.jpetstore.domain.Bid;

@Repository
public class MybatisAuctionDao implements AuctionDao {
	
	@Autowired
	private AuctionMapper auctionMapper;
	
	public List<Bid> getAuctionItemsByUsername(String username) {
		return auctionMapper.getAuctionItemsByUsername(username);
	}
	public int getHighestBidPrice(String auctionId) {
		return auctionMapper.getHighestBidPrice(auctionId);
	}
	@Override
	public Integer getBidPriceByUsername(String bidder, String auctionId) {
		// TODO Auto-generated method stub
		return auctionMapper.getBidPriceByUsername(bidder, auctionId);
	}
	
	//0624
		public List<Bid> bidValuesForChart(String auctionId){
			return auctionMapper.bidValuesForChart(auctionId);
		}
		
		public List<Bid> getBidByAuctionIdASC (String auctionId){
			return auctionMapper.getBidByAuctionIdASC(auctionId);
		}
}
