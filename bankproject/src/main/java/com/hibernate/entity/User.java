package com.hibernate.entity;

import java.util.Date;

public class User implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String firstName;
    private String lastName;
    private int passNum;
    private Date signupDate; //Do we need java.sql.Date instead?

    public User() {

    }

    public User(String firstName, String lastName, int passNum, Date signupDate, Date expireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passNum = passNum;
        this.signupDate = signupDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPassNum() {
        return passNum;
    }

    public void setPassNum(int passNum) {
        this.passNum = passNum;
    }

    public Date getSignupDate() {
        return this.signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }
}
