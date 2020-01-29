package com.challenge.bktransfer.service;

import java.util.List;

import com.challenge.bktransfer.entity.Account;

public interface AccountService {

	public List<Account> getAccounts();

	public void saveAccount(Account account);

	public Account getAccount(int accountNumber);

	public void deleteAccount(int accountNumber);
}