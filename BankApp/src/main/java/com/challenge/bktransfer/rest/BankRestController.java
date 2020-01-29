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

		bailor.decreaseBalance(entry.getValue());
		depositary.incrementBalance(entry.getValue());

		accountService.saveAccount(bailor);
		accountService.saveAccount(depositary);

		return Arrays.asList(bailor, depositary);
	}

	@PutMapping("/deposit")
	public Account deposit(@RequestBody Entry entry) {
		Account account = accountService.getAccount(entry.getDepositaryAccountNumber());

		account.incrementBalance(entry.getValue());

		accountService.saveAccount(account);

		return account;
	}

	@PutMapping("/withdraw")
	public Account withdraw(@RequestBody Entry entry) {
		Account account = accountService.getAccount(entry.getBailorAccountNumber());

		account.decreaseBalance(entry.getValue());

		accountService.saveAccount(account);

		return account;
	}

	@DeleteMapping("/delete/{accountNumber}")
	public String delete(@PathVariable int accountNumber) {
		Account account = accountService.getAccount(accountNumber);

		if (account == null) {
			throw new AccountNotFoundException("Account number not found - " + accountNumber);
		}

		accountService.deleteAccount(accountNumber);

		return "Deleted account id: " + accountNumber;
	}
}