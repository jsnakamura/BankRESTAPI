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
import com.challenge.bktransfer.entity.RequestEntry;
import com.challenge.bktransfer.exception.AccountNotFoundException;
import com.challenge.bktransfer.exception.ValueOutOfBoundsException;
import com.challenge.bktransfer.service.AccountService;

/**
 * @author Juliano Nakamura
 *
 */
@RestController
@RequestMapping("/")
public class BankRestController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
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
	public List<Account> transfer(@RequestBody RequestEntry requestEntry) {
		Account bailor = accountService.getAccount(requestEntry.getBailorAccountNumber());
		Account depositary = accountService.getAccount(requestEntry.getDepositaryAccountNumber());

		if (bailor == null) {
			throw new AccountNotFoundException(
					"Bailor account number not found - " + requestEntry.getBailorAccountNumber() + ".");
		} else if (depositary == null) {
			throw new AccountNotFoundException(
					"Depositary account number not found - " + requestEntry.getDepositaryAccountNumber() + ".");
		} else if (requestEntry.getValue() > bailor.getBalance()) {
			throw new ValueOutOfBoundsException("Bailor - " + bailor.getAccountNumber() + " doesnt have enough funds.");
		}

		bailor.decreaseBalance(requestEntry.getValue());
		depositary.increaseBalance(requestEntry.getValue());

		accountService.saveAccount(bailor);
		accountService.saveAccount(depositary);

		return Arrays.asList(bailor, depositary);
	}

	@PutMapping("/deposit")
	public Account deposit(@RequestBody RequestEntry requestEntry) {
		Account account = accountService.getAccount(requestEntry.getDepositaryAccountNumber());

		if (account == null) {
			throw new AccountNotFoundException(
					"Account number not found - " + requestEntry.getDepositaryAccountNumber() + ".");
		}

		account.increaseBalance(requestEntry.getValue());

		accountService.saveAccount(account);

		return account;
	}

	@PutMapping("/withdraw")
	public Account withdraw(@RequestBody RequestEntry requestEntry) {
		Account account = accountService.getAccount(requestEntry.getBailorAccountNumber());

		if (account == null) {
			throw new AccountNotFoundException(
					"Account number not found - " + requestEntry.getBailorAccountNumber() + ".");
		} else if (requestEntry.getValue() > account.getBalance()) {
			throw new ValueOutOfBoundsException("You dont have enough funds.");
		}

		account.decreaseBalance(requestEntry.getValue());

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