package com.skillmine.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.skillmine.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT user FROM User user WHERE user.email LIKE %:email%")
	User findByEmail(@Param("email") String email);
}
