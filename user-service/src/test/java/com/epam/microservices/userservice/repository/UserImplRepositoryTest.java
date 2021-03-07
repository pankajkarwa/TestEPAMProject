package com.epam.microservices.userservice.repository;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;

import static org.mockito.BDDMockito.given;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.microservices.userservice.entity.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserImplRepositoryTest {
	
	
	@MockBean
    private UserRepository repository;

    @Autowired
    private UserRepositoryImpl UserRepositoryImpl;

    private UserEntity UserEntity =  new UserEntity(1L, "Thomas cook","thomascook@gmail.com","9890976655");

    @Test
    public void save() {
        given(repository.save(any())).willReturn(UserEntity);
        UserEntity save = UserRepositoryImpl.save(UserEntity);
        assertEquals(save.getUserId(), UserEntity.getUserId());

    }

    @Test
    public  void findById() {
        given(repository.findById(anyLong())).willReturn(java.util.Optional.ofNullable(UserEntity));
        UserEntity byId = UserRepositoryImpl.findById(1L);
        assertEquals(byId.getUserId(), UserEntity.getUserId());
    }

    @Test(expected = EntityNotFoundException.class)
    public void findById_EntityNotFound() {
        given(repository.findById(anyLong())).willThrow(new EntityNotFoundException("Entity not found"));
        UserEntity byId = UserRepositoryImpl.findById(2L);
        assertEquals(byId.getUserId(), UserEntity.getUserId());
    }
	
	
	

}
