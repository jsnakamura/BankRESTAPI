package com.challenge.bktransfer.dao;

import java.util.List;

import com.challenge.bktransfer.entity.Account;

public interface AccountDAO {
	
	public List<Account> getAccounts();
	
	public void saveAccount(Account account);
	
	public Account getAccount(int accountNumberValue);
	
	public void deleteAccount(int accountNumber);
}