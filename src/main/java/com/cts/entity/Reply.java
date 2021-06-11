package com.cts.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
//@Document(collection = "reply")
@Entity(name="Reply")
public class Reply {
	
    private String username;
    
    @Id
    private int tweetId;
    
    private String replyDesc;
    
    private String date;
    
	public Reply() {
		super();
	}
	
	public Reply(String username, int tweetId, String replyDesc, String date) {
		super();
		this.username =username ;
		this.tweetId = tweetId;
		this.replyDesc = replyDesc;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Reply [username=" + username + ", tweetId=" + tweetId + ", replyDesc="
				+ replyDesc + ", date=" + date + "]";
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
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

	
    
    

}
