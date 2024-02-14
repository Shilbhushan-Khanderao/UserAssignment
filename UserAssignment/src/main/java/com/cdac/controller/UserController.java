package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cdac.model.User;
import com.cdac.service.UserService;
import com.cdac.response.Response;

@CrossOrigin("*")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody User user){
		User u = userService.login(user);
		
		if(u == null) {
			return Response.error("User not found");
		}
		return Response.success(u);
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<?> register(@RequestBody User user){
		if(userService.register(user)) {
			return Response.success(user);
		}
		return Response.error("Registration failed!!");
	}
}
