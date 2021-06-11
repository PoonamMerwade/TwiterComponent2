package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.entity.TweetModel;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel,Integer>{

//	@Query("{'username':?0}")
	@Query(value="Select * from tweet where username=:username",nativeQuery=true)
	List<TweetModel> findTweetsByUsername(String username);

	List<TweetModel> findByRecordActive(char c);

}
