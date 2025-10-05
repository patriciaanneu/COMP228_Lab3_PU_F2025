package com.pu.lab3;



public class SavingsAccount_PU extends BankAccount_PU {
	
	public SavingsAccount_PU(String accountNumber, double balance) {
		super(accountNumber, balance);
		
	}
	
	//setting the minimum balance of 50
	private static final double minBalance = 50.0;
	
	//prevent withdrawals that would drop the balance below the minimum
	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Withdrawal must be positive.");
			return;
		}
		
		if (amount > balance) {
			System.out.println("Insufficient funds. Withdrawal cancelled.");
			return;
		}
		
		double newBalance = balance - amount;
		
		if (newBalance < minBalance) {
			System.out.println("Withdrawal denied. Must keep at least $" + minBalance);
			return;
		}
		
		balance = newBalance;
		System.out.println("Whithdrew $" + amount + ". New balance: $" + balance);
	}
}
