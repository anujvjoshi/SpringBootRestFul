package com.joshian.appdeveloper.app.ws.service;

import org.springframework.stereotype.Service;

import com.joshian.appdeveloper.app.ws.shared.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
}
