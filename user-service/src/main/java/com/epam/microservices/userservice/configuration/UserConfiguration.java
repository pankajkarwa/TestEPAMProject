package com.epam.microservices.userservice.configuration;

import com.epam.microservices.userservice.mapper.Mapper;
import com.epam.microservices.userservice.service.UserService;
import com.epam.microservices.userservice.mapper.MapperImpl;
import com.epam.microservices.userservice.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    @Bean
    public Mapper getMapper() {
        return new MapperImpl();
    }
}
