package com.example.jpetstore.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Post implements Serializable {
    private int postid;
    private String userid;
    private String sellerid;
	private String title;
    private Date date_time;
	private int star_rating;
	private String image;
	private String content;
	private int view_count;
	private int like_count;
    private String temp1;
    private String temp2;
    private String originalfilename;
    private String savedfilename;
    
	@Override
	public String toString() {
		return "Post [postid=" + postid + ", userid=" + userid + ", sellerid=" + sellerid + ", title=" + title + ", date_time=" + date_time + ", star_rating=" + star_rating
				+ ", image=" + image + ", content=" + content + ", view_count=" + view_count + ", like_count=" + like_count + ", temp1=" + temp1 + ", temp2=" + temp2
				+ ", originalfilename=" + originalfilename + ", savedfilename=" + savedfilename + "]";
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public int getStar_rating() {
		return star_rating;
	}
	public void setStar_rating(int star_rating) {
		this.star_rating = star_rating;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public String getTemp1() {
		return temp1;
	}
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}
	public String getTemp2() {
		return temp2;
	}
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
	public String getOriginalfilename() {
		return originalfilename;
	}
	public void setOriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}
	public String getSavedfilename() {
		return savedfilename;
	}
	public void setSavedfilename(String savedfilename) {
		this.savedfilename = savedfilename;
	}
	
}
