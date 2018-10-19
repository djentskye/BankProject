package com.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_data")
public class UserData implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthdate")
    private Date birthdate;
    @Column(name = "address")
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

    public void setAddress(String address) {
        this.address = address;
    }
}
