package com.joshian.appdeveloper.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshian.appdeveloper.app.ws.UserRepository;
import com.joshian.appdeveloper.app.ws.io.entity.UserEntity;
import com.joshian.appdeveloper.app.ws.service.UserService;
import com.joshian.appdeveloper.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		
		// Temporarily adding the values hard coded 
		userEntity.setEncryptedPassword("Test");
		userEntity.setUserId("testUserId");
		
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}
	
	

}
