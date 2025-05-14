package com.jpa.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.main.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
