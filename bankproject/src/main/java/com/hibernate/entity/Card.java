package com.hibernate.entity;

import javax.persistence.Entity;

public class Card {

    private int id;

    private int userId;

//    CardData cardData;

    private String cardNumber;

    private double dBalance;

    public Card() {

    }

    //Add cardData again, if needed
    public Card(double balance, String cardNum, int userId) {
        this.dBalance = balance;
        this.cardNumber = cardNum;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getdBalance() {
        return this.dBalance;
    }

    public void setdBalance(double dBalance) {
        this.dBalance = dBalance;
    }
}
