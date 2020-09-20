package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BlackList implements Serializable {
	//private int complainId; // 신고 번호
	private String blackId; // 신고 당한 사람 id
	private String blackReason; //신고 사유
	private String page; // 신고 당한 페이지
	private String dateTime;
	private String complainant; //신고자
	
	public BlackList() {
		
	}
	
	public BlackList(String username, String page, String reason, String datetime) {
		super();
		this.blackId = username;
		this.page = page;
		this.blackReason = reason;
		this.dateTime = datetime;
	}



	public String getBlackId() {
		return blackId;
	}

	public void setBlackId(String blackId) {
		this.blackId = blackId;
	}

	public String getBlackReason() {
		return blackReason;
	}

	public void setBlackReason(String blackReason) {
		this.blackReason = blackReason;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getComplainant() {
		return complainant;
	}

	public void setComplainant(String complainant) {
		this.complainant = complainant;
	}
	
	
}
