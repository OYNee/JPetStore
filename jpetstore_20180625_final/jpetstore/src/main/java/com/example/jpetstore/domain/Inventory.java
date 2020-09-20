package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Inventory implements Serializable {
	private String itemId;
	private int quantity;
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Inventory() {
		
	}
	public Inventory(String itemId, int quantity) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	

}
