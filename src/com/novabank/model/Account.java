package com.novabank.model;

import java.io.Serializable;

/**
 * Account class represents a bank account.
 * It stores account number, customer ID,
 * account type and current balance.
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    private String accountNumber;
    private String customerId;
    private String accountType;
    private double balance;

    public Account(String accountNumber,String customerId,String accountType,double balance){
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\n========== ACCOUNT DETAILS ==========" +
               "\nAccount Number : " + accountNumber +
               "\nCustomer ID    : " + customerId +
               "\nAccount Type   : " + accountType +
               "\nBalance        : ₹" + balance +
               "\n=====================================";
    }

}