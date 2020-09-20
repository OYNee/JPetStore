package com.example.jpetstore.domain;

import java.sql.Date;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Mileage implements Serializable {
	
	private String user_id;
	private Date datetime;
	private int point;
	private String description;
	
	public Mileage() {
		
	}
	
	public Mileage(String user_id, int point, String description) {
		super();
		this.user_id = user_id;
		this.point = point;
		this.description = description;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
