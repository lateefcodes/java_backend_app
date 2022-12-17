/*
 @author: lateef
 @project: digitalashram
 @created: 11/06/2022 - 11:35 AM
 */
package com.digitalashram.users.controller;


import com.digitalashram.users.model.CreateUser;
import com.digitalashram.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
//@RequestMapping("da")
public class UserLoginController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String welcome() {
        return "Welcome to Google !!";
    }

    @GetMapping("/googleLogin")
    public Map<String,Object> user(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        System.out.println("user object : " + oAuth2AuthenticationToken.getPrincipal());
        System.out.println("user object : " + oAuth2AuthenticationToken.getPrincipal().getAttributes());
        System.out.println("username : " + oAuth2AuthenticationToken.getPrincipal().getAttributes().get("name"));


       // System.out.println("Object : " + principal);
        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }

    @GetMapping("/googleLoginTest")
    public ResponseEntity<Object> userTest(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        System.out.println("user object : " + oAuth2AuthenticationToken.getPrincipal());
        System.out.println("user object : " + oAuth2AuthenticationToken.getPrincipal().getAttributes());
        System.out.println("username : " + oAuth2AuthenticationToken.getPrincipal().getAttributes().get("name"));
        // System.out.println("Object : " + principal);
        CreateUser userBean= new CreateUser();
        userBean.setEmailId((String) oAuth2AuthenticationToken.getPrincipal().getAttributes().get("email"));

        return new ResponseEntity<>(userService.createUser(userBean), HttpStatus.OK);
    }

    @PostMapping("/first/hello")
    public ResponseEntity<Object> save(@RequestBody @Validated CreateUser user, BindingResult result){
        System.out.println("in save method");
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);

    }

}
