package com.hibernate.io;

import com.hibernate.service.CardService;

import java.util.Scanner;

public class PostLoginInput {

    /**
     * The main class for post-login UI
     */
    public static void iMain() {
        System.out.println();
        System.out.println("MENU: ");
        System.out.println("1. Modify User Info");
        System.out.println("2. New Card");
        System.out.println("3. Get Card Balance");
        System.out.println("4. Add to Card");
        System.out.println("5. Withdraw from Card");
        //TODO: We need a new option for listing card information

        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();

        if(a.equals("1")) {
            //TODO: Add modification options for user info
        }
        if(a.equals("2")) {
            CardService cs = new CardService();

            cs.newCard();

            System.out.println("New card created successfully!");
            iMain();
        }
        if(a.equals("3")) {
            CardService cs = new CardService();

            System.out.println("Please enter your card number.");

            double cardBalance = cs.getCardBalanceByCardId(cs.getCardIdByCardNumber(scanner.nextLine()));
            if(cardBalance != -4) {
                System.out.println("The card's balance is $" + cardBalance);
            }
            iMain();
        }
    }
}
