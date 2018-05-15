package com.hibernate.entity;

public class Card {

    private int userId;

//    CardData cardData;

    private String cardNumber;

    private double dBalance;

    //Add cardData again, if needed
    private Card(double balance, String cardNum, int userId) {
        this.dBalance = balance;
        this.cardNumber = cardNum;
        this.userId = userId;
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
