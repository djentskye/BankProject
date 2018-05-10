package com.hibernate.maven.backend;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;

import javax.imageio.spi.ServiceRegistry;
import javax.security.auth.login.Configuration;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

//    static Session sessionObj;
//    static SessionFactory sessionFactoryObj;
//    static ServiceRegistry serviceRegistry;
//
//    private static SessionFactory buildSessionFactory() {
//        Configuration configObj = new Configuration();
//        configObj.configure("hibernate.cfg.xml");
//
//        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
//
//        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistry);
//
//        return sessionFactoryObj;
//    }
//
//    private void btnPress() {
//        try {
//            sessionObj = buildSessionFactory().openSession();
//            sessionObj.beginTransaction();
//
//
//            userObj = new User();
//
//            userObj.setUserName(userName.getText());
//            userObj.setUserPassword(Encode.encode(password.getText()));
//            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//            Date a = new Date();
//            Date dateWithoutTime = formatter.parse(formatter.format(a));
//            userObj.setUserCreatedDate(dateWithoutTime);
//
//            sessionObj.save(userObj);
//
//            System.out.println("Records saved correctly!");
//
//            sessionObj.getTransaction().commit();
//
//        } catch (Exception sqlException) {
//            if(null != sessionObj.getTransaction()) {
//                System.out.println("Transaction being rolled back");
//                sessionObj.getTransaction().rollback();
//            }
//            sqlException.printStackTrace();
//        } finally {
//            if(sessionObj!=null) {
//                sessionObj.close();
//            }
//        }
//    }

    public static void main(String[] args) {
        //
    }
}
