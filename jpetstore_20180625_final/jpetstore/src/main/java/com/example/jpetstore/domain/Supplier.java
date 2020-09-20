package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Supplier {
	private int suppId;
	private String name;
	private String Status;
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String zip;
	private String phone;

	
	public Supplier() {
	}

	public Supplier(int suppId, String name, String status, String addr1, String addr2, String city, String state,
			String zip, String phone) {
		this.suppId = suppId;
		this.name = name;
		Status = status;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}
	public int getSuppId() {return suppId;	}
	public void setSuppId(int suppId) {	this.suppId = suppId;	}
	public String getName() {	return name;	}
	public void setName(String name) {this.name = name;	}
	public String getStatus() {	return Status;	}
	public void setStatus(String status) {	Status = status;	}
	public String getAddr1() {	return addr1;	}
	public void setAddr1(String addr1) {this.addr1 = addr1;	}
	public String getAddr2() {	return addr2;	}
	public void setAddr2(String addr2) {this.addr2 = addr2;	}
	public String getCity() {return city;	}
	public void setCity(String city) {this.city = city;}
	public String getState() {	return state;}
	public void setState(String state) {this.state = state;	}
	public String getZip() {	return zip;	}
	public void setZip(String zip) {this.zip = zip;	}
	public String getPhone() {	return phone;	}
	public void setPhone(String phone) {this.phone = phone;	}
	
	
	

}
