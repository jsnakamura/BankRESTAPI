package com.challenge.bktransfer.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.bktransfer.entity.*;
import com.challenge.bktransfer.service.AccountService;

@ExtendWith(MockitoExtension.class)
class BankRestControllerTest {

	@Mock
	private AccountService accountService;

	@InjectMocks
	private BankRestController bankRestController;

	private Account anAccount = new Account(123, "Pessoa", 456);

	@Test
	void newaccount() {
		// given

		// when
		Account accountTest = bankRestController.newAccount(anAccount);

		// then
		assertEquals(anAccount.toString(), accountTest.toString());
	}

	@Test
	void transfer() {
		// given		
		Account bailorAccount = new Account(123, "Bailor", 1000);
		Account depositaryAccount = new Account(456, "Depositary", 1000);
		
		Account expectedBailorAccount = new Account(123, "Bailor", 500);
		Account ExpectedDepositaryAccount = new Account(456, "Depositary", 1500);	
		List<Account> expectedList = Arrays.asList(expectedBailorAccount, ExpectedDepositaryAccount);
		
		Entry entry = new Entry();
		entry.setBailorAccountNumber(123);
		entry.setDepositaryAccountNumber(456);
		entry.setValue(500);
		
		when(accountService.getAccount(entry.getBailorAccountNumber())).thenReturn(bailorAccount);
		when(accountService.getAccount(entry.getDepositaryAccountNumber())).thenReturn(depositaryAccount);
		
		// when
		List<Account> actualList = bankRestController.transfer(entry);
		
		// then
		verify(accountService).saveAccount(bailorAccount);
		verify(accountService).saveAccount(depositaryAccount);
		assertTrue(expectedList.equals(actualList));
	}

	@Test
	void deposit() {
		// given
		Account expectedAccount = new Account(123, "Pessoa", 656);
		Entry entry = new Entry();

		entry.setDepositaryAccountNumber(123);
		entry.setValue(200);
		
		when(accountService.getAccount(entry.getDepositaryAccountNumber())).thenReturn(anAccount);

		// when
		Account actualAccount = bankRestController.deposit(entry);

		// then
		verify(accountService).saveAccount(expectedAccount);
		assertEquals(expectedAccount, actualAccount);
	}

	@Test
	void withdraw() {
		// given
		Account expectedAccount = new Account(123, "Pessoa", 256);
		Entry entry = new Entry();

		entry.setBailorAccountNumber(123);
		entry.setValue(200);
		
		when(accountService.getAccount(entry.getBailorAccountNumber())).thenReturn(anAccount);

		// when
		Account actualAccount = bankRestController.withdraw(entry);

		// then
		verify(accountService).saveAccount(expectedAccount);
		assertEquals(expectedAccount, actualAccount);
	}

	@Test
	void delete() {
		// given
		String expectedString = "Deleted account id: 123";
		
		when(accountService.getAccount(anyInt())).thenReturn(anAccount);
		
		// when
		String actualString = bankRestController.delete(123);
		
		// then
		verify(accountService).deleteAccount(123);
		assertEquals(expectedString, actualString);
	}
}
