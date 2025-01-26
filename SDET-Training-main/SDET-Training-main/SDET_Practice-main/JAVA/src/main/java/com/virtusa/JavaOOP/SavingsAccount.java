package com.virtusa.JavaOOP;

public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance, interestRate);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Savings Account Interest added is - " + interest);
    }
}
