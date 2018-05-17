package com.hibernate.service;

import com.hibernate.entity.Card;
import com.hibernate.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class CardService {

    public Card getCardByUserId() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();



        session.getTransaction().commit();

        return null;
    }

    public double getCardBalanceByCardId(int id) {
        double balance = -4;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            List<Double> cards = session.createQuery("SELECT dBalance FROM Card WHERE id=" + id).list();

            balance = cards.get(0);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("There was an error processing the request. ");
        }
        return balance;
    }

    public void addToCardByCardId(int id, double amt) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            Card card = (Card)session.get(Card.class, id);

            double newBalance = amt + card.getdBalance();

            card.setdBalance(newBalance);

            session.update(card);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("There was an error processing the request. ");
        }
    }

    public int getCardIdByCardNumber(String cardNum) {
        int cardId;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            List<Integer> cards = session.createQuery("SELECT id FROM Card WHERE cardNumber=" + cardNum).list();

            cardId = cards.get(0);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("There was an error processing the request. ");
            cardId = -1;
        }
        return cardId;
    }
}