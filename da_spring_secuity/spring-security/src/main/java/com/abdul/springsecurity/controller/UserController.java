package com.abdul.springsecurity.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdul.springsecurity.entity.User;
import com.abdul.springsecurity.model.CreateUser;
import com.abdul.springsecurity.service.UserService;
import com.abdul.springsecurity.util.CommonUtil;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger logger = LogManager.getLogger("AdminService");
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommonUtil commonUtil;


	@PostMapping(value = "/get",produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	//@PreAuthorize("hasAuthority('ADD_USER')")
	public ResponseEntity<Object> get(@RequestBody @Validated CreateUser user, BindingResult result,@RequestHeader("Authorization") String authorization) {
		User userObj = null;
		try {
			System.out.println(" authorization "+authorization);
			return new ResponseEntity<>(userService.getUserByUserName(user.getPhoneNumber()), HttpStatus.INTERNAL_SERVER_ERROR);
			//return new ResponseEntity<>(commonUtil.getSuccessMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("", e);
		}
		return new ResponseEntity<>(commonUtil.getInternalServerError(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
