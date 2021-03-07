package com.epam.microservices.userservice.vo;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements User {
	
    private Long userId;
    private String name;
    private String email;
    private String contactNumber;
    private int rating;
    private List<Long> reservations =  new ArrayList<>();

    private List<Card> cards = new ArrayList<>();

	public UserImpl(long userId, String name, String email, String contactNumber) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
	}

	public UserImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Long> getReservations() {
		// TODO Auto-generated method stub
		return reservations;
	}

	@Override
	public void setReservations(List<Long> reservations) {
		// TODO Auto-generated method stub
		this.reservations=reservations;
		
	}

	@Override
	public Long getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}

	@Override
	public void setUserId(Long userId) {
		// TODO Auto-generated method stub
		this.userId=userId;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email=email;
	}

	@Override
	public String getContactNumber() {
		// TODO Auto-generated method stub
		return contactNumber;
	}

	@Override
	public void setContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
		this.contactNumber=contactNumber;
	}

	@Override
	public int getRating() {
		// TODO Auto-generated method stub
		return rating;
	}

	@Override
	public void setRating(int rating) {
		// TODO Auto-generated method stub
		this.rating=rating;
	}

	@Override
	public List<Card> getCards() {
		// TODO Auto-generated method stub
		return cards;
	}

	@Override
	public void setCards(List<Card> cards) {
		// TODO Auto-generated method stub
		this.cards=cards;
	}

}
