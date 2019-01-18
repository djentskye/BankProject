package com.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column(table = "first_name")
    private String firstName;
    @Column(table = "last_name")
    private String lastName;
    @Column(table = "username")
    private String userName;
    @Column(table = "passport_number")
    private int passNum;
    @Column(table = "signup_date")
    private Date signupDate; //Do we need java.sql.Date instead?

    private UserData userData;

    public User() {

    }

    public User(String firstName, String lastName, String userName, int passNum, Date signupDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passNum = passNum;
        this.signupDate = signupDate;
    }

    public int getId() { return this.id; }

    public void setId(int newId) { this.id = newId; }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public String toString() {
        String r = new String();
        r += "id:          ";
        r += this.id;
        r += "\n";
        r += "first name:  ";
        r += this.firstName;
        r += "\n";
        r += "last name:   ";
        r += this.lastName;
        r += "\n";
        r += "username:    ";
        r += this.userName;
        r += "\n";
        r += "passnum:     ";
        r += this.passNum;
        r += "\n";
        r += "signup date: ";
        r += this.signupDate;
        return r;
    }
}
