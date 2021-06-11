package com.cts.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.entity.UserRegistration;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, String> {


//	@Query("{username:?0}")
	@Query(value="Select * from user where username=:username",nativeQuery=true)
	UserRegistration findByusername(String username);

}
