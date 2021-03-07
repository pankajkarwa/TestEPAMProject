package com.epam.microservices.userservice.controller;

import com.epam.microservices.userservice.vo.User;
import com.epam.microservices.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.util.List;

@RestController
public class UserControllerImpl implements UserController {
    @Inject
    private UserService service;

    @Override
    public ResponseEntity<User> addNewUser(User user) {
        User response = service.addNewUser(user);
        return ResponseEntity.created(URI.create(String.format("/user/" + response.getUserId())))
                .body(response);
    }

    @Override
    public ResponseEntity<User> getUser(Long userId) {
        User user = service.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> addStayByUser(Long userId, Long stay){
        return ResponseEntity.ok(service.addStayByUser(userId, stay));
    }

    @Override
    public ResponseEntity<List<User>> getUsers(List<Long> userIds){
        return ResponseEntity.ok(service.getUsers(userIds));
    }

}
