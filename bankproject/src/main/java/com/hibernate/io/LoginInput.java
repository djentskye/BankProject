package com.hibernate.io;

import com.hibernate.Main;
import com.hibernate.entity.User;
import com.hibernate.service.UserService;

import java.util.Objects;
import java.util.Scanner;

public class LoginInput {

    public static void iLoginPage() {
        System.out.println("Welcome to David's Banking program!");
        System.out.println("Please login or create a new user. ");
        System.out.println("1. Login");
        System.out.println("2. New User");
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();

        if(Objects.equals(a, "1")) {iLogin();}
        else if(Objects.equals(a, "2")) {iNewUser();}
    }

    public static void iLogin() {
        UserService us = new UserService();
        String f = "";
        String l = "";
        int pass = -1;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Please enter your first name: ");
            f = scanner.nextLine();
            System.out.print("Please enter your last name: ");
            l = scanner.nextLine();
            System.out.print("Please enter your passport number: ");
            pass = Integer.parseInt(scanner.nextLine());
        } catch(Exception e) {
            System.out.println("Please enter valid input. ");
        }

//        try {
//            User newUser = us.login(f, l, pass);
//            if(newUser != null) {
//                Main.currentSession = newUser;
//            } else {
//                throw new Exception();
//            }
//            PostLoginInput.iMain();
//        } catch(Exception e) {
//            iLogin();
//        }
    }

    public static void iNewUser() {
        UserService us = new UserService();
        String f = "";
        String l = "";
        int pass = -1;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Please enter your first name: ");
            f = scanner.nextLine();
            System.out.print("Please enter your last name: ");
            l = scanner.nextLine();
            System.out.print("Please enter your passport number: ");
            pass = Integer.parseInt(scanner.nextLine());
        } catch(Exception e) {
            System.out.println("Please enter valid input. ");
            //Split up parts into modules
        }

        /*us.newUser(f, l, pass);

        try {
            User newUser = us.login(f, l, pass);
            if(newUser != null) {
                Main.currentSession = newUser;
            } else {
                throw new Exception();
            }
            PostLoginInput.iMain();
        } catch(Exception e) {
            iLogin(); //This shouldn't happen, only if the database info is different
        }*/
    }
}
