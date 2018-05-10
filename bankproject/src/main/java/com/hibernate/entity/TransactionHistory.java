package com.hibernate.entity;

import java.util.Date;

public class TransactionHistory implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int cardId;
    private int amt;
    private String type;

    public TransactionHistory() {

    }

    public TransactionHistory(int cardId, int amt, String type) {
        this.cardId = cardId;
        this.amt = amt;
        this.type = type;
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

    public int getAmt() {
        return this.amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
