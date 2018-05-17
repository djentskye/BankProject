package com.hibernate.entity;

import java.util.Date;

public class CardData implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int cardId;
    private int pin;
    private Date signupDate; //Do we need java.sql.Date instead?
    private Date expireDate;

    public CardData() {

    }

    public CardData(int userId, int cardId, int pinNum, Date signupDate, Date expireDate) {
        this.cardId = cardId;
        this.pin = pin;
        this.signupDate = signupDate;
        this.expireDate = expireDate;
    }

    public int getId() { return this.id; }

    public void setId(int newId) { this.id = newId; }

    public int getCardId() {
        return this.cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Date getSignupDate() {
        return this.signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
