package com.mp.onlinebankapplication;

import java.util.List;

public interface AccountInterface {
	boolean login(String username, String password);
	double getBalance();
	void deposite(double amount);
	void transfer(double amount);
	List<Transcation> getLastTransactions(int n);
}
