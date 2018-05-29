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
        } else if(a.equals("2")) {
            CardService cs = new CardService();

            cs.newCard();

            System.out.println("New card created successfully!");
            iMain();
        } else if(a.equals("3")) {
            CardService cs = new CardService();

            System.out.println("Please enter your card number.");

            double cardBalance = cs.getCardBalanceByCardId(cs.getCardIdByCardNumber(scanner.nextLine()));
            if(cardBalance != -4) {
                System.out.println("The card's balance is $" + cardBalance);
            }
            iMain();
        } else if(a.equals("4")) {
            CardService cs = new CardService();

            int cardId = -1;
            while(cardId == -1) {
                try {
                    System.out.println("Please enter your card number.");

                    cardId = cs.getCardIdByCardNumber(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("This is not valid input.");
                }
            }

            double amt = -1.0;
            while(amt == -1.0) {
                try {
                    System.out.println("Please enter the amount to add.");
                    amt = Double.parseDouble(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("That is not valid input.");
                }
            }
            double cardBalance = cs.addToCardByCardId(cardId, amt);
            if(cardBalance != -1) {
                System.out.println("The card's balance is $" + cardBalance);
            }
            iMain();
        } else if(a.equals("5")) {
            CardService cs = new CardService();

            int cardId = -1;
            while(cardId == -1) {
                try {
                    System.out.println("Please enter your card number.");

                    cardId = cs.getCardIdByCardNumber(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("This is not valid input.");
                }
            }
            double amt = -1.0;
            while(amt == -1.0) {
                try {
                    System.out.println("Please enter the amount to withdraw.");
                    amt = Double.parseDouble(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("That is not valid input.");
                }
            }

            double[] amtWithdrawn = cs.withdrawByCardId(cardId, amt);
            if(amtWithdrawn[0] != -1.0) {
                System.out.println("The amount withdrawn is $" + amtWithdrawn[0]);
            } else {
                System.out.println("The requested amount could not be withdrawn from the " +
                        "specified card. ");
            }
            if(amtWithdrawn[1] != -1.0) {
                System.out.println("The amount left in the card is $" + amtWithdrawn[1]);
            }
            iMain();
        } else {
            System.out.println("Not valid input. Please try again. ");
            System.out.println("");
            System.out.println("");
            iMain();
        }
    }
}
