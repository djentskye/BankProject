package com.hibernate.entity;

import java.util.Date;

public class CardData implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int userId;
    private int cardId;
    private int pinNum;
    private Date signupDate; //Do we need java.sql.Date instead?

    public CardData() {

    }

    public CardData(int userId, int cardId, int pinNum, Date signupDate) {
        this.userId = userId;
        this.cardId = cardId;
        this.pinNum = pinNum;
        this.signupDate = signupDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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
}
