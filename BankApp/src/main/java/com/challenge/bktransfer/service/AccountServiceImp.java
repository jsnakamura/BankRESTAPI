package com.challenge.bktransfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.challenge.bktransfer.dao.AccountDAO;
import com.challenge.bktransfer.entity.Account;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Override
	@Transactional
	public List<Account> getAccounts() {
		return accountDAO.getAccounts();
	}

	@Override
	@Transactional
	public void saveAccount(Account account) {
		accountDAO.saveAccount(account);
	}

	@Override
	@Transactional
	public Account getAccount(int accountNumber) {
		return accountDAO.getAccount(accountNumber);
	}

	@Override
	@Transactional
	public void deleteAccount(int accountNumber) {
		accountDAO.deleteAccount(accountNumber);
	}
}