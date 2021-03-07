package com.epam.microservices.userservice.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.microservices.userservice.entity.UserEntity;
import com.epam.microservices.userservice.mapper.Mapper;
import com.epam.microservices.userservice.repository.UserRepositoryImpl;
import com.epam.microservices.userservice.vo.User;

public class UserServiceImpl implements UserService{
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	    @Autowired
	    private UserRepositoryImpl repository;

	    @Inject
	    private Mapper mapper;

	

	@Override
	public User addNewUser(User user) {                
		 UserEntity savedUser = repository.save(mapper.mapIUserToUserDTO(user));
	        return mapper.mapUserDTOToIUser(savedUser);
		
	}

	@Override
	public User getUser(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addStayByUser(Long UserId, Long stay) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers(List<Long> userIds) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
