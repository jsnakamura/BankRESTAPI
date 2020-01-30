package com.challenge.bktransfer.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.bktransfer.dao.AccountDAO;
import com.challenge.bktransfer.entity.Account;

/**
 * @author Juliano Nakamura
 *
 */
@ExtendWith(MockitoExtension.class)
class AccountServiceImpTest {

	@Mock
	private AccountDAO accountDAO;

	@InjectMocks
	private AccountServiceImp accountService;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
	}

	private Account anAccount = new Account(123, "Pessoa", 456);

	@Test
	@DisplayName("Service returns expected account from DAO")
	public void returnExpectedAccount() {
		// given
		Account expectedAccount = new Account(123, "Pessoa", 456);

		when(accountDAO.getAccount(anyInt())).thenReturn(anAccount);

		// when
		Account account = accountService.getAccount(1);

		// then
		assertEquals(expectedAccount, account);
	}

	@Test
	@DisplayName("Service returns a List of accounts from DAO")
	public void returnExpectedListAccounts() {
		// given
		@SuppressWarnings("unchecked")
		List<Account> expectedList = mock(List.class);
		expectedList.add(new Account(123, "Pessoa", 456));

		when(accountDAO.getAccounts()).thenReturn(expectedList);

		// when
		List<Account> actualList = accountService.getAccounts();

		// then
		assertEquals(expectedList, actualList);
	}

	@Test
	@DisplayName("Service calls save method from DAO")
	public void save() {
		// given

		// when
		accountService.saveAccount(anAccount);

		// then
		verify(accountDAO).saveAccount(anAccount);
	}

	@Test
	@DisplayName("Service calls delete method from DAO")
	public void delete() {
		// given

		// when
		accountService.deleteAccount(anyInt());

		// then
		verify(accountDAO).deleteAccount(anyInt());
	}
}