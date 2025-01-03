package com.mp.onlinebankapplication;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAppImpl bankingApp = new BankAppImpl();

        System.out.println("Create new account");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Create new password: ");
        String password = sc.nextLine();
        System.out.print("Enter balance: ");
        double initialBalance = sc.nextDouble();
        sc.nextLine();

        bankingApp.addAccount(name, password, initialBalance);
        System.out.println("Account created successfully!\n");

        System.out.println("Log in to your account:");
        System.out.print("Enter your name: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String loginPassword = sc.nextLine();

        AccountInterface account = bankingApp.authenticate(username, loginPassword);
        if (account != null) {
            System.out.println("Welcome, " + username + "!");
            while (true) {
                System.out.println("\n1. Deposit");
                System.out.println("2. Check Balance");
                System.out.println("3. Withdraw");
                System.out.println("4. Show Last Five Transactions");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = sc.nextDouble();
                            account.deposite(depositAmount);
                            System.out.println("Deposit successful.");
                            break;
                        case 2:
                            System.out.println("Current Balance: " + account.getBalance());
                            break;
                        case 3:
                            System.out.print("Enter withdraw amount: ");
                            double withdrawAmount = sc.nextDouble();
                            account.transfer(withdrawAmount); 
                            System.out.println("Withdrawal successful.");
                            break;
                        case 4:
                            System.out.println("Last 5 Transactions:");
                            for (Transcation transaction : account.getLastTransactions(5)) {
                                System.out.println(transaction);
                            }
                            break;
                        case 5:
                            System.out.println("Thank you");
                            sc.close();
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Login failed. Invalid Username or password.");
        }
    }
}
