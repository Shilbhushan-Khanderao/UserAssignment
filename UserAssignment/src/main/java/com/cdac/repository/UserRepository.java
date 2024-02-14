package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cdac.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("From User u where u.email = ?1 and u.password = ?2")
	User login(String email, String password);

}
