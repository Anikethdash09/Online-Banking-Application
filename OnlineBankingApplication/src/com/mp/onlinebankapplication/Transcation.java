package com.mp.onlinebankapplication;

public class Transcation {
	
	private String type;
	private double amount;
	private double balance;
	
	public Transcation(String type, double amount, double balance) {
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transcation [type=" + type + ", amount=" + amount + ", balance=" + balance + "]";
	}
}
