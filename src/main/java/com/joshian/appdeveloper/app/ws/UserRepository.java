package com.joshian.appdeveloper.app.ws;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joshian.appdeveloper.app.ws.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findUserByEmail(String email);
	UserEntity findUserbyFirstName(String firstName);
}
