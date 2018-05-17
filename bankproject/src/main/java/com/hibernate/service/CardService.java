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
        int a;

        double balance = -4;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;


        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            Query query = session.createQuery("SELECT dBalance FROM Card WHERE id=" + id);

            List<Double> cards = session.createQuery("SELECT dBalance FROM Card WHERE id=" + id).list();

            balance = cards.get(0);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("There was an error processing the request. ");
//            return Integer.parseInt(null);
        }
        return balance;


//        try {
//            tx = session.beginTransaction();
//            List<Card> cards = session.createQuery("SELECT dBalance FROM Card WHERE id=" + id).list();
////            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
////                Employee employee = (Employee) iterator.next();
////                System.out.print("First Name: " + employee.getFirstName());
////                System.out.print("  Last Name: " + employee.getLastName());
////                System.out.println("  Salary: " + employee.getSalary());
////            }
//            Card card = cards.get(0);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
    }
}
