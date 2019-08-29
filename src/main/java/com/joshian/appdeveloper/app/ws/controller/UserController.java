package com.joshian.appdeveloper.app.ws.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joshian.appdeveloper.app.ws.model.request.UserDetailsRequestModel;
import com.joshian.appdeveloper.app.ws.model.response.UserRest;
import com.joshian.appdeveloper.app.ws.service.UserService;
import com.joshian.appdeveloper.app.ws.shared.dto.UserDto;

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
		BeanUtils.copyProperties(userDetails, userDto );
		
		UserDto creatUser = userService.createUser(userDto);
		BeanUtils.copyProperties(creatUser, returnValue);
		
		return returnValue;
	}
 
	public String updateUser() {
		return "update user called ";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user ";
	}
}
