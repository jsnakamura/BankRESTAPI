package com.challenge.bktransfer.dao;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;

import com.challenge.bktransfer.entity.Account;

/**
 * @author Juliano Nakamura
 *
 */

@ExtendWith(MockitoExtension.class)
class AccountDAOImplTest {
	
	@Mock
	private SessionFactory sessionFactory;
	
	@Mock
	private List<Account> listAccounts;
	
	@InjectMocks
	private AccountDAOImpl accountDAO;
	
	@Mock
	private Account accountTest;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	@SuppressWarnings("unchecked")
	void accounts() {
		// given
		Session session = mock(Session.class);
		
		Query<Account> query = mock(Query.class);
		
		// when
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		
		when(session.createQuery("from Account order by id", Account.class)).thenReturn(query);
		
		when(query.getResultList()).thenReturn(listAccounts);
		
		@SuppressWarnings("unused")
		List<Account> listAccount = accountDAO.getAccounts();
		
		// then
		verify(sessionFactory).getCurrentSession();
		verify(session).createQuery("from Account order by id", Account.class);
		verify(query).getResultList();
	}

	@Test
	void save() {
		// given
		Session session = mock(Session.class);
		
		// when
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		
		accountDAO.saveAccount(accountTest);
		
		// then
		verify(session).saveOrUpdate(accountTest);		
	}

	@Test
	void get() {
		// given

		// when

		// then
	}

	@Test
	void delete() {
		// given

		// when

		// then
	}
}
