package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Advertisement implements Serializable {
	private String bannerid;
	private String favCategory;
	private String itemid;
	private String title;
	private String description;
	private int bannerPrice;
	private String image;
	private String startDate;
	private String endDate;
	private String seller;
	public String getBannerid() {
		return bannerid;
	}
	public void setBannerid(String bannerid) {
		this.bannerid = bannerid;
	}
	public String getFavCategory() {
		return favCategory;
	}
	public void setFavCategory(String favCategory) {
		this.favCategory = favCategory;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBannerPrice() {
		return bannerPrice;
	}
	public void setBannerPrice(int bannerPrice) {
		this.bannerPrice = bannerPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	
}
