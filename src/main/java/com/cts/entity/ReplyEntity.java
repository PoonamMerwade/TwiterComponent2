package com.cts.entity;

import java.util.Date;

public class ReplyEntity {
	
	
	private String username;
    
    private int tweetId;
    
    private String replyDesc;
    
    private String date;
    
	public ReplyEntity() {
		super();
	}

	public ReplyEntity(String username, int tweetId, String replyDesc, String date) {
		super();
		this.username = username;
		this.tweetId = tweetId;
		this.replyDesc = replyDesc;
		this.date = date;
	}
	
	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int i) {
		this.tweetId = i;
	}

	public String getReplyDesc() {
		return replyDesc;
	}

	public void setReplyDesc(String replyDesc) {
		this.replyDesc = replyDesc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
	

	
	
}
