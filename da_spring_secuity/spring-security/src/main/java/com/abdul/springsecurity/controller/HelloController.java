package com.abdul.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdul.springsecurity.util.CommonUtil;

@RestController
@RequestMapping("/first")
public class HelloController {
	
	@Autowired
	CommonUtil commonUtil;
	
	@PostMapping(value = "/hello",produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	//@PreAuthorize("hasAuthority('ADD_USER')")
	public ResponseEntity<Object> hello(){
		System.out.println(" welcome ");
		return new ResponseEntity<>(commonUtil.getSuccessMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
