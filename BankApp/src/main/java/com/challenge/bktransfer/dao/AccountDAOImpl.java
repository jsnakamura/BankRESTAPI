package com.challenge.bktransfer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.challenge.bktransfer.entity.Account;

/**
 * @author Juliano Nakamura
 *
 */
@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Account> getAccounts() {
		Session session = sessionFactory.getCurrentSession();

		Query<Account> query = session.createQuery("from Account order by id", Account.class);

		List<Account> accounts = query.getResultList();

		return accounts;
	}

	@Override
	public void saveAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(account);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Account getAccount(int accountNumber) {
		Session session = sessionFactory.getCurrentSession();

		return (Account) session.createQuery("from Account where accountNumber = :accountNumber")
				.setParameter("accountNumber", accountNumber).getResultList().stream().findFirst().orElse(null);
	}

	@Override
	public void deleteAccount(int accountNumber) {
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("delete from Account where accountNumber = :accountNumber");

		query.setParameter("accountNumber", accountNumber);

		query.executeUpdate();
	}
}