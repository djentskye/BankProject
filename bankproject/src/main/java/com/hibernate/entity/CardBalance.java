package com.hibernate.entity;

public class CardBalance implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int cardId;
    private int balance;

    public CardBalance() {

    }

    public CardBalance(int cardId, int balance) {
        this.cardId = cardId;
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardId() {
        return this.cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
