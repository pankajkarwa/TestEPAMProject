package com.epam.microservices.userservice.mapper;


import java.util.stream.Collectors;

import com.epam.microservices.userservice.entity.CardEntity;
import com.epam.microservices.userservice.entity.UserEntity;
import com.epam.microservices.userservice.vo.Card;
import com.epam.microservices.userservice.vo.CardImpl;
import com.epam.microservices.userservice.vo.User;
import com.epam.microservices.userservice.vo.UserImpl;

public class MapperImpl implements Mapper {              

	@Override
	public User mapUserDTOToIUser(UserEntity userEntity) {
		 User user =  new UserImpl();
		 user.setUserId(userEntity.getUserId());
		 user.setContactNumber(userEntity.getContactNumber());
	        user.setEmail(userEntity.getEmail());
	        user.setName(userEntity.getName());
	        user.setRating(userEntity.getRatting());
	        user.setCards(userEntity.getCards().stream().map(this::mapCardDTOToICard).collect(Collectors.toList()));
	        user.setReservations(userEntity.getReservations());
	        return user;
	}

	@Override
	public UserEntity mapIUserToUserDTO(User user) {
		UserEntity userEntity =  new UserEntity();
        userEntity.setUserId(user.getUserId());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setRatting(user.getRating());
        userEntity.setContactNumber(user.getContactNumber());
        userEntity.setCards(user.getCards().stream().map(this::mapICardToCardDTO).collect(Collectors.toList()));
        userEntity.setReservations(user.getReservations());
        return userEntity;
	}
	
	 public Card mapCardDTOToICard(CardEntity cardEntity){
	        Card card = new CardImpl();
	        card.setCardNumber(cardEntity.getCardNumber());
	        card.setExpMonth(cardEntity.getExpMonth());
	        card.setExpYear(cardEntity.getExpYear());
	        return card;
	    }

	    public CardEntity mapICardToCardDTO(Card card){
	        CardEntity cardEntity =  new CardEntity();
	        cardEntity.setCardNumber(card.getCardNumber());
	        cardEntity.setExpMonth(card.getExpMonth());
	        cardEntity.setExpYear(card.getExpYear());
	        return cardEntity;
	    }

		
}
