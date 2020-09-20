package com.example.jpetstore.domain;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Account implements Serializable {

  /* Private Fields */

	  private String user_id;
	  private String password;
	  private String favouriteCategoryId;
	  private String languagePreference;
	  private String email;
	  private String firstName;
	  private String lastName;
	  private String status;
	  private String address1;
	  private String address2;
	  private String city;
	  private String state;
	  private String zip;
	  private String country;
	  private String phone;
	  private boolean listOption;
	  private boolean bannerOption;
	  private String bannerName;
	  private int nowMileage;
	  private int onBlackList;

	  public Account(String user_id, String password, String favouriteCategoryId, String email, String firstName,
			String lastName, String status, String address1, String address2, String city, String state, String zip,
			String country, String phone, String sex, int now_mileage, int onBlackList) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.favouriteCategoryId = favouriteCategoryId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
		this.sex = sex;
		this.nowMileage = now_mileage;
		this.onBlackList = onBlackList;
	  }
	  
	  
	  
	  
		public Account() {
			// TODO Auto-generated constructor stub
		}
	
	
	
	
		private String sex;
	 // private boolean bannerOption;
	 // private String bannerName;
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFavouriteCategoryId() {
			return favouriteCategoryId;
		}
		public void setFavouriteCategoryId(String favouriteCategoryId) {
			this.favouriteCategoryId = favouriteCategoryId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getLanguagePreference() {
			return languagePreference;
		}

		public void setLanguagePreference(String languagePreference) {
			this.languagePreference = languagePreference;
		}




		public boolean isListOption() {
			return listOption;
		}




		public void setListOption(boolean listOption) {
			this.listOption = listOption;
		}




		public boolean isBannerOption() {
			return bannerOption;
		}




		public void setBannerOption(boolean bannerOption) {
			this.bannerOption = bannerOption;
		}




		public String getBannerName() {
			return bannerName;
		}




		public void setBannerName(String bannerName) {
			this.bannerName = bannerName;
		}
		
		public int getListOptionAsInt() {
			return listOption ? 1:0;
		}
		
		public int getBannerOptionAsInt() {
			return bannerOption? 1:0;
		}




		public int getNowMileage() {
			return nowMileage;
		}




		public void setNowMileage(int nowMileage) {
			this.nowMileage = nowMileage;
		}




		public int getOnBlackList() {
			return onBlackList;
		}




		public void setOnBlackList(int onBlackList) {
			this.onBlackList = onBlackList;
		}
		
		
		  /* JavaBeans Properties */
}
