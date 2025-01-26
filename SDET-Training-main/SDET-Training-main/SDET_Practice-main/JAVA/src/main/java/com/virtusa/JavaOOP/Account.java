package com.virtusa.JavaOOP;

public class Account {
    protected String accountNumber;
    protected double balance;
    protected double interestRate;

    public Account(String accountNumber, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added is - " + interest);
    }

    public void displayDetails() {
        System.out.println("Account Number is - " + accountNumber);
        System.out.println("Balance is - " + balance);
        System.out.println("Interest Rate is - " + interestRate + "%");
    }
}
