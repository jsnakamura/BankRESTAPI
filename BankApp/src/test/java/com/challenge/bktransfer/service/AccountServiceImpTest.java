package com.challenge.bktransfer.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

	private Account umaAccount = new Account(123, "Pessoa", 456);
	
	@Test
	@DisplayName("Service returns expected account")
	public void returnExpectedAccount() {
		// given
		when(accountDAO.getAccount(anyInt())).thenReturn(umaAccount);
		
		Account expectedAccount = new Account(123, "Pessoa", 456);

		// when
		Account account = accountService.getAccount(1);
		
		// then
		assertEquals(expectedAccount, account);
	}
	
	@Test
	@DisplayName("o")
	public void returnExpectedListAccounts() {
		
	}
	
	@Test
	@DisplayName("o")
	public void save() {
		
	}
	
	@Test
	@DisplayName("o")
	public void delete() {
		
	}
}