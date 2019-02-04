package com.hibernate.entity;

import com.hibernate.CardType;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column(table = "user_id")
    private int userId;

    @Enumerated(EnumType.STRING)
    @Column(table = "card_type", columnDefinition = "ENUM('VISA', 'MASTER_CARD', 'DISCOVER')")
    private CardType cardType;


//    private String cardType;

    @Column(table = "card_number")
    private String cardNumber;

    @Column(table = "pin")
    private int pin;

    @Column(table = "balance")
    private double dBalance;

    @Column(table = "signup_date")
    private Date signupDate;

    @Column(table = "expire_date")
    private Date expireDate;

//    public Card() {
//
//    }

    //Add cardData again, if needed
    public Card(CardType cardType, double balance, String cardNum, int userId, int pin) {
        this.dBalance = balance;
        this.cardNumber = cardNum;
        this.userId = userId;
        this.cardType = cardType;
        this.pin = pin;
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

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }
}
