package com.epam.microservices.userservice.vo;

import java.util.List;

public interface User {
	
	public List<Long> getReservations();

    public void setReservations(List<Long> reservations);

    public Long getUserId();

    public void setUserId(Long guestId);

    public String getName();

    public void setName(String name);

    public String getEmail();

    public void setEmail(String email);

    public String getContactNumber();

    public void setContactNumber(String contactNumber);

    public int getRating();

    public void setRating(int rating);

    /*public List<IStay> getStayList();

    public void setStayList(List<IStay> stayList);*/

    public List<Card> getCards();

    public void setCards(List<Card> cards);

}
