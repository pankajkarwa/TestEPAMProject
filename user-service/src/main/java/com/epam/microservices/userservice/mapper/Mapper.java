package com.epam.microservices.userservice.mapper;

import com.epam.microservices.userservice.entity.CardEntity;
import com.epam.microservices.userservice.entity.UserEntity;
import com.epam.microservices.userservice.vo.Card;
import com.epam.microservices.userservice.vo.User;

public interface Mapper {
	
	  public User mapUserDTOToIUser(UserEntity userEntity);

	    public UserEntity mapIUserToUserDTO(User user);

	    public CardEntity mapICardToCardDTO(Card card);


}
