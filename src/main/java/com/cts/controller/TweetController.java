package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cts.entity.ReplyEntity;
import com.cts.entity.TweetModel;
import com.cts.model.TweetRequest;
import com.cts.model.TweetResponse;
import com.cts.service.TweetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "The Twitter Model", description = "Rest controller for Twitter")
@RestController
@RequestMapping("/tweets")
@CrossOrigin(origins = "*",exposedHeaders="Access-Control-Allow-Origin")
public class TweetController {
	
	@Autowired
	TweetService tweetService;
	
	TweetModel tweet;
	
	
	@ApiOperation(value = "Post the tweet", consumes = "JSON details", notes = "Hit this url to post the tweet")
	@RequestMapping(method=RequestMethod.POST,value="/post")
	public String PostTweet(@RequestBody TweetRequest tweetReq){
		String msg=tweetService.postTweet(tweetReq);
		return msg;
	}

	@PostMapping("/replyTweet")
    public String replytweet(@RequestBody ReplyEntity reply){
		String message = tweetService.postReply(reply);
        return message;
        
    }
	@ApiOperation(value = "Get all tweets", produces = "all tweets", notes = "Hit this URL to get Tweets posted by all")
	@RequestMapping(method=RequestMethod.GET,value="/allTweets")
	public ResponseEntity<List<TweetResponse>> getAllTweets() {

		return ResponseEntity.ok().body(tweetService.getAllTweets());
	}

	@RequestMapping(method=RequestMethod.GET,value="/TweetsbyUser/{username}")
	public ResponseEntity<List<TweetResponse>> getAllTweetsNyUsername(@PathVariable("username") String username) {

		return ResponseEntity.ok().body(tweetService.getAllTweetsByUsername(username));
	}
	
	
	
	@ApiOperation(value = "Update the tweet", consumes = "JSON details", notes = "Hit this url to update the tweet")
	@RequestMapping(method=RequestMethod.PUT,value="/update/{username}")
	public void update(@RequestBody TweetModel tweet){
		tweetService.updateTweet(tweet);
	}	
	
	
	@ApiOperation(value = "Delete tweet", consumes = "An existing tweet", notes = "Hit this URL to delete tweet")
	@RequestMapping(method=RequestMethod.DELETE,value="/delete")
	public String deleteTweet(@RequestParam("tweetId") int tweetId) {
		String message = tweetService.deleteTweetBytweetId(tweetId);

		return message;

	}
	
}
