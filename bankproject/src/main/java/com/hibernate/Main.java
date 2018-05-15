//Tutorials:
//
//https://www.mkyong.com/hibernate/quick-start-maven-hibernate-mysql-example/
//https://www.tutorialspoint.com/hibernate/hibernate_examples.htm

package com.hibernate;

import com.hibernate.entity.Card;
import com.hibernate.persistence.HibernateUtil;
import com.hibernate.service.CardService;
import org.hibernate.*;

public class Main {

    public static void performTransaction() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        //Have code dealing with user input here, get the request and act accordingly
        //Set info for our classes and use session.save(CLASSNAME); to save them

        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        //Get general input, perform transaction, etc.

        CardService cardService = new CardService();

        System.out.println(cardService.getCardBalanceByCardId(2));
    }
}
