package com.appdeveloper.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdeveloper.app.ws.UserRepository;
import com.appdeveloper.app.ws.io.entity.UserEntity;
import com.appdeveloper.app.ws.service.UserService;
import com.appdeveloper.app.ws.shared.Utils;
import com.appdeveloper.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		if(userRepository.findByEmail(userDto.getEmail()) != null) throw new RuntimeException("User Email Already Exist !");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);

		
		String publicUserId = utils.generateUserId(30);
		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword(userDto.getPassword()+"Test");

		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}


	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

}
