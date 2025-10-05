package com.pu.lab3;

import java.util.Scanner;

public class DriverMainClass_PatriciaAnneUsal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        // create an account from user input
        System.out.println("Create an account:");
        System.out.print("Account number: ");
        String accNo = scanner.nextLine().trim();
        System.out.print("Initial balance: ");
        double bal;
        
        while (true) {
            String line = scanner.nextLine().trim();
            
            try {
                java.math.BigDecimal bd = new java.math.BigDecimal(line);
                bal = bd.doubleValue();
                if (bal < 0) {
                    System.out.print("Initial balance cannot be negative. Enter again: ");
                    continue;
                }
                break;
                
            } catch (NumberFormatException ex) {
                System.out.print("Please enter a valid numeric balance: ");
            }
        }

        BankAccount_PU account = new SavingsAccount_PU(accNo, bal);

        //deposit/withdrawal loop
        System.out.println("\n--- Menu ---");
        
        while (true) {
            System.out.printf("Current balance: $%.2f%n", account.getBalance());
            System.out.println("Choose: deposit | withdraw | exit");
            System.out.print("Action: ");
            String action = scanner.nextLine().trim().toLowerCase();
            
            switch (action) {
                
                case "deposit": {
                    double amount;
                    while (true) {
                        System.out.print("Enter deposit amount: ");
                        String amtLine = scanner.nextLine().trim();
                        try {
                            java.math.BigDecimal bd = new java.math.BigDecimal(amtLine);
                            amount = bd.doubleValue();
                            if (amount <= 0) {
                                System.out.println("Amount must be positive.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                        }
                    }
                    account.deposit(amount);
                    break;
                }

                case "withdraw": {
                    double amount;
                    while (true) {
                        System.out.print("Enter withdrawal amount: ");
                        String amtLine = scanner.nextLine().trim();
                        try {
                            java.math.BigDecimal bd = new java.math.BigDecimal(amtLine);
                            amount = bd.doubleValue();
                            if (amount <= 0) {
                                System.out.println("Amount must be positive.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                        }
                    }
                    account.withdraw(amount);
                    break;
                }
                
                case "exit":
                    System.out.println("Exiting. Goodbye.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown action. Please type deposit, withdraw, or exit.");
                    break;
            }
        }
    }
}
