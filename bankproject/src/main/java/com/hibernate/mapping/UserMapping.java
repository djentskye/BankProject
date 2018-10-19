package com.hibernate.mapping;

import com.hibernate.entity.User;
import com.hibernate.entity.UserData;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.data.annotation.QueryAnnotation;

import javax.persistence.NamedQuery;
import java.util.Date;
import java.util.List;

public class UserMapping {

//    @NamedQuery(query = "")
//    User getUserData(int id) {
//
//        return User;
//    }

    public UserData getUserData(Session session, int userId) {
//        User userDat = new User();
//        List<User> userG = session.createQuery
//                ("SELECT address FROM User JOIN UserData WHERE User.id = user_data.id").list();
//
//        System.out.println(userId);
//        UserData userG = (UserData) session.createQuery("SELECT UserData FROM UserData where id=" + userId).list().get(0);
        UserData userG = new UserData();

        userG.setId(userId);


        String hql = "SELECT gender FROM UserData where id=" + userId;
        Query query = session.createQuery(hql);
        List results = query.list();
        System.out.println("RESULTS 1: " + results);
        if(results != null && results.size() > 0) {
//            System.out.println(results);
//            System.out.println(results.get(0).toString());
            userG.setGender(results.get(0).toString());
        }

        String hql2 = "SELECT address FROM UserData where id=" + userId;
        Query query2 = session.createQuery(hql2);
        List results2 = query2.list();
        System.out.println("RESULTS 2: " + results2);
        if(results2 != null && results2.size() > 0) {
//            System.out.println(results);
//            System.out.println(results.get(0).toString());
            userG.setAddress(results2.get(0).toString());
        }

        String hql3 = "SELECT birthdate FROM UserData where id=" + userId;
        Query query3 = session.createQuery(hql3);
        List results3 = query3.list();
        System.out.println("RESULTS 3: " + results3);
        if(results3 != null && results3.size() > 0) {
//            System.out.println(results);
//            System.out.println(results.get(0).toString());
            userG.setBirthdate((Date) results3.get(0));
        }


//        userDat.setGender(userG.get(0).getGender());
//
//        List<UserData> userB = session.createQuery("SELECT birthdate FROM UserData WHERE id=" + userId).list();
//
//        userDat.setBirthdate(userB.get(0).getBirthdate());
//
//        List<UserData> userA = session.createQuery("SELECT address FROM UserData WHERE id=" + userId).list();
//
//        userDat.setAddress(userA.get(0).getAddress());

//        UserData a = session.get(UserData.class, userId);
//        userDat.setGender(a.getGender());
//        userDat.setBirthdate(a.getBirthdate());
//        userDat.setAddress(a.getAddress());

        return userG;
    }
}
