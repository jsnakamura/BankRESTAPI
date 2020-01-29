package com.challenge.bktransfer.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.bktransfer.entity.Account;
import com.challenge.bktransfer.entity.Entry;
import com.challenge.bktransfer.exception.AccountNotFoundException;
import com.challenge.bktransfer.exception.ValueOutOfBoundsException;
import com.challenge.bktransfer.service.AccountService;

@RestController
@RequestMapping("/api")
public class BankRestController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/list")
	public List<Account> listAccounts(Model model) {
		return accountService.getAccounts();
	}

	@PostMapping("/newaccount")
	public Account newAccount(@RequestBody Account account) {
		account.setId(0);

		accountService.saveAccount(account);

		return account;
	}

	@PutMapping("/transfer")
	public List<Account> transfer(@RequestBody Entry entry) {
		Account bailor = accountService.getAccount(entry.getBailorAccountNumber());
		Account depositary = accountService.getAccount(entry.getDepositaryAccountNumber());

		if (bailor == null) {
			throw new AccountNotFoundException("Bailor account number not found - " + entry.getBailorAccountNumber() + ".");
		} 
		else if (depositary == null) {
			throw new AccountNotFoundException("Depositary account number not found - " + entry.getDepositaryAccountNumber() + ".");
		}
		else if(entry.getValue() > bailor.getBalance() ) {
			throw new ValueOutOfBoundsException("Bailor - " + bailor.getAccountNumber() + " doesnt have enough funds.");
		}
		
		bailor.decreaseBalance(entry.getValue());
		depositary.increaseBalance(entry.getValue());

		accountService.saveAccount(bailor);
		accountService.saveAccount(depositary);

		return Arrays.asList(bailor, depositary);
	}

	@PutMapping("/deposit")
	public Account deposit(@RequestBody Entry entry) {
		Account account = accountService.getAccount(entry.getDepositaryAccountNumber());

		if (account == null) {
			throw new AccountNotFoundException("Account number not found - " + entry.getDepositaryAccountNumber() + ".");
		}
		
		account.increaseBalance(entry.getValue());

		accountService.saveAccount(account);

		return account;
	}

	@PutMapping("/withdraw")
	public Account withdraw(@RequestBody Entry entry) {
		Account account = accountService.getAccount(entry.getBailorAccountNumber());

		if (account == null) {
			throw new AccountNotFoundException("Account number not found - " + entry.getBailorAccountNumber() + ".");
		} 
		else if(entry.getValue() > account.getBalance() ) {
			throw new ValueOutOfBoundsException("You dont have enough funds.");
		}
		
		account.decreaseBalance(entry.getValue());

		accountService.saveAccount(account);

		return account;
	}

	@DeleteMapping("/delete/{accountNumber}")
	public String delete(@PathVariable int accountNumber) {
		Account account = accountService.getAccount(accountNumber);

		if (account == null) {
			throw new AccountNotFoundException("Account number not found - " + accountNumber + ".");
		}

		accountService.deleteAccount(accountNumber);

		return "Deleted account id: " + accountNumber;
	}
}