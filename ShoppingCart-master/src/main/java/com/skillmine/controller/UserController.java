package com.skillmine.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillmine.domain.User;
import com.skillmine.service.UserService;

@RestController
@RequestMapping("/shoppingcart")
public class UserController {
	
    @Autowired
    private UserService userService;

      @ResponseBody
	  @GetMapping( produces = "application/json", value ="/user/{email}")
	    public User getUser(@PathVariable("email") String email){
	       return userService.getUser(email);
	    }
    
    
    
    

}