package com.example.jpetstore.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Answer implements Serializable{
	private String answerId;
	private String questionId;
	private String answerWriter;
	private String content;
	private Date date_time; //0624
	
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", questionId=" + questionId + ", answerWriter=" + answerWriter
				+ ", content=" + content + ", date_time=" + date_time + "]";
	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getAnswerWriter() {
		return answerWriter;
	}
	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	

	
}
