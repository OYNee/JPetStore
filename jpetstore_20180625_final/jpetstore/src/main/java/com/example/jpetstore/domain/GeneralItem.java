package com.example.jpetstore.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class GeneralItem implements Serializable{

	private String itemId;
	private String productId;
	private String categoryId;
	private double listPrice;
	private double unitCost;
	private String seller;
	private String status;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private String isAuction; //20180621 int->String���� ����
	private String isAd;
	private String image;
	private Product product;
	//20180620 item title �߰�
	private String itemTitle;
	private int quantity;
	
	@Override
	public String toString() {
		return "GeneralItem [itemId=" + itemId + ", productId=" + productId + ", categoryId=" + categoryId
				+ ", listPrice=" + listPrice + ", unitCost=" + unitCost + ", seller=" + seller + ", status=" + status
				+ ", attribute1=" + attribute1 + ", attribute2=" + attribute2 + ", attribute3=" + attribute3
				+ ", attribute4=" + attribute4 + ", attribute5=" + attribute5 + ", isAuction=" + isAuction
				+  ", image=" + image + ", product=" + product + "]";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
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

	/*public String getIsBanner() {
		return isBanner;
	}

	public void setIsBanner(String isBanner) {
		this.isBanner = isBanner;
	}*/

	
	public String getImage() {
		return image;
	}

	public String getIsAd() {
		return isAd;
	}

	public void setIsAd(String isAd) {
		this.isAd = isAd;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	 

	
	 
	 

}
