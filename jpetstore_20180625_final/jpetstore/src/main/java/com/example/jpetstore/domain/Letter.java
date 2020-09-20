package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Letter implements Serializable {

    private int letterid;
    private String sender;
    private String receiver;
    private String title;
    private String content;
	private String datetime;
	private String receivedDate;
	
	@Override
	public String toString() {
		return "Letter [letterid=" + letterid + ", sender=" + sender + ", receiver=" + receiver + ", title=" + title + ", content=" + content + ", datetime=" + datetime
				+ ", receivedDate=" + receivedDate + "]";
	}
	public int getLetterid() {
		return letterid;
	}
	public void setLetterid(int letterid) {
		this.letterid = letterid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
    



	
    
	
}
