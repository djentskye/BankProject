//Tutorial:
//
//https://www.mkyong.com/hibernate/quick-start-maven-hibernate-mysql-example/

package com.hibernate;

import com.hibernate.persistence.HibernateUtil;
import org.hibernate.*;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        //Have code dealing with user input here, get the request and act accordingly
        //Set info for our classes and use session.save(CLASSNAME); to save them

        session.getTransaction().commit();
    }
}
