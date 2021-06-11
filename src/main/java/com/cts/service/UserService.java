package com.cts.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cts.entity.Reply;
import com.cts.entity.ReplyEntity;
import com.cts.entity.TweetModel;
import com.cts.entity.UserRegistration;
import com.cts.model.UserTweets;
import com.cts.repository.ReplyRepository;
import com.cts.repository.TweetRepository;
import com.cts.repository.UserRepository;
@Component
@Service
public class UserService implements UserDetailsService  {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ReplyRepository replyRepo;
	
	@Autowired
	TweetRepository tweetRepo;
	
	public UserRegistration RegisterUser(UserRegistration user) {
		user.setPassword(user.getPassword());
		System.out.println("Getting data from DB " + user);
		 return userRepo.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserRegistration user = userRepo.findByusername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getusername(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {

		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public UserRegistration findOne(String username) {

		return userRepo.findByusername(username);
	}
	
	public void updateUser(UserRegistration user) {
		userRepo.save(user);
	}

	public List<UserRegistration> getAllUser() {
		return userRepo.findAll();
	}


	public UserRegistration searchUserByusername(String username) {
		return userRepo.findByusername(username);
	}

	public List<UserTweets> getUsersTweet(String username) {
		List<UserTweets> userTweetsList = new ArrayList<>();
		List<TweetModel> tweetList = tweetRepo.findTweetsByUsername(username);
		tweetList.stream().forEach(tweet -> {
			UserTweets userTweets = new UserTweets();
			userTweets.setTweetId(tweet.getTweetId());
			userTweets.setTweetDesc(tweet.getTweetDescription());
			userTweets.setDate(tweet.getDate());
			List<Reply> replyList = replyRepo.findByTweetId(tweet.getTweetId());
			List<ReplyEntity> replyDTOList = new ArrayList<>();
			replyList.stream().forEach(reply -> {
				ReplyEntity replys = new ReplyEntity();
				replys.setUsername(reply.getUsername());
				replys.setReplyDesc(reply.getReplyDesc());
				replys.setTweetId(reply.getTweetId());
				replys.setDate(reply.getDate());
				replyDTOList.add(replys);
			});
			userTweets.setReplyDTOList(replyDTOList);
			userTweetsList.add(userTweets);
		});
		
		return userTweetsList;
	}

}
	

