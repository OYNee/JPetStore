package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.AuctionItemDao;
import com.example.jpetstore.dao.mybatis.mapper.AuctionItemMapper;
import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.Bid;
import com.example.jpetstore.domain.Inventory;


@Repository
public class MybatisAuctionItemDao implements AuctionItemDao{
	
	@Autowired
	private AuctionItemMapper auctionItemMapper;

	@Override
	public void insertAuctionItem(AuctionItem auctionItem) throws DataAccessException {
		// TODO Auto-generated method stub
		//return generalItemMapper.insertGeneralItem(item);
		
		auctionItemMapper.insertAuctionItem(auctionItem);	
	}
	
	public void insertQuantity(Inventory inventory) throws DataAccessException{
		auctionItemMapper.insertQuantity(inventory);
	}

	@Override
	public void insertAuction(AuctionItem auctionItem) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.insertAuction(auctionItem);	
	}
	
	@Override
	public AuctionItem getAuctionItem(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getAuctionItem(itemId);	
	}

	@Override
	public List<Bid> getBidByAuctionId(String auctionId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getBidByAuctionId(auctionId);
	}

	@Override
	public void updateBid(String bidder, int price) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.updateBid(bidder, price);
	}

	@Override
	public void insertBid(Bid bid) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.insertBid(bid);
	}

	@Override
	public void deleteBid(String bidder, String auctionId) throws DataAccessException {
		auctionItemMapper.deleteBid(bidder, auctionId);
		
	}

	@Override
	public void endAuctionBySeller(String auctionId) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.endAuctionBySeller(auctionId);
	}

	@Override
	public Bid getHighestBidder(String auctionId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getHighestBidder(auctionId);
	}
	
	//180623-------------------
	
//		public void insertQuantity(AuctionItem auctionItem) throws DataAccessException{
//			auctionItemMapper.insertQuantity(auctionItem);
//		}
		
		public void updateAuctionItem(AuctionItem autionItem) {
			auctionItemMapper.updateAuctionItem(autionItem);
		}
		public void updateQuantity(AuctionItem autionItem) {
			auctionItemMapper.updateQuantity(autionItem);
		}
		public void updateAuctionInfo(AuctionItem autionItem) {
			auctionItemMapper.updateAuctionInfo(autionItem);
		}

}
