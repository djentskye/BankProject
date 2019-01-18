package com.hibernate.service;

import com.hibernate.entity.User;
import com.hibernate.entity.UserData;
import com.hibernate.mapping.UserMapping;
import com.hibernate.persistence.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    public int getUserIdByPassNum(int passNum) {
        int userId;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            List<Integer> user = session.createQuery("SELECT id FROM User WHERE passport_number=" + passNum).list();

            userId = user.get(0);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("There was an error processing the request. ");
            userId = -1;
        }
        return userId;
    }

    public void newUser(String firstName, String lastName, String userName, int passNum) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            Date date = new Date();

            User user = new User(firstName, lastName, userName, passNum, date);

            session.save(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("There was an error processing the request. ");
        }
    }


    //TODO: Have login return an id, maybe passNum?  RETURN USER
    public User login(String userName, int passNum) {
        User output = new User();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            System.out.println("Logging in...");

            int userId = getUserIdByPassNum(passNum);

            User user = session.get(User.class, userId);

            if(Objects.equals(user.getUserName(), userName)) {
                System.out.println("Login successful!");
                output = user;
            } else {
                System.out.println("Please try again. ");
                output = null;
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("There was an error processing the request. ");
            output = null;
        }
        return output;
    }

    public User getUserInfo(int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        User user = session.get(User.class, userId);

        UserMapping um = new UserMapping();
        UserData userdata = um.getUserData(session, userId);

        user.setUserData(userdata);

        return user;
    }
}
