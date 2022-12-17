package com.digitalashram.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping(value = "/hello", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    //@PreAuthorize("hasAuthority('ADD_USER')")
    public ResponseEntity<Object> hello(){
        System.out.println(" Welcome to multi module project ");
        return new ResponseEntity<>("Welcome to multi module project ", HttpStatus.OK);
    }
}
