package com.joshian.appdeveloper.app.ws;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.joshian.appdeveloper.app.ws.io.entity.UserEntity;

@Service
public interface UserRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findUserByEmail(String email);
	UserEntity findUserbyFirstName(String firstName);
}
