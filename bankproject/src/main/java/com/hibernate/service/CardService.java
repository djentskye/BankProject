package com.hibernate.service;

import com.hibernate.CardType;
import com.hibernate.Main;
import com.hibernate.entity.Card;
import com.hibernate.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CardService {

    public Card newCard(CardType cardType, int userId) {
        Card card = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            int a = 1;
            while (a == 1) {
                try {
                    Random random = new Random();
                    //CODE FOR GENERATING CARD NUMBERS NEEDS TO BE REPLACED. Previous card numbers
                    //must be factored in as well. We don't want duplicates.
                    String cardNumber = String.valueOf(random.nextInt(99999) + 10000);
                    int pinNumber = random.nextInt(999);

                    card = new Card(cardType, 0.0, cardNumber, userId, pinNumber);

                    System.out.println("New card number is " + cardNumber);

                    session.save(card);
                    if (session.getTransaction().getStatus()!= TransactionStatus.COMMITTED) {
                        session.getTransaction().commit();
                    }

                    a = 2;
                } catch (Exception e) {
                    System.out.println("Attempted to create card.");
                    a = 0;
                }
            }

//            session.getTransaction().commit();
            return card;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("There was an error processing the request. ");
            return null;
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

            if (Main.currentSession.getId() == ids.get(0)) {
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

    public double addToCardByCardId(int id, double amt) {
        double rVal = -1.0;
        if (amt > 0) {
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();

                session.beginTransaction();

                Card card = (Card) session.get(Card.class, id);

                double newBalance = amt + card.getdBalance();
                rVal = newBalance;

                card.setdBalance(newBalance);

                session.update(card);

                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("There was an error processing the request. ");
            }
        }
        return rVal;
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

    public double[] withdrawByCardId(int id, double amtToWithdraw) {
        //rVal[1] stores the amount left in the account, rVal[0] stores the amout withdrawn
        double rVal[] = {-1.0, -1.0};
        if (amtToWithdraw > 0.0) {
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();

                session.beginTransaction();

                Card card = (Card) session.get(Card.class, id);

                if (card.getdBalance() > amtToWithdraw) {
                    rVal[1] = card.getdBalance() - amtToWithdraw;
                    card.setdBalance(rVal[1]);
                    rVal[0] = amtToWithdraw;
                }

                session.update(card); //Do we need this?

                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("There was an error processing the request. ");
            }
        }
        return rVal;
    }
}
