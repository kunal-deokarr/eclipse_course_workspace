package com.jpa.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.main.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUserEmail(String email);

}
