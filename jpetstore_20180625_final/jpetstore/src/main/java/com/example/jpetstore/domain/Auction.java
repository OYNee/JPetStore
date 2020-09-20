package com.example.jpetstore.domain;

public class Auction {
	private String auction_id;
	private String item_id;
	private String supplier_id;
	private String start_price;
	private String start_date;
	private String last_date;
	private String order_id;
	public String getAuction_id() {
		return auction_id;
	}
	public void setAuction_id(String auction_id) {
		this.auction_id = auction_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getStart_price() {
		return start_price;
	}
	public void setStart_price(String start_price) {
		this.start_price = start_price;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getLast_date() {
		return last_date;
	}
	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Auction(String auction_id, String item_id, String supplier_id, String start_price, String start_date,
			String last_date, String order_id) {
		super();
		this.auction_id = auction_id;
		this.item_id = item_id;
		this.supplier_id = supplier_id;
		this.start_price = start_price;
		this.start_date = start_date;
		this.last_date = last_date;
		this.order_id = order_id;
	}
	
}
