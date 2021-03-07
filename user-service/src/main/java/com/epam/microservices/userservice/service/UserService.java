package com.epam.microservices.userservice.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.epam.microservices.userservice.vo.User;

public interface UserService {
	public User addNewUser(User user);

    public User getUser(Long id) throws EntityNotFoundException;

    public User addStayByUser(Long UserId, Long stay) throws EntityNotFoundException;

    public List<User> getUsers(List<Long> userIds ) throws EntityNotFoundException;


}
