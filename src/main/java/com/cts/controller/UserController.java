package com.cts.controller;

import java.util.List;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.UserRegistration;
import com.cts.model.UserTweets;
import com.cts.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "The user Controller", description = "Rest controller for user")
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*",exposedHeaders="Access-Control-Allow-Origin")
public class UserController {
	

	@Autowired
	UserService userService;

		
	Logger logger = LoggerFactory.getLogger(UserController.class);
	

	@ApiOperation(value = "Add a user", consumes = "A new user is JSON", notes = "Hit this URL to insert a new users's details")
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public UserRegistration Register(@RequestBody UserRegistration user) {
		UserRegistration details=userService.RegisterUser(user);
//		template.send(topic,"succesfully registered"+details);
		return details;
	}	
	
	
	@ApiOperation(value = "Get a all users", produces = "all users", notes = "Hit this URL to get all users")
	@RequestMapping(method=RequestMethod.GET,value="/allUsers")
	public List<UserRegistration> getAllUser() {
		List<UserRegistration> user=userService.getAllUser();
//		template.send(topic, user);
		return user;
	}
	
	
	@ApiOperation(value = "Get a userr", produces = "customer by username", notes = "Hit this URL to get user by username")	
	@RequestMapping(method=RequestMethod.GET,value="/search/{username}")
	public UserRegistration searchUser(@PathVariable String username) {
		
		UserRegistration search=userService.searchUserByusername(username);
//		template.send(topic, search);
		return search;
		
	}
	
	@ApiOperation(value = "upadte a user", consumes = "A existing user is JSON", notes = "Hit this URL to update users's details")
	@RequestMapping(method=RequestMethod.PUT,value="/update/{username}")
	public void update(@RequestBody UserRegistration user){
		userService.updateUser(user);
	}	
	
	@ApiOperation(value = "Get a all use tweets", produces = "all tweets of a user", notes = "Hit this URL to get all tweets")
	@GetMapping("/allTweets")
	public ResponseEntity<List<UserTweets>> getUsersTweet(@RequestParam("username") String username) {
		return ResponseEntity.ok().body(userService.getUsersTweet(username));
	}


	
	@PatchMapping("/update/{username}") 
	public void forgotPassword(@PathVariable("username") String username,@RequestBody Map<Object,Object> fields) {
	
		UserRegistration newUser = userService.findOne(username);
		
		fields.forEach((k,v)->{
			java.lang.reflect.Field field=ReflectionUtils.findRequiredField(UserRegistration.class,(String) k);
			field.setAccessible(true);
			ReflectionUtils.setField(field, newUser, v);	
		});
		userService.updateUser(newUser);
	
	}
}
