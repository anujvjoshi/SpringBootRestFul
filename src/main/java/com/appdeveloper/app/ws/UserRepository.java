package com.appdeveloper.app.ws;

import com.appdeveloper.app.ws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
}
