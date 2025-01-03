package com.mp.onlinebankapplication;

import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements AccountInterface{
	
	private String username;
	private String password;
	private double balance;
	private List<Transcation> transactionHis;
	
	
	public AccountImpl(String username,String password,double balance) {
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.transactionHis = new ArrayList<>();
		addTransaction("Initial Balance", 0, balance);
	}
	

	private void addTransaction(String type, double amount, double balance) {
		transactionHis.add(new Transcation(type, amount, balance));
	}


	@Override
	public boolean login(String username, String password) {
		
		return this.username.equals(username)&&this.password.equals(password);
	}


	@Override
	public double getBalance() {
		
		return balance;
	}


	@Override
	public void deposite(double amount) {
		if(amount<0) {
			throw new IllegalArgumentException("Deposite amount must be positive");
		}
		balance += amount;
		addTransaction("Deposite",amount,balance);
		
	}


	@Override
	public void transfer(double amount) {
		if(amount<=0) {
			throw new IllegalArgumentException("transfer amount must be positive");
		}
		balance -= amount;
		addTransaction("Transfer",amount,balance);
	}


	@Override
	public List<Transcation> getLastTransactions(int n) {
		int start = Math.max(0, transactionHis.size() - n);
        return transactionHis.subList(start, transactionHis.size());
	}


	 

}
