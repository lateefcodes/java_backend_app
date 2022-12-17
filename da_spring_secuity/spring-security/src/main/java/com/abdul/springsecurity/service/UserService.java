package com.abdul.springsecurity.service;

import org.springframework.http.ResponseEntity;

public interface UserService {

	public ResponseEntity<Object> getUserByUserName(String userName);
}
