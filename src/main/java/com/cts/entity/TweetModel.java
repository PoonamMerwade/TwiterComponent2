package com.cts.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "This is the Twitter model")
@Entity(name="Tweet")
public class TweetModel {
		
	@ApiModelProperty(value = "id of a tweet")
	@Id
	public int tweetId;
	
	@ApiModelProperty(value = "Tweet")
	@Size(max =144 )
	public String tweetDescription;
	
	@ApiModelProperty(value = "Login Id of a person")
	@NotBlank
	public String username;
	
	public String date;
	
	public char recordActive;
	
	public char getRecordActive() {
		return recordActive;
	}

	public void setRecordActive(char recordActive) {
		this.recordActive = recordActive;
	}

	@JsonIgnore
	@OneToMany
	private List<Reply> reply;
	
	public TweetModel() {
		super();
	}
	
	
	public TweetModel(int tweetId, @Size(max = 144) String tweetDescription, @NotBlank String username, String date,
			char recordActive, List<Reply> reply) {
		super();
		this.tweetId = tweetId;
		this.tweetDescription = tweetDescription;
		this.username = username;
		this.date = date;
		this.recordActive = recordActive;
		this.reply = reply;
	}



	public String getTweetDescription() {
		return tweetDescription;
	}

	public void setTweetDescription(String tweetDescription) {
		this.tweetDescription = tweetDescription;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}

	

	public List<Reply> getReply() {
		return reply;
	}

	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}

	
	
	
	
}
