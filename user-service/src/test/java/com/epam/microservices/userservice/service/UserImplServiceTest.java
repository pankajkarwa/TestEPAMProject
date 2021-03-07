package com.epam.microservices.userservice.service;


import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.microservices.userservice.entity.UserEntity;
import com.epam.microservices.userservice.repository.UserRepositoryImpl;
import com.epam.microservices.userservice.service.UserService;
import com.epam.microservices.userservice.vo.User;
import com.epam.microservices.userservice.vo.UserImpl;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserImplServiceTest {
	
	@Autowired
    private UserService userService;

    @MockBean
    private UserRepositoryImpl repository;

    User user = new UserImpl(1L, "Thomas cook","thomascook@gmail.com","9890976655");
    UserEntity userEntity =  new UserEntity(1L, "Thomas cook","thomascook@gmail.com","9890976655");
    UserEntity userEntity1 = new UserEntity(2L, "Thomas cook","thomascook@gmail.com","9890976655");
    @Test
    @Order(1)
    public void addNewUser() {

        given(repository.save(any())).willReturn(userEntity);
        User resultUser = userService.addNewUser(user);

        assertEquals(userEntity.getUserId(), resultUser.getUserId());
        assertEquals(userEntity.getName(), resultUser.getName());
        assertEquals(userEntity.getEmail(), resultUser.getEmail());
        assertEquals(userEntity.getContactNumber(), resultUser.getContactNumber());
    }

	
	  @Test	  
	  @Order(2) 
	  public void getUser() {	  
	  given(repository.findById(anyLong())).willReturn(userEntity);
	   User resultUser = userService.getUser(1L); assertEquals(userEntity.getUserId(),
	  resultUser.getUserId()); assertEquals(userEntity.getName(),
	  resultUser.getName()); assertEquals(userEntity.getEmail(),
	  resultUser.getEmail()); assertEquals(userEntity.getContactNumber(),
	  resultUser.getContactNumber()); }
	 
    

    @Test(expected = EntityNotFoundException.class)
    @Order(3)
    public void getUser_EntityNotFound() {
        given(repository.findById(anyLong())).willThrow(new EntityNotFoundException("Entity not found"));
        userService.getUser(1L);
    }

    
    @Test	
	@Order(4) 
    public void addStayByUser() {
	given(repository.findById(anyLong())).willReturn(userEntity); 
	User resultUser	 = userService.addStayByUser(1L, 1L);
	assertTrue(resultUser.getReservations().stream().filter(aLong -> aLong.equals(1L)).findFirst().isPresent()); 
	}
	
	 @Test
	  
	 @Order(5) public void getUsers() {
	 given(repository.findById(1L)).willReturn(userEntity);
	 given(repository.findById(2L)).willReturn(userEntity1); List<User> userList =
	 userService.getUsers(Arrays.asList(1L, 2L));
	 assertTrue(userList.stream().filter(user ->
	 user.getUserId().equals(1L)).findFirst().isPresent());
	 assertTrue(userList.stream().filter(user ->
	 user.getUserId().equals(2L)).findFirst().isPresent()); }
	 


}
