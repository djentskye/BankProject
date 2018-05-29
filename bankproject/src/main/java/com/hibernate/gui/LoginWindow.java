package com.hibernate.gui;

import com.hibernate.Main;
import com.hibernate.entity.User;
import com.hibernate.io.PostLoginInput;
import com.hibernate.service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {
    public static void loginWindow() {
        JFrame f = new JFrame();

        JTextField firstName = new JTextField();
        firstName.setBounds(50, 50, 300, 20);
        JTextField lastName = new JTextField();
        lastName.setBounds(50, 90, 300, 20);
        JPasswordField passNum = new JPasswordField();
        passNum.setBounds(50, 130, 300, 20);

        JButton login = new JButton("Log In");
        login.setBounds(50, 170, 125, 30);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserService us = new UserService();
                    User newUser = us.login(firstName.getText(), lastName.getText(), Integer.parseInt(String.valueOf(passNum.getPassword())));
                    if(newUser != null) {
                        Main.currentSession = newUser;
                    } else {
                        throw new Exception();
                    }
//                    PostLoginInput.iMain(); //TODO: FIX THIS SOON
                    MainWindow.mainWindow();
                } catch(Exception r) {
                    System.out.println("Login Not Successful");
                }
            }
        });

        JButton newUser = new JButton("Sign Up");
        newUser.setBounds(225, 170, 125, 30);

        f.add(firstName);
        f.add(lastName);
        f.add(passNum);
        f.add(login);
        f.add(newUser);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
