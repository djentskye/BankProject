package com.hibernate.entity;

import java.util.Date;

public class UserData implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String gender;
    private Date birthdate;
    private String address;

    public UserData() {

    }

    public UserData(String gender, Date birthdate, String address) {
        this.gender = gender;
        this.birthdate = birthdate;
        this.address = address;
    }

    public int getId() { return this.id; }

    public void setId(int newId) { this.id = newId; }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() { return birthdate; }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String passNum) {
        this.address = address;
    }
}
