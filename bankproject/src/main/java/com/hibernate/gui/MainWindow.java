package com.hibernate.gui;

import com.hibernate.Main;

import javax.swing.*;

public class MainWindow {

    public static void mainWindow() {
        JFrame f = new JFrame();
        JLabel name = new JLabel();
        name.setText("Logged In As: " + Main.currentSession.getFirstName() + " " + Main.currentSession.getLastName());
        name.setBounds(5, 5, 300, 20);


        f.add(name);
        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
