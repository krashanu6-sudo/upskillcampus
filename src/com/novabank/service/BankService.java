package com.novabank.service;

import java.util.Scanner;
import com.novabank.util.IdGenerator;
import java.util.ArrayList;
import com.novabank.model.Account;
import com.novabank.model.Customer;
import com.novabank.model.Transaction;
import com.novabank.model.Admin;
import com.novabank.storage.DataStorage;

/**
 * BankService class contains all the banking operations
 * such as customer registration, login, deposit,
 * withdrawal, fund transfer, profile management,
 * transaction history and data persistence.
 *
 * Author : Krashanu
 * Project : NovaBank Banking Information System
 */
public class BankService {
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;
    private Admin admin;

    public BankService() {
        customers = DataStorage.loadData("customers.dat");
        accounts = DataStorage.loadData("accounts.dat");
        transactions = DataStorage.loadData("transactions.dat");
        admin = new Admin("admin", "admin123");
        if (!customers.isEmpty()) {
            String lastCustomerId =customers.get(customers.size() - 1).getCustomerId();
            int id = Integer.parseInt(lastCustomerId.substring(1));
            IdGenerator.setCustomerCounter(id + 1);
        }
        if (!accounts.isEmpty()) {
            String lastAccount =accounts.get(accounts.size() - 1).getAccountNumber();
            int acc =Integer.parseInt(lastAccount.substring(2));
            IdGenerator.setAccountCounter(acc + 1);
        }
    }

    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No Customers Found!");
            return;
        }
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No Accounts Found!");
            return;
        }
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void registerCustomer(Scanner sc) {
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Create Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Opening Balance: ");
        double openingBalance;
        try {
            openingBalance = sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid amount entered!");
            sc.nextLine();
            return;
        }

        String customerId = IdGenerator.generateCustomerId();
        String accountNumber = IdGenerator.generateAccountNumber();

        Customer customer = new Customer(customerId,customerName,phoneNumber,email,address,password);

        Account account = new Account(accountNumber,customerId,"Savings",openingBalance);

        customers.add(customer);
        accounts.add(account);
        addTransaction(accountNumber,"Account Opened",openingBalance,openingBalance);

        System.out.println("\n==================================");
        System.out.println(" Customer Registered Successfully!");
        System.out.println("==================================");
        System.out.println("Customer ID      : " + customerId);
        System.out.println("Account Number   : " + accountNumber);
        System.out.println("Opening Balance  : ₹" + openingBalance);
        System.out.println("==================================");
        saveAllData();
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    
    public Customer findCustomer(String customerId){
        for(Customer customer : customers){
            if(customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        return null;
    }

    public Customer loginCustomer(Scanner sc){
        System.out.print("Enter Customer ID: ");
        String customerId = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Customer customer = findCustomer(customerId);

        if(customer == null){
            System.out.println("Customer Not Found!");
            return null;
        }

        if(customer.getPassword().equals(password)){
            System.out.println("\nLogin Successful!");
            return customer;
        }

        System.out.println("Incorrect Password!");
        return null;
    }
    public Account findAccountByCustomerId(String customerId){
        for(Account account : accounts){
            if(account.getCustomerId().equals(customerId)){
                return account;
            }
        }
        return null;
    }

    public void viewProfile(Customer customer) {
        System.out.println("\n========== CUSTOMER PROFILE ==========");
        System.out.println(customer);
    }

    public void checkBalance(Customer customer) {
        Account account = findAccountByCustomerId(customer.getCustomerId());

        if(account == null){
            System.out.println("Account Not Found!");
            return;
        }
        System.out.println("\n========== ACCOUNT DETAILS ==========");
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Current Balance : ₹" + account.getBalance());
    }

    public void depositMoney(Customer customer, Scanner sc) {
        Account account = findAccountByCustomerId(customer.getCustomerId());
        if(account == null){
            System.out.println("Account Not Found!");
            return;
        }
        System.out.print("Enter Deposit Amount: ");
        double amount;
        try {
            amount = sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid amount entered!");
            sc.nextLine();
            return;
        }
        if(amount <= 0){
            System.out.println("Invalid Amount!");
            return;
        }
        account.setBalance(account.getBalance() + amount);
        addTransaction(account.getAccountNumber(),"Deposit",amount,account.getBalance());
        System.out.println("\nDeposit Successful!");
        System.out.println("Current Balance : ₹" + account.getBalance());
        saveAllData();
    }

    public void updateProfile(Customer customer, Scanner sc) {
        System.out.println("\n====== UPDATE PROFILE ======");
        System.out.print("Enter New Phone Number : ");
        String phone = sc.nextLine();
        System.out.print("Enter New Email : ");
        String email = sc.nextLine();
        System.out.print("Enter New Address : ");
        String address = sc.nextLine();

        customer.setPhoneNumber(phone);
        customer.setEmail(email);
        customer.setAddress(address);

        System.out.println("\nProfile Updated Successfully!");
        saveAllData();
    }

    public void withdrawMoney(Customer customer, Scanner sc) {
        Account account = findAccountByCustomerId(customer.getCustomerId());
        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }
        System.out.print("Enter Withdraw Amount: ");
        double amount;
        try {
            amount = sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid amount entered!");
            sc.nextLine();
            return;
        }
        if (amount <= 0) {
            System.out.println("Invalid Amount!");
            return;
        }
        if (amount > account.getBalance()) {
            System.out.println("Insufficient Balance!");
            return;
        }
        account.setBalance(account.getBalance() - amount);
        addTransaction(account.getAccountNumber(), "Withdraw",amount, account.getBalance());
        System.out.println("\nWithdrawal Successful!");
        System.out.println("Remaining Balance : ₹" + account.getBalance());
        saveAllData();
    }

    public void transferMoney(Customer customer, Scanner sc){
        Account sender = findAccountByCustomerId(customer.getCustomerId());
        if(sender == null){
            System.out.println("Account Not Found!");
            return;
        }
        System.out.print("Enter Receiver Account Number: ");
        String receiverAccountNumber = sc.nextLine();
        Account receiver = findAccount(receiverAccountNumber);
        if(receiver == null){
            System.out.println("Receiver Account Not Found!");
            return;
        }
        if(sender.getAccountNumber().equals(receiver.getAccountNumber())){
            System.out.println("You cannot transfer money to your own account.");
            return;
        }
        System.out.print("Enter Amount: ");
        double amount;
        try {
            amount = sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid amount entered!");
            sc.nextLine();
            return;
        }
        if(amount <= 0){
            System.out.println("Invalid Amount!");
            return;
        }
        if(amount > sender.getBalance()){
            System.out.println("Insufficient Balance!");
            return;
        }
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
        addTransaction(sender.getAccountNumber(),"Transfer",amount,sender.getBalance());
        addTransaction(receiver.getAccountNumber(),"Received",amount,receiver.getBalance());
        System.out.println("\nTransfer Successful!");
        System.out.println("Transferred Amount : ₹" + amount);
        System.out.println("Remaining Balance : ₹" + sender.getBalance());
        saveAllData();
    }

    public void addTransaction(String accountNumber,String type,double amount,double remainingBalance) {
        transactions.add(new Transaction(accountNumber,type,amount,remainingBalance));
    }

    public void showMiniStatement(Customer customer){
        Account account =
        findAccountByCustomerId(customer.getCustomerId());
        if(account == null){
            System.out.println("Account Not Found!");
            return;
        }
        System.out.println("\n====== MINI STATEMENT ======");
        boolean found = false;
        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber().equals(account.getAccountNumber())) {
                System.out.println(transaction);
                    found = true;
            }
        }
        if (!found) {
            System.out.println("No Transactions Found!");
        }
    }

    public void changePassword(Customer customer, Scanner sc) {
        System.out.print("Enter Current Password: ");
        String currentPassword = sc.nextLine();
        if (!customer.getPassword().equals(currentPassword)) {
            System.out.println("Incorrect Current Password!");
            return;
        }
        System.out.print("Enter New Password: ");
        String newPassword = sc.nextLine();
        System.out.print("Confirm New Password: ");
        String confirmPassword = sc.nextLine();
        if (!newPassword.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            return;
        }
        if(newPassword.isBlank()){
            System.out.println("Password cannot be empty!");
            return;
        }
        customer.setPassword(newPassword);
        System.out.println("Password Changed Successfully!");
        saveAllData();
    }

    public boolean adminLogin(Scanner sc){
        System.out.print("Enter Admin ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        if(admin.getAdminId().equals(id)&& admin.getPassword().equals(password)){
            System.out.println("\nAdmin Login Successful!");
            return true;
        }
        System.out.println("Invalid Admin Credentials!");
        return false;
    }

    public void saveAllData() {
        DataStorage.saveData(customers, "customers.dat");
        DataStorage.saveData(accounts, "accounts.dat");
        DataStorage.saveData(transactions, "transactions.dat");
    }

}
