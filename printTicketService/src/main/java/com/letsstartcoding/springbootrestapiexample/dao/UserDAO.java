package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.User;
import com.letsstartcoding.springbootrestapiexample.repository.UserRepository;

@Service
public class UserDAO {
	
	@Autowired
	UserRepository userRepository;
	
	/*to save an employee*/
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	
	/* search all employees*/
	
//	public List<User> findAll(){
//		return userRepository.findAll();
//	}
//	
//	
	/*get an employee by id*/
	public User findOne(Long userId) {
		return userRepository.findOne(userId);
	}
//	
//	
//	/*delete an employee*/
//	
//	public void delete(User user) {
//		userRepository.delete(user);
//	}

}
