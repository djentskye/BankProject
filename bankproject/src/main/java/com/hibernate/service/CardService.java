package com.hibernate.service;

import com.hibernate.entity.Card;
import com.hibernate.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class CardService {

    public Card getCardByUserId() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();



        session.getTransaction().commit();

        return null;
    }

    public double getCardBalanceByCardId(int id) {
        int a;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            Query query = session.createQuery("SELECT `balance` FROM `card` WHERE `id`=" + id);

            System.out.println(query);
            double balance = -4;

            session.getTransaction().commit();

            return balance;
        } catch (Exception e) {
            System.out.println("There was an error processing the request. ");
            return Integer.parseInt(null);
        }
    }
}
