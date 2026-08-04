package com.novabank;

import java.util.Scanner;

import com.novabank.model.Account;
import com.novabank.model.Customer;
import com.novabank.service.BankService;

/**
 * Main class is the entry point
 * of the NovaBank Banking Information System.
 * It provides the console-based user interface
 * and menu navigation.
 */
public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();
        boolean running = true;
        Customer loggedInCustomer = null;
        while (running) {

            System.out.println("\n========== NOVABANK ==========");
            System.out.println("1. Register Customer");
            System.out.println("2. Customer Login");
            System.out.println("3. Show All Customers");
            System.out.println("4. Show All Accounts");
            System.out.println("5. Search Account");
            System.out.println("6. Exit\n");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    bankService.registerCustomer(sc);
                    break;
                
                case 2:
                    loggedInCustomer = bankService.loginCustomer(sc);
                    if(loggedInCustomer != null){
                        boolean loggedIn = true;
                        System.out.println("Welcome " + loggedInCustomer.getCustomerName());
                        while(loggedIn){
                            System.out.println("\n========== CUSTOMER DASHBOARD ==========");
                            System.out.println("1. View Profile");
                            System.out.println("2. Check Balance");
                            System.out.println("3. Update Profile");
                            System.out.println("4. Deposit Money");
                            System.out.println("5. Withdraw Money");
                            System.out.println("6. Transfer Money");
                            System.out.println("7. Mini Statement");
                            System.out.println("8. Change Password");
                            System.out.println("9. Log Out");
                            System.out.print("Enter Choice : ");
                            int dashboardChoice = sc.nextInt();
                            sc.nextLine();
                            switch(dashboardChoice){
                                case 1:
                                    bankService.viewProfile(loggedInCustomer);
                                    break;

                                case 2:
                                    bankService.checkBalance(loggedInCustomer);
                                    break;
                                
                                case 3:
                                    bankService.updateProfile(loggedInCustomer, sc);
                                    break;
                                
                                case 4:
                                    bankService.depositMoney(loggedInCustomer, sc);
                                    break;

                                case 5:
                                    bankService.withdrawMoney(loggedInCustomer, sc);
                                    break;

                                case 6:
                                    bankService.transferMoney(loggedInCustomer, sc);
                                    break;

                                case 7:
                                    bankService.showMiniStatement(loggedInCustomer);
                                    break;

                                case 8:
                                    bankService.changePassword(loggedInCustomer, sc);
                                    break;

                                case 9:
                                    loggedIn = false;
                                    loggedInCustomer = null;
                                    System.out.println("Logged Out Successfully!");
                                    break;

                                default:
                                    System.out.println("Invalid Choice!");
                            }
                        }
                    }

                    break;
                case 3:
                    bankService.displayCustomers();
                    break;

                case 4:
                    bankService.displayAccounts();
                    break;
                
                case 5:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = sc.nextLine();
                    Account account = bankService.findAccount(accountNumber);
                    if (account != null) {
                        System.out.println(account);
                    } else {
                        System.out.println("Account Not Found!");
                    }break;

                case 6:
                    running = false;
                    System.out.println("Thank you for using NovaBank.");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }

        sc.close();
    }
}