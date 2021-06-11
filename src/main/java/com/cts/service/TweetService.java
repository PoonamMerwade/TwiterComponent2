package com.cts.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.entity.Reply;
import com.cts.entity.ReplyEntity;
import com.cts.entity.TweetModel;
import com.cts.entity.UserRegistration;
import com.cts.model.TweetRequest;
import com.cts.model.TweetResponse;

import com.cts.repository.ReplyRepository;
import com.cts.repository.TweetRepository;
import com.cts.repository.UserRepository;

@Service
public class TweetService {
	@Autowired
	TweetRepository tweetRepo;
	
	ReplyEntity replyEntity;
	
	@Autowired
	ReplyRepository replyRepo;
	
	@Autowired
	UserRepository userRepo;

	public String postTweet(TweetRequest tweetReq) {
		TweetModel tweets = convertDTOToEntity(tweetReq);
		tweetRepo.save(tweets);
		String msg = null;
		if (tweets != null) {
			msg = "Success";
			return msg;
		} else {
			msg = "Internal Server Error Occured";
		}
		return msg;
	}

	public List<TweetResponse> getAllTweets() {
		List<TweetResponse> tweetResponseList = new ArrayList<>();
		List<TweetModel> tweetList = tweetRepo.findByRecordActive('Y');
		tweetList.stream().forEach(tweet -> {
			TweetResponse tweetResponse = new TweetResponse();
			tweetResponse.setTweetDesc(tweet.getTweetDescription());
			tweetResponse.setTweetBy(tweet.getusername());
			tweetResponse.setTweetId(tweet.getTweetId());
			tweetResponse.setDate(tweet.getDate());
			List<Reply> replyList=replyRepo.findByTweetId(tweet.getTweetId());
			List<ReplyEntity> replyDTOList = new ArrayList<>();
			replyList.stream().forEach(reply ->{
				ReplyEntity replyDTO = new ReplyEntity();
				replyDTO.setUsername(reply.getUsername());
				replyDTO.setReplyDesc(reply.getReplyDesc());
				replyDTO.setTweetId(reply.getTweetId());
				replyDTO.setDate(reply.getDate());
				replyDTOList.add(replyDTO);	
			});
			
			tweetResponse.setReplyDTOList(replyDTOList);
			tweetResponseList.add(tweetResponse);
		});

		return tweetResponseList;

	}
	
	public void updateTweet(TweetModel tweet) {
		tweetRepo.save(tweet);
	}

	

	public String postReply(ReplyEntity replyEntity) {
        Reply reply = converttDTOToReplyEntity(replyEntity);
        replyRepo.save(reply);
        String msg = null;
        if (reply != null) {
            msg = "Success";
            return msg;
        } else {
            msg = "Internal Server Error Occured";
        }
        return msg;
    }

    public Reply converttDTOToReplyEntity(ReplyEntity replyEntity) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Reply reply = new Reply();
        reply.setUsername(replyEntity.getUsername());
        reply.setReplyDesc(replyEntity.getReplyDesc());
        reply.setTweetId(replyEntity.getTweetId());
        reply.setDate(dtf.format(now));
        return reply;
    }

    private TweetModel convertDTOToEntity(TweetRequest tweetRequest) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		TweetModel tweets = new TweetModel();

		List<TweetModel> tweetList = tweetRepo.findByRecordActive('Y');
		if (tweetList == null) {
			tweets.setTweetId(1);
		} else {
			int count = tweetList.size();
			tweets.setTweetId(count + 1);
		}

		tweets.setTweetDescription(tweetRequest.getTweetDesc());
		tweets.setDate(dtf.format(now));
		UserRegistration register = userRepo.findByusername(tweetRequest.getUsername());
		tweets.setUsername(register.getusername());
		tweets.setRecordActive('Y');
		return tweets;
	}

	public String deleteTweetBytweetId(int tweetId) {
				tweetRepo.deleteById(tweetId);
				return "success";

	}

	public List<TweetResponse> getAllTweetsByUsername(String username) {
		List<TweetResponse> tweetResponseList = new ArrayList<>();
		List<TweetModel> tweetList = tweetRepo.findTweetsByUsername(username);
		tweetList.stream().forEach(tweet -> {
			TweetResponse tweetResponse = new TweetResponse();
			tweetResponse.setTweetDesc(tweet.getTweetDescription());
			tweetResponse.setTweetBy(tweet.getusername());
			tweetResponse.setTweetId(tweet.getTweetId());
			tweetResponse.setDate(tweet.getDate());
			List<Reply> replyList=replyRepo.findByTweetId(tweet.getTweetId());
			List<ReplyEntity> replyDTOList = new ArrayList<>();
			replyList.stream().forEach(reply ->{
				ReplyEntity replyDTO = new ReplyEntity();
				replyDTO.setUsername(reply.getUsername());
				replyDTO.setReplyDesc(reply.getReplyDesc());
				replyDTO.setTweetId(reply.getTweetId());
				replyDTO.setDate(reply.getDate());
				replyDTOList.add(replyDTO);	
			});
			
			tweetResponse.setReplyDTOList(replyDTOList);
			tweetResponseList.add(tweetResponse);
		});

		return tweetResponseList;

	}

}
