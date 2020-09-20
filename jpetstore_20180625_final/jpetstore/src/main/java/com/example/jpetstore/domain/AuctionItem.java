package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuctionItem implements Serializable{
	
	private String itemId;
	//180621 ���� ���̵� �߰�
	private String auctionId;
	private String productId;
	private String categoryId;
	private int startPrice;
	private String seller;
	private String status;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	//20180620 Date -> String Ÿ�� ����
	private String startDate;
	private String lastDate;
	private String auctionName; 
	//20180621 int -> String ���� Ÿ�� ����
	private String isAuction;
	private String isBanner;
	private String image;
	private Product product;
	//20180620 item title �߰�
	private String itemTitle;
	//20180623
	private int quantity;
	private String isAd;
	
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getIsAd() {
		return isAd;
	}
	public void setIsAd(String isAd) {
		this.isAd = isAd;
	}
	public String getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}
	public int getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getAuctionName() {
		return auctionName;
	}
	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	public String getAttribute3() {
		return attribute3;
	}
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	public String getAttribute4() {
		return attribute4;
	}
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}
	public String getAttribute5() {
		return attribute5;
	}
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}
	public String getIsAuction() {
		return isAuction;
	}
	public void setIsAuction(String isAuction) {
		this.isAuction = isAuction;
	}
	public String getIsBanner() {
		return isBanner;
	}
	public void setIsBanner(String isBanner) {
		this.isBanner = isBanner;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	
	

}
