package com.appdeveloper.app.ws.service;

import com.appdeveloper.app.ws.shared.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	void deleteAllUsers();
	
}
