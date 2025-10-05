package com.pu.lab3;

public class BankAccount_PU {

	private final String accountNumber;
	protected double balance;
	
	public BankAccount_PU(String accountNumber, double balance) {
		if (accountNumber == null || accountNumber.trim().isEmpty()) {
			throw new IllegalArgumentException("Account number must be provided");
		}
		if (balance < 0) {
			throw new IllegalArgumentException("Initial balance cannot be negative");
		}
		this.accountNumber = accountNumber.trim();
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Deposit amount must be positve");
			return;
		}
		balance += amount;
		System.out.println("Deposited $" + String.format("%.2f", amount) + " into account " + accountNumber);
	}
	
	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Withdrawal amount must be positive.");
			return;
		}
		if (amount > balance) {
			System.out.println("Insufficient funds. Withdrawal cancelled.");
			return;
		}
		balance -= amount;
		System.out.println("Withdrew $" + String.format("%.2f", amount) + " from account " + accountNumber);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String toString() {
		return String.format("Account %s: balance = $%.2f", accountNumber, balance);
	}
}