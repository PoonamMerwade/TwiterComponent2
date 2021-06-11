package com.cts.model;

import java.util.List;

import com.cts.entity.ReplyEntity;

public class UserTweets {
	private int tweetId;
	
	private String tweetDesc;
	
	private String date;
	
	private List<ReplyEntity> replyDTOList;

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweetDesc() {
		return tweetDesc;
	}

	public void setTweetDesc(String tweetDesc) {
		this.tweetDesc = tweetDesc;
	}

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<ReplyEntity> getReplyDTOList() {
		return replyDTOList;
	}

	public void setReplyDTOList(List<ReplyEntity> replyList) {
		this.replyDTOList = replyList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((replyDTOList == null) ? 0 : replyDTOList.hashCode());
		result = prime * result + ((tweetDesc == null) ? 0 : tweetDesc.hashCode());
		result = prime * result + tweetId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTweets other = (UserTweets) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (replyDTOList == null) {
			if (other.replyDTOList != null)
				return false;
		} else if (!replyDTOList.equals(other.replyDTOList))
			return false;
		if (tweetDesc == null) {
			if (other.tweetDesc != null)
				return false;
		} else if (!tweetDesc.equals(other.tweetDesc))
			return false;
		if (tweetId != other.tweetId)
			return false;
		return true;
	}
	
	
	

}
