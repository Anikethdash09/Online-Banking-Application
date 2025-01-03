package com.mp.onlinebankapplication;

public interface BankAppInterface {
	void addAccount(String username, String password, double startingBalance);
    AccountImpl authenticate(String username, String password);
}
