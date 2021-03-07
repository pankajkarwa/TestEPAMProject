package com.epam.microservices.userservice.repository;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.microservices.userservice.entity.UserEntity;

@Component
public class UserRepositoryImpl  {
	
    @Autowired
    private UserRepository repository;
	
    public UserEntity save(UserEntity guestEntity){
        return repository.save(guestEntity);
    }

    public UserEntity findById(Long id) throws EntityNotFoundException {
        Optional<UserEntity> guestOption = repository.findById(id);
        return guestOption.isPresent() ? guestOption.get() : guestOption.orElseThrow(()-> new EntityNotFoundException("User not found."));
    }

	
	
}
