package com.hibernate.service;

import com.hibernate.Main;
import com.hibernate.entity.Card;
import com.hibernate.persistence.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.Random;

public class CardService {

    public void newCard() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            Random random = new Random();
            //CODE FOR GENERATING CARD NUMBERS NEEDS TO BE REPLACED. Previous card numbers
            //must be factored in as well. We don't want duplicates.
            String cardNumber = String.valueOf(random.nextInt(99999) + 10000);

            Card card = new Card(0.0, cardNumber, Main.currentSession.getId());

            System.out.println("New card number is " + cardNumber);

            session.save(card);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("There was an error processing the request. ");
        }
    }

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

            List<Integer> ids = session.createQuery("SELECT userId FROM Card WHERE " +
                    "id=" + id).list();

            if(Main.currentSession.getId() == ids.get(0)) {
                List<Double> cards = session.createQuery("SELECT dBalance FROM Card " +
                        "WHERE id=" + id).list();

                balance = cards.get(0);
            } else {
//                System.out.println("Sorry, this account is not permitted to access " +
//                        "information on that card. ");
                throw new Exception();
            }

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
