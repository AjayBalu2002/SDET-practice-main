package com.virtusa.JavaOOP;

public class CurrentAccount extends Account {

    public CurrentAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance, interestRate);
    }

    @Override
    public void calculateInterest() {
        System.out.println("Current Account does not accrue interest.");
    }
}
