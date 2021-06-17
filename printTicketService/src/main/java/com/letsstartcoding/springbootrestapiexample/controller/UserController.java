package com.letsstartcoding.springbootrestapiexample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsstartcoding.springbootrestapiexample.dao.UserDAO;
import com.letsstartcoding.springbootrestapiexample.model.User;

@RestController
@RequestMapping("/company")
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	/* to save a user*/
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userDAO.save(user);
	}

}
