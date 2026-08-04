package com.novabank.model;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

/**
 * Transaction class stores every banking
 * transaction performed by a customer.
 * It records transaction type, amount,
 * balance after transaction and date/time.
 */
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    private String accountNumber;
    private String type;
    private double amount;
    private double remainingBalance;
    private LocalDateTime transactionDate;

    public Transaction(String accountNumber, String type, double amount,double remainingBalance) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.remainingBalance = remainingBalance;
        this.transactionDate = LocalDateTime.now();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "\nDate              : " + transactionDate.format(formatter) +
               "\nTransaction Type  : " + type +
               "\nAmount            : ₹" + amount +
               "\nBalance           : ₹" + remainingBalance +
               "\n----------------------------------------";
    }
}