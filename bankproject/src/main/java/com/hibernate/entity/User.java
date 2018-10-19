package com.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
//@SecondaryTable(name = "user_data",
//    pkJoinColumns = @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id"))
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
    @Column(table = "passport_number")
    private int passNum;
    @Column(table = "signup_date")
    private Date signupDate; //Do we need java.sql.Date instead?

//    @Column(table = "gender")
//    private String gender;
//    @Column(table = "birthdate")
//    private Date birthDate;
//    @Column(table = "address")
//    private String address;

    private UserData userData;

    public User() {

    }

    public User(String firstName, String lastName, int passNum, Date signupDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passNum = passNum;
        this.signupDate = signupDate;
    }

//    public User(String firstName, String lastName, int passNum, Date signupDate, String gender, Date birthdate, String address) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.passNum = passNum;
//        this.signupDate = signupDate;
//        this.gender = gender;
//        this.birthDate = birthdate;
//        this.address = address;
//    }

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

//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public Date getBirthdate() { return birthDate; }
//
//    public void setBirthdate(Date birthdate) {
//        this.birthDate = birthdate;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String passNum) {
//        this.address = address;
//    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
