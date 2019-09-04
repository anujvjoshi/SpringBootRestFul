package com.appdeveloper.app.ws;

import org.springframework.data.repository.CrudRepository;
import com.appdeveloper.app.ws.io.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
}
