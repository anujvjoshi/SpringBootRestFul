package com.appdeveloper.app.ws.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdeveloper.app.ws.model.request.UserDetailsRequestModel;
import com.appdeveloper.app.ws.model.response.UserRest;
import com.appdeveloper.app.ws.service.UserService;
import com.appdeveloper.app.ws.shared.dto.UserDto;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "get user ";
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto creatUser = userService.createUser(userDto);
		BeanUtils.copyProperties(creatUser, returnValue); 
		return returnValue;
		
	}
	
	@PutMapping
	public String updateUser() {
		return "update user called ";
	}

	@DeleteMapping
	public String deleteUser() {
		userService.deleteAllUsers();
		return "delete user ";
	}
}
