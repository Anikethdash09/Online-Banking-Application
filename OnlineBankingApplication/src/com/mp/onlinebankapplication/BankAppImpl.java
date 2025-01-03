package com.mp.onlinebankapplication;

import java.util.HashMap;
import java.util.Map;

public class BankAppImpl implements BankAppInterface{
	private Map<String, AccountImpl> accounts;

    public BankAppImpl() {
        this.accounts = new HashMap<>();
    }

	@Override
	public void addAccount(String username, String password, double startingBalance) {
		
		accounts.put(username, new AccountImpl(username, password, startingBalance));
		
	}

	@Override
	public AccountImpl authenticate(String username, String password) {
		AccountImpl account = accounts.get(username);
        if (account != null && account.login(username, password)) {
            return account;
        }
        return null;
	}
}
