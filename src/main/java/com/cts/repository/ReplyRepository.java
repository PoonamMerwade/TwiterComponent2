package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply,Integer> {
	List<Reply> findByTweetId(int i);
}
