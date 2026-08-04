package com.novabank.model;

import java.io.Serializable;

/**
 * Customer class stores all customer-related
 * information such as customer ID, name,
 * phone number, email, address and password.
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;

    public Customer(String customerId,String customerName,String phoneNumber,String email,String address,String password) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "\n========== CUSTOMER DETAILS ==========" +
               "\nCustomer ID   : " + customerId +
               "\nName          : " + customerName +
               "\nPhone Number  : " + phoneNumber +
               "\nEmail         : " + email +
               "\nAddress       : " + address +
               "\n======================================";
    }
}


