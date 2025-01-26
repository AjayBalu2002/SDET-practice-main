package com.virtusa.JavaOOP;

public class TestAccount {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SBI00080", 12345, 1.5);
        System.out.println("Savings Account Details are: ");
        savingsAccount.displayDetails();
        savingsAccount.calculateInterest();
        savingsAccount.displayDetails();

        System.out.println();

        CurrentAccount currentAccount = new CurrentAccount("YES00010", 15000, 0);
        System.out.println("Current Account Details are :");
        currentAccount.displayDetails();
        currentAccount.calculateInterest();
        currentAccount.displayDetails();
    }
}
