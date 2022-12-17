package com.abdul.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdul.springsecurity.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserName(String userName);
}
