package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bid implements Serializable {
	private String itemId;	//옥션 내역 받아올때 쓰려고 추가
	private String bid_id;
	private String auction_id;
	private String bid_date;
	private String bidder;		//추가
	private int highestBidPrice;	//추가
	private int bid_price; //추가

	public Bid() {
		super();
	}
	
	public Bid(String auction_id, String bidder, String bid_date, int bid_price) {
		super();
		this.auction_id = auction_id;
		this.bidder = bidder;
		this.bid_date = bid_date;
		this.bid_price = bid_price;
	}
	
	public String getBid_id() {
		return bid_id;
	}
	public void setBid_id(String bid_id) {
		this.bid_id = bid_id;
	}
	public String getAuction_id() {
		return auction_id;
	}
	public void setAuction_id(String auction_id) {
		this.auction_id = auction_id;
	}
	public String getBid_date() {
		return bid_date;
	}
	public void setBid_date(String bid_date) {
		this.bid_date = bid_date;
	}
//	public Bid(String bid_id, String auction_id, String bidder_id, String bid_date) {
//		super();
//		this.bid_id = bid_id;
//		this.auction_id = auction_id;
//		this.bidder_id = bidder_id;
//		this.bid_date = bid_date;
//	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getHighestBidPrice() {
		return highestBidPrice;
	}
	public void setHighestBidPrice(int highestBidPrice) {
		this.highestBidPrice = highestBidPrice;
	}
	public String getBidder() {
		return bidder;
	}
	public void setBidder(String bidder) {
		this.bidder = bidder;
	}
	public int getBid_price() {
		return bid_price;
	}
	public void setBid_price(int bid_price) {
		this.bid_price = bid_price;
	}

	
	
}
