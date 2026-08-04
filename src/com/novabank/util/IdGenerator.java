package com.novabank.util;

/**
 * IdGenerator generates unique
 * customer IDs and account numbers.
 */
public class IdGenerator {

    private static int customerCounter = 1;
    private static int accountCounter = 100001;

    public static void setCustomerCounter(int value) {
        customerCounter = value;
    }

    public static void setAccountCounter(int value) {
        accountCounter = value;
    }

    public static String generateCustomerId() {

        return "C" + String.format("%03d", customerCounter++);

    }

    public static String generateAccountNumber() {

        return "SB" + accountCounter++;

    }

}
